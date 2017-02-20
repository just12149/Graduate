/**
 * Created by Administrator on 2016/11/29.
 */
(function (angular) {

    var myApp = angular.module("NewsApp", ["NewsApp.service", "NewsApp.Filters", "ngTable", "ngCommonFilter"]);
    myApp.controller("NewsCtrl", function ($scope, $http, NgTableParams, myService, $filter) {
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
                    param.newstype = $scope.isActive

                    myService.queryPageDatas(param).success(function (data) {
                        //alert(data);
                        if (data.success) {
                            // $scope.groupList = data.userList;
                            if (!data.success) {
                                return;
                            }
                            $scope.myTable.total(data.totalNum);
                            if (!data.newsList) {
                                $defer.resolve(null);
                                return;
                            }
                            $defer.resolve(data.newsList)
                        }
                        else {
                            alert(data.msg);

                        }
                    });
                }

            }
        )




        $scope.Catalogs =
            [
                { id: 1, name: "科技新闻" },
                { id: 2, name: "财经新闻" },
                { id: 3, name: "体育新闻" },
                { id: 4, name: "民生新闻" },
                { id: 5, name: "娱乐新闻" },
                { id: 6, name: "教育新闻" }];



    //    <!--提交按钮-->
        /**
         对选中的组别进行查询
         */
        $scope.isActive = null;
        $scope.Check = function (index) {
            $scope.isActive = index;
            $scope.myTable.goFirst();
        }
        /**
         *删除数据
         */

        $scope.remove = function (news, currentPage) {

            if (confirm("确定删除?")) {

                myService.delnewsId({delnewsId: news.newsId})
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
        $scope.news = {};
        $scope.update = function (news) {
            if (news) {
                alert(news);
                $scope.news = news;
                $('#myModal').modal('show');
            }
            /*  if (news) {
             /!* news.removeAttr('$$hashKey');
             $.extend($scope.news,news);*!/
             $.each(news, function(i, val) {
             if(i != '$$hashKey'){
             $scope.news[i] = val;
             }
             });
             /!*  alert(news);
             $scope.news = news;*!/
             $('#myModal').modal('show');

             }*/
            else {

                alert("添加新闻");
                $scope.news = {
                    title: "请输入姓名",
                    author: 0,
                    newstype: 1
                };
                $('#myModal').modal('show');
            }
        }

        /**
         * 提交表单信息
         */


        $scope.mform = function () {
            if ($scope.myForm.$valid) {

                //$scope.user.birthDay=new Date();
                myService.updateNews($scope.news/*{
                 newsId : 1,
                 title : '123',
                 author : '234',
                 createdTime : '2017-01-05',
                 url : '',
                 newstype : 2
                 }*/).success(function (data) {
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

        $scope.mUnform = function () {
            $scope.isDiv = false;
            myService.queryPageDatas({}).success(function (data) {
                if (data.success) {
                    $scope.newsList = data.newsList;
                    $('#myModal').modal('toggle');
                }
                else {
                    alert(data.msg);
                }
            });

        }
        /**
         * 重置表单信息
         */
        $scope.reset = function () {

            $scope.user = {
                title: "请输入标题",
                author: "请输入作者",
                newstype: 1,


            }
            $scope.isDiv = true;
        }
    });


})(angular);