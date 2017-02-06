/**
 * Created by Administrator on 2015/11/9.
 */
angular.module('stringFilter',[])
    //保留number个字符，其它使用...
    .filter('retain',function(){
        return function(txt,number){
            if(txt){
                return txt.length>number?txt.substr(0,number)+'...':txt;
            }else{
                return "";
            }
        }
    })
    /**
     * 加密 各保留字串前后 retainStart retainLast字符，其余用code代替
     *当 retainStart＝15 retainLast＝0，code＝‘……’时，可达到与 retain|15一样的效果
     * 当  retainStart  retainLast code 为 undefined时，默认处理 18729206197为187****6197
     */
    .filter('encrypt',function(){
        return function(txt,retainStart,retainLast,code){
            if(retainStart==undefined)retainStart=3;
            if(retainLast==undefined)retainLast=4;
            if(code==undefined)code="****";
            if(txt){
                var re = new RegExp("^(.{"+retainStart+"}).*(.{"+retainLast+"})$","ig");

                return txt.replace(re,"$1"+code+"$2");
            }else{
                return "";
            }
        }
    })
