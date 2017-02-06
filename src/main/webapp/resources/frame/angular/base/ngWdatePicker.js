/**
 * Created by Administrator on 2015/11/4.
 */

/**
 * 使用 My97DatePicker
 *
 * 内部使用了 My97DatePicker 的 onpicked
 */
angular.module("ngWdatePicker",[])
    .directive('ngWdatePicker', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attrs, ngModel) {
            if (!ngModel) {
                return;
            }
            element.bind("click", function () {
                var opt=scope.$eval(attrs.ngWdatePicker)||{};
                var opts;
                if(opt.onpicked){
                    var onpickedFun=opt.onpicked;
                    opts = angular.extend({
                        onpicked: function (dp) {
                            onpickedFun(dp);
                            ngModel.$setViewValue(dp.cal.getDateStr());
                            scope.$digest();
                        }
                    }, opt);
                }else{
                    opts = angular.extend({
                        onpicked: function (dp) {
                            ngModel.$setViewValue(dp.cal.getDateStr());
                            scope.$digest();
                        }
                    }, opt);
                }

                WdatePicker(opts);
            });
        }
    };
})