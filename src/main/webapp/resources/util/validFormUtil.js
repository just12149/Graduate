/**
 * 常用校验
 */

(function($) {
    $.validFormUtil = {
        /**
         * 校验输入框长度
         * @param str 目标字符串
         * @param isNull 是否可为空 true是，false 否
         * @param minLength 最小长度
         * @param maxlength 最大长度
         * @return 校验通过返回false
         */
        inputLength : function(str,isNull,minLength,maxLength){
            if(str==""){
                if(!isNull){
                    return true;
                }
            }
            if(str.trim().length==0){
                if(!isNull){
                    return true;
                }
            }
            str = str.trim();
            if(str.length < minLength){
                return true;
            }
            if(str.length > maxLength){
                return true;
            }
            return false;
        },
        /**
         * 使用传入的正则表达式，校验字符串
         * @param str 目标字符串
         * @param isNull 是否可为空 true是，false 否
         * @param regular 正则表达式
         * @returns 校验通过返回false
         */
        inputType : function(str,isNull,regular){
            if(str==""){
                if(!isNull){
                    return true;
                }
            }
            if(str.trim().length==0){
                if(!isNull){
                    return true;
                }
            }
            return regular.test(str.trim());
        }
    }
})(jQuery);
