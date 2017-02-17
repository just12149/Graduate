/**
 * Created by wangchong on 2017/2/17.
 */
(function (angular) {
    var serviceModule = angular.module("mainService", []);
    serviceModule.service("myService", function ($http) {

       this.newsType=function(params){
           return ajaxRequest(context+"/news/newsType.do",params)
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