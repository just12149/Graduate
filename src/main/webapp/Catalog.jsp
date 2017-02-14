<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/10
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath();%>


<html>
<head>
    <title>栏目管理</title>
    <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/angular.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/ngTable.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/boostrap3.jsp"></jsp:include>
    <link href="<%=context%>/resources/frame/bootstrap3/css/test.css" rel="stylesheet" type="text/css"/>

    <script src="<%=context%>/resources/javascript/Catalog/CatalogController.js"></script>
    <script src="<%=context%>/resources/javascript/Catalog/CatalogFilter.js"></script>
    <script src="<%=context%>/resources/javascript/Catalog/CatalogService.js"></script>
    <script src="<%=context%>/resources/frame/bootstrap3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>新闻列表</h1>
    </div>
    <%--  <ul class="nav nav-tabs">
        <li class="active" ng-class="{0:'active'}[isActive]" ng-click="Check(0)"><a href="#">全部新闻</a></li>
        <li ng-class="{1:'active'}[isActive]" ng-click="Check(1)"><a href="#">科技</a></li>
        <li ng-class="{2:'active'}[isActive]" ng-click="Check(2)"><a href="#">财经</a></li>
        <li ng-class="{3:'active'}[isActive]" ng-click="Check(3)"><a href="#">体育</a></li>
        <li ng-class="{4:'active'}[isActive]" ng-click="Check(4)"><a href="#">民生</a></li>
        <li ng-class="{5:'active'}[isActive]" ng-click="Check(5)"><a href="#">娱乐</a></li>
        <li ng-class="{6:'active'}[isActive]" ng-click="Check(6)"><a href="#">教育</a></li>
      </ul>--%>

    <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
            try {
                ace.settings.check('breadcrumbs', 'fixed')
            } catch (e) {
            }
        </script>
        <!--足迹开始-->
        <ul class="breadcrumb">
            <li>
                <i class="icon-home home-icon"></i>
                <a href="#">首页</a>
            </li>
            <li class="active">栏目管理</li>
        </ul>
        <!-- .breadcrumb -->
        <!--足迹结束-->
    </div>
    <div class=" col-xs-3" style="float: right">
        <button type="button" class="btn btn-primary" ng-click="update()"><i class="glyphicon glyphicon-plus"></i>添加新闻
        </button>
    </div>
    <%-- <div class=" col-xs-3" style="float: right">
       栏目名称:<input type="text" ng-id="Catalog.Name">
     </div>

     <div class=" col-xs-3" style="float: right">
       <img src="<%=context%>/resources/images/query_icon.png">
     </div>--%>
    <table class="table" ng-table="myTable" style="text-align: center;" width="100%" border="0" cellspacing="20"
           cellpadding="20">

        <tr class="lb-bg" ng-repeat="catalog in $data">

            <td data-title="'栏目标题'" ng-bind="catalog.catalogName" width="20%">栏目标题</td>
            <td data-title="'栏目Id'" ng-bind="catalog.CatalogId" width="10%">栏目Id</td>
           <td data-title="'创建时间'" ng-bind="catalog.createdTime" width="10%">创建时间</td>

            <td data-title="'操作'">操作
                <button type="button" class="btn btn-default btn-lg" ng-click="update(catalog)">
                    <i class="glyphicon glyphicon-pencil"></i>修改新闻
                </button>

                <button type="button" class="btn btn-default btn-lg" ng-click="remove(catalog)">
                    <i class="glyphicon glyphicon-remove-circle"></i>删除新闻
                </button>
            </td>
        </tr>
    </table>


    <%--修改,新增弹出页面--%>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h2 class="modal-title" id="myModalLabel">请填写栏目信息</h2>
                </div>

                <form name="myForm" ng-model="catalog" class="form-horizontal" role="form">
                    <div class=" form-group" style="padding-top: 20px;"
                         ng-class="{true: 'has-error'}[myForm.title.$dirty && myForm.title.$invalid]">
                        <label class="col-sm-2 control-label">栏目标题:</label>

                        <div class="col-sm-9">
                            <input name="title" type="text" class="form-control" ng-model="catalog.catalogName"
                                   value="catalog.catalogName" required/>

                            <div class="alert alert-danger"
                                 ng-show="myForm.title.$dirty && myForm.title.$invalid">
                                <span ng-show="myForm.title.$error.required">title is required.</span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group" style="padding-top: 20px;">
                        <label class="col-sm-2 control-label">栏目类别:</label>

                        <div class="col-sm-9">
                            <input name="author" type="text" class="form-control" ng-model="catalog.catalogId"
                                   value="catalog.catalogId" required/>

                            <div class="alert alert-danger"
                                 ng-show="myForm.author.$dirty && myForm.author.$invalid">
                                <span ng-show="myForm.author.$error.required">catalogId is required.</span>
                            </div>
                        </div>
                    </div>


                    <div class="modal-footer" align="center" style="padding-top: 30px;">
                        <button class="btn btn-primary btn-lg " title="确认提交" ng-click="mform()">确认提交</button>
                        <button class="btn btn-primary btn-lg " title="取消 " ng-click="mUnform()">取消提交</button>
                        <button class="btn btn-primary btn-lg " title="重置 " ng-click="reset()">重置</button>
                    </div>
                </form>
            </div>

        </div>
    </div>


</div>
</body>
</html>
