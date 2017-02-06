/**
 * @Discription ndoa
 * @Author      zhaoxiaojun
 * @CreateDate  2016/5/5  11:16
 * @Version     1.0
 */
(function(angular) {
    var module = angular.module("ngCommonFilter", []);
    module.factory('UserInterceptor', ["$q", "$rootScope", function ($q, $rootScope) {
        function param(obj) {
            if (obj == undefined || obj == null) {
                throw "undefine and null is not be allow";
            }
            if (!obj instanceof Object) {
                throw "param must be a object";
            }
            if (obj instanceof Array) {
                throw "array is  not be allow";
            }
            var ar = [];
            for (k in obj) {
                var v = !obj[k] ? "" : obj[k];
                ar.push(k + "=" + v);
            }
            return ar.join("&").replace(/%20/g, "+");
        }

        return {
            request: function (config) {
                if (config.method == 'POST') {
                    config.headers['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8';
                    config.headers['X-Requested-With'] = "XMLHttpRequest";
                    config.transformRequest = function (data) {
                        if (data) {
                            return param(data);
                        }

                    }
                }
                return config;
            },
            responseError: function (response) {
                //var data = response.data;
                // 判断错误码，如果是未登录
                //if (response && response.status == 999) {
                //    window.location.href = context + "/user/tologin.do";
               // }

            }
        };
    }]).config(function ($httpProvider) {
        $httpProvider.interceptors.push('UserInterceptor');
    });

})(angular);