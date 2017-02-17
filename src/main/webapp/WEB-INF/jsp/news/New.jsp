<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/3
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% String context = request.getContextPath();%>
<html>
<head>
    <title>新闻列表</title>

    <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/angular.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/ngTable.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/boostrap3.jsp"></jsp:include>


    <link href="<%=context%>/resources/frame/bootstrap3/css/test.css" rel="stylesheet" type="text/css"/>

    <script src="<%=context%>/resources/javascript/news/newsController.js"></script>
    <script src="<%=context%>/resources/javascript/news/newsService.js"></script>
    <script src="<%=context%>/resources/javascript/news/newsFilter.js"></script>
    <script src="<%=context%>/resources/frame/bootstrap3/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=context%>/resources/frame/ueditor-1.4.3.3/ueditor.config.js"></script>
    <script type="text/javascript" src="<%=context%>/resources/frame/ueditor-1.4.3.3/ueditor.all.js"></script>
    <script type="text/javascript" src="<%=context%>/resources/frame/angular/base/directive/angular-ueditor.js"></script>
</head>
<body ng-app="NewsApp" ng-controller="NewsCtrl">
<div class="container">
    <div class="page-header">
        <h1>新闻列表</h1>
    </div>
    <ul class="nav nav-tabs">
        <li class="active" ng-class="{0:'active'}[isActive]" ng-click="Check(0)"><a href="#">全部新闻</a></li>
        <li ng-class="{1:'active'}[isActive]" ng-click="Check(1)"><a href="#">科技</a></li>
        <li ng-class="{2:'active'}[isActive]" ng-click="Check(2)"><a href="#">财经</a></li>
        <li ng-class="{3:'active'}[isActive]" ng-click="Check(3)"><a href="#">体育</a></li>
        <li ng-class="{4:'active'}[isActive]" ng-click="Check(4)"><a href="#">民生</a></li>
        <li ng-class="{5:'active'}[isActive]" ng-click="Check(5)"><a href="#">娱乐</a></li>
        <li ng-class="{6:'active'}[isActive]" ng-click="Check(6)"><a href="#">教育</a></li>
    </ul>
    <div class=" col-xs-3" style="float: right">
        <button type="button" class="btn btn-primary" ng-click="update()"><i class="glyphicon glyphicon-plus"></i>添加新闻
        </button>
    </div>
    <table class="table" ng-table="myTable" style="text-align: center;" width="100%" border="0" cellspacing="20"
           cellpadding="20">

        <tr class="lb-bg" ng-repeat="news in $data">
            <td data-title="'新闻类别'" ng-bind="news.newstype|newsFilter" width="10%"></td>
            <td data-title="'标题'" ng-bind="news.title" width="40%"></td>
            <td data-title="'作者'" ng-bind="news.author" width="10%"></td>
            <%--<td data-title="'创建时间'" ng-bind="news.createdTime" width="10%"></td>
