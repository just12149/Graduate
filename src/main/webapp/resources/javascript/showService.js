/**
 * Created by wangchong on 2017/2/6.
 */
(function (angular) {
    var serviceModule = angular.module("showService", []);
    serviceModule.service("myService", function ($http) {

        this.querynewsByid = function (params) {
            return ajaxRequest(context + "/news/newsData.do", params);
        }

        function ajaxRequest(url,param){
            return $http.post(url, param, {
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'},
                transformRequest: function (data) {
                    return $.param(data);
                }
            })
        }
    });

})(angular)