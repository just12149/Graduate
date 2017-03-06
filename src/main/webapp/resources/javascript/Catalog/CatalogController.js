/**
 * Created by Administrator on 2016/11/29.
 */
(function(){

    var myApp = angular.module("CatalogApp", ["CatalogApp.service", "CatalogApp.Filters", "ngTable", "ngCommonFilter"]);
    myApp.controller("CatalogCtrl", function ($scope, $http, NgTableParams, myService, $filter) {
        $scope.myTable = new NgTableParams(
            {
                page: 1,
                count: 5
            },
            {
                counts: [5, 10, 15],
                getData: function ($defer, params) {
                    var param = {};
                    param.currentPage = params.page();
                    param.rowPerPage = params.count();
                    myService.queryPageDatas(param).success(function (data) {
                        //alert(data);
                        if (data.success) {
                            // $scope.groupList = data.userList;
                            if (!data.success) {
                                return;
                            }
                            $scope.myTable.total(data.totalNum);
                            if (!data.catalogList) {
                                $defer.resolve(null);
                                return;
                            }
                            $defer.resolve(data.catalogList)
                        }
                        else {
                            alert(data.msg);

                        }
                    });
                }

            }
        )
        /**
         *删除数据
         */

        $scope.remove = function (catalog, currentPage) {

            if (confirm("确定删除?")) {

                myService.delCatalogId({delCatalogId:catalog.id})
                    .success(function (data) {
                        if (data.success) {
                            alert("删除成功");
                            $scope.myTable.reload();
                        }
                        else {
                            alert("删除失败");
                        }
                    });
            }
        }
        /**
         *
         * @type {boolean}
         * 修改数据
         */
        $scope.isDiv = true;
        /* $scope.update=function(updateUser){

         $('#myModal').modal('show');
         $scope.user=updateUser;
         }*/
        $scope.catalog = {};
        $scope.update = function (catalog) {
            alert("aaa");
            if (catalog) {
                alert(catalog);
                $scope.catalog = catalog;
                $('#myModal').modal('show');

            }
          /*  if (catalog) {
                /!*news.removeAttr('$$hashKey');
                 $.extend($scope.news,news);*!/
                $.each(catalog, function(i, val) {
                    if(i != '$$hashKey'){
                        $scope.catalog[i] = val;
                    }
                });
                /!*alert(news);
                 $scope.news = news;*!/
                $('#myModal').modal('show');

            }*/
            else {
                $scope.user={
                    catalogName:"请输入姓名",
                    catalogId:0

                };
                $('#myModal').modal('show');
            }
        }


        /**
         * 提交表单信息
         */

        $scope.mform = function () {
            if ($scope.myForm.$valid) {
                myService.updateCatalog($scope.catalog/*{
                    newsId : 1,
                    title : '123',
                    author : '234',
                    createdTime : '2017-01-05',
                    url : '',
                    newstype : 2
                }*/).success(function(data) {
                    if (data.success) {
                        alert("数据修改成功");
                        $scope.myTable.reload();
                        //   console.log($scope.isDiv);

                        $('#myModal').modal('toggle');
                    } else {
                        alert("数据修改失败");
                    }
                });

            }
            else {
                if (!$scope.myForm.title.$dirty) {
                    $scope.myForm.title.$dirty = true;
                    $scope.isName = true;
                }

            }
        }
        /**
         * 取消提交表单
         */

        $scope.mUnform=function(){
            $scope.isDiv=false;
            myService.queryPageDatas({}).success(function(data){
                if(data.success){
                    $scope.newsList=data.catalogList;
                    $('#myModal').modal('toggle');
                }
                else{
                    alert(data.msg);
                }
            });

        }
        /**
         * 重置表单信息
         */
        $scope.reset=function(){

            $scope.user = {
                title:"请输入标题",
                author:"请输入作者",
                newstype:1,


            }
            $scope.isDiv=true;
        }
    });


})();