--%>
            <td data-title="'操作'">
                <button type="button" class="btn btn-default btn-lg" ng-click="update(news)">
                    <i class="glyphicon glyphicon-pencil"></i>修改新闻
                </button>

                <button type="button" class="btn btn-default btn-lg" ng-click="remove(news)">
                    <i class="glyphicon glyphicon-remove-circle"></i>删除新闻
                </button>
            </td>
        </tr>
    </table>


    <%--修改,新增弹出页面--%>

    <%--<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h2 class="modal-title" id="myModalLabel">请填写新闻内容</h2>
                </div>

                <form name="myForm" ng-model="news" class="form-horizontal" role="form">
                    <div class=" form-group"  style="padding-top: 20px;"
                         ng-class="{true: 'has-error'}[myForm.title.$dirty && myForm.title.$invalid]">
                        <label class="col-sm-2 control-label">标题:</label>
                        <div class="col-sm-9">
                            <input name="title" type="text" class="form-control" ng-model="news.title"
                                   value="news.title" required/>
                            <div class="alert alert-danger"
                                 ng-show="myForm.title.$dirty && myForm.title.$invalid">
                                <span ng-show="myForm.title.$error.required">title is required.</span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group" style="padding-top: 20px;">
                        <label class="col-sm-2 control-label">作者:</label>
                        <div class="col-sm-9">
                            <input name="author" type="text" class="form-control" ng-model="news.author"
                                   value="news.author" required/>
                            <div class="alert alert-danger"
                                 ng-show="myForm.author.$dirty && myForm.author.$invalid">
                                <span ng-show="myForm.author.$error.required">author is required.</span>
                            </div>
                        </div>
                    </div>


                    <div class="form-group" style="padding-top: 20px;">
                        <label class="col-sm-2 control-label">新闻类别:</label>
                        <select ng-init="news.newstype = types[0]" name="newstype" ng-model="news.newstype"
                                ng-options="x for x in types" >
                        </select>

                    </div>

              &lt;%&ndash; <div class="form-group" style="padding-top: 20px;">
                        <label class="col-sm-2 control-label">新闻类别:{{news.newstype}}</label>
                        <input type="radio" name="groupNum" ng-model="news.newstype" ng-checked="news.newstype==1"
                               ng-checked="true"   ng-value="1"/>科技新闻&nbsp;&nbsp;
                        <input type="radio" name="groupNum" ng-model="news.newstype" ng-checked="news.newstype==2"
                               ng-value="2"/>财经新闻&nbsp;&nbsp;
                        <input type="radio" name="groupNum" ng-model="news.newstype" ng-checked="news.newstype==3"
                               ng-value="3"/>体育新闻&nbsp;&nbsp;
                        <input type="radio" name="groupNum" ng-model="news.newstype" ng-checked="news.newstype==4"
                               ng-value="4"/>民生新闻 &nbsp;&nbsp;
                        <input type="radio" name="groupNum" ng-model="news.newstype" ng-checked="news.newstype==5"
                               ng-value="5"/>娱乐新闻&nbsp;&nbsp;
                        <input type="radio" name="groupNum" ng-model="news.newstype" ng-checked="news.newstype==6"
                               ng-value="6"/>教育新闻&nbsp;&nbsp;
                        <input type="radio" name="groupNum" ng-model="news.newstype" ng-checked="news.newstype==7"
                               ng-value="4"/>民生新闻
                    </div>&ndash;%&gt;
                    <div class="form-group" style="padding-top: 20px;">
                        <label class="col-sm-2 control-label">创建时间:</label>

                        <div class="col-sm-9">
                            <input name="createdTime" type="text" class="form-control" ng-model="news.createdTime"
                                   value="news.createdTime" required/>
                        </div>
                    </div>

                    <div class="form-group" style="padding-top: 20px;">
                        <label class="col-sm-2 control-label">新闻内容:</label>
                        <div class="col-sm-9">
                            <textarea rows="2" cols="20" ng-model="news.url"></textarea>
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
    </div>--%>



    <!--  模态框 新增/编辑页面 开始  -->
    <div class="modal fade" id="myModal" tabindex="100" role="dialog" aria-labelledby="editMainContentLabel">
        <div class="modal-dialog" role="document" style="width: 1000px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" ng-click="closeWin()">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="editMainContentLabel">编辑内容</h4>
                </div>
                <div class="modal-body form-inline" style="height:680px;overflow-y: auto">
                    <form id="editForm" class="form-inline">
                        <table class="table table-condensed" >
                            <tr>
                                <td align="left" >
                                    <div class="form-group">
                                        <input type="hidden" id="mainId" name="mainId" ng-model="main.mainId"/>
                                        <label for="title">标题<span style="color: red;">*</span></label>
                                        <input type="text" name="title" class="form-control" id="title" ng-model="main.title" ng-blur="checkTitle()">
                                        <span id="titleSpan" style="color: #a94442;display: none;">标题不能为空!</span>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td align="left" >
                                    <div class="form-group">
                                        <label for="subtitle">副标题</label>
                                        <input type="text" name="subtitle" class="form-control" id="subtitle" ng-model="main.subtitle">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td align="left" >
                                    <div class="form-group">
                                        <label for="subtitle">作者</label>
                                        <input type="text" name="author" class="form-control" id="author" ng-model="main.author">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td align="left" >
                                    <div class="form-group">
                                        <label for="subtitle">排序号(从大到小)</label>
                                        <input type="text" name="mainOrder" class="form-control" id="mainOrder" ng-model="main.mainOrder">
                                    </div>
                                </td>
                            </tr>
                            <tr ng-repeat="label in labelFromList">
                                <td align="left" >
                                    <div class="form-group">
                                        <label for="{{label.labelCode}}">{{label.labelName}}</label>
                                        <input type="text" name="{{label.labelCode}}" class="form-control" id="{{label.labelCode}}" ng-model="label.labelValue">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td align="left" >
                                    <div class="form-group">
                                        <label for="attachment">附件</label>
                                        <input type="text" name="attachment" class="form-control" id="attachment" ng-model="attachment">
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td align="left" >
                                    <div class="form-group">
                                        <label for="subtitle">摘要</label>
                                        <textarea type="text" name="summary" class="form-control" id="summary" ng-model="main.summary" rows="5"></textarea>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td align="left" >
                                    <label style="float: left">正文</label>
                                    <div style="float: left;margin-bottom:1.25rem;width: 700px;height: 400px" class="ueditor" ng-model="main.mainContent"></div>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div class="modal-footer" align="center" style="padding-top: 30px;">
                    <button class="btn btn-primary btn-lg " title="确认提交" ng-click="mform()">确认提交</button>
                    <button class="btn btn-primary btn-lg " title="取消 " ng-click="mUnform()">取消提交</button>
                    <button class="btn btn-primary btn-lg " title="重置 " ng-click="reset()">重置</button>
                </div>
            </div>
        </div>
    </div>


























</div>
</body>
</html>
