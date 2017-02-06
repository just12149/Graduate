/**
 * Created by Administrator on 2016/11/29.
 */
(function(angular){
    var filterModule = angular.module("myNoteApp.Filters", []);
    /**
     * 对描述进行截取
     */
    filterModule.filter("lengthFilter", function () {
        return function (description, len) {
            if (description) {
                if (description.length > len)
                    description = description.substring(0, len) + "...";
            }
            return description;
        }
    });





    /**
     * 对组别进行判断
     */
    filterModule.filter("newsFilter", function () {
        return function (type) {
            if (type == 1) {
                return "科技"
            }
            if (type == 2) {
                return "财经"
            }
            if (type == 3) {
                return "体育"
            }
            if (type == 4) {
                return "民生"
            }
            if (type == 5) {
                return "娱乐"
            }
            if (type == 6) {
                return "教育"
            }

        }

    });

})(angular);