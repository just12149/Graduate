<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/6
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath();%>
<html>
<head>
    <title>数据支撑</title>

    <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/angular.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/echarts3.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/boostrap3.jsp"></jsp:include>
    <script src="<%=context%>/resources/javascript/common/commonChart.js"></script>
    <script src="<%=context%>/resources/javascript/userData/userData.js"></script>

    <link rel="stylesheet" type="text/css" href="<%=context%>/resources/css/base1.css"/>
    <link rel="stylesheet" type="text/css" href="<%=context%>/resources/css/styles1.css"/>


</head>
<body ng-app="userDataApp" ng-controller="udController">
<jsp:include page="/WEB-INF/jsp/menu/top_menu.jsp">
    <jsp:param name="currentMenu" value="sjzy"></jsp:param>
</jsp:include>
<div class="main">
    <jsp:include page="/WEB-INF/jsp/menu/tjsj_left_menu.jsp">
        <jsp:param name="leftMenu" value="sifa"></jsp:param>
    </jsp:include>

    <div class="content">

        <div class="box mb20">
            <div class="box_title clearfix">
                <i class="box_icon"></i>

                <p class="box_name">养老保险参保人数统计分析</p>
            </div>
            <div class="box_main">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td width="50%">
                            <div class="column_transverse column_transverse_orange">
                                <div class="column_transverse_left">
                                    <div>
                                        <p>城镇企职工</p>
                                        <table border="0" cellspacing="0"
                                               cellpadding="0">
                                            <tr>
                                                <td><b id="cz">0.98%</b>
                                                </td>
                                                <td>
                                                    <i class="column_transverse_down"></i>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <div class="column_transverse_right">
                                    <table width="100%" border="0" cellspacing="0"
                                           cellpadding="0">
                                        <tr>
                                            <td class="column_transverse_name">上月
                                            </td>
                                            <td class="column_transverse_div">
                                                <div><p class="column_transverse_p1"
                                                        id="p_cz_sy"></p><span
                                                        id="cz_sy">4100097</span>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="column_transverse_name">本月
                                            </td>
                                            <td class="column_transverse_div">
                                                <div><p class="column_transverse_p2"
                                                        style="width: 100%;"
                                                        id="p_cz_by"></p><span
                                                        id="cz_by">4140147</span>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </td>
                        <td width="50%">
                            <div class="column_transverse column_transverse_blue">
                                <div class="column_transverse_left">
                                    <div>
                                        <p>城乡企职工</p>
                                        <table border="0" cellspacing="0"
                                               cellpadding="0">
                                            <tr>
                                                <td><b id="cy">0.02%</b>
                                                </td>
                                                <td>
                                                    <i class="column_transverse_down"></i>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <div class="column_transverse_right">
                                    <table width="100%" border="0" cellspacing="0"
                                           cellpadding="0">
                                        <tr>
                                            <td class="column_transverse_name">上月
                                            </td>
                                            <td class="column_transverse_div">
                                                <div><p class="column_transverse_p1"
                                                        id="p_cx_sy"></p><span
                                                        id="cx_sy">14765034</span>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="column_transverse_name">本月
                                            </td>
                                            <td class="column_transverse_div">
                                                <div><p class="column_transverse_p2"
                                                        style="width: 100%;"
                                                        id="p_cx_by"></p><span
                                                        id="cx_by">14768839</span>
                                                </div>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="box mb20">
            <div class="box_title clearfix">
                <i class="box_icon"></i>

                <p class="box_name">2016年各年龄段用户增长趋势</p>
            </div>
            <div class="box_main">
                <div id="ageChange" style="height: 350px"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="box mb20">
                    <div class="box_title clearfix">
                        <i class="box_icon"></i>

                        <p class="box_name">阅读用户全国分布</p>
                    </div>
                    <div class="box_main">
                        <div id="UserAccount" style="height: 350px"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="box mb20">
                    <div class="box_title clearfix">
                        <i class="box_icon"></i>

                        <p class="box_name">一周内各年龄段阅读次数</p>
                    </div>
                    <div class="box_main">
                        <div id="readNum" style="height: 350px"></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <div class="box mb20">
                    <div class="box_title clearfix">
                        <i class="box_icon"></i>
                        <p class="box_name">感兴趣内容</p>
                    </div>

                    <div class="row">
                        <div class="col-md-6" style="padding-right:0px;">
                            <div class="box_main" id="hobby" style="height: 350px;padding-right:0px;padding-left:0px;"></div>
                        </div>
                        <div class="col-md-6" style="padding-left:0px;">
                            <div class="box_main" id="education" style="height: 350px;padding-left:0px;padding-right:0px;"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="box mb20">
                    <div class="box_title clearfix">
                        <i class="box_icon"></i>
                        <p class="box_name">受教育程度</p>
                    </div>
                    <div class="box_main">
                        <div id="education1" style="height: 350px">


                            <img></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>


</html>
