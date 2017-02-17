/**
 * Created by wangchong on 2017/2/17.
 */
(function(angular){
    var mainModule=angular.module("mainApp",["mainService"]);
    mainModule.controller("mainCtrl",function($scope,myService){
       var columnId=null;
        $scope.keji=function(){
            columnId=1;
            myService.newsType({newsType:columnId}).success(function(data){
                if(data.success){
                    $scope.newsList=data.newsList;
                }
            })
        }

    })
})(angular)