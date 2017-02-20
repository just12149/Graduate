/**
 * Created by wangchong on 2017/2/17.
 */
(function(angular){
    var mainModule=angular.module("mainApp",["mainService"]);
    mainModule.controller("mainCtrl",function($scope,myService){
        $scope.doClick=function(num){
            myService.newsType({catalogId:num}).success(function(data){
                if(data.success){
                    $scope.newsList=data.newsList;
                }
            })
        }

    })
})(angular)