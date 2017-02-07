/**
 * Created by wangchong on 2017/2/6.
 */
(function(angular){
    var app=angular.module("showApp",["showService"]);
    app.controller("showCtrl",function($scope,myService){
        myService.querynewsByid({newsId:2}).success(function(data){
            if(data.success){
               $scope.groupList=data.list;
            }
        })
    })
})(angular)