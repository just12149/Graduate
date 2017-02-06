<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/23
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String context = request.getContextPath();
    String currentMenu = request.getParameter("currentMenu");
%>

<div class="header">
    <div class="logo"><img src="/resources/images/logo.png"/></div>
    <ul class="top_nav">
        <li><a href="/index"><i class="iconfont icon-home"></i><span>系统首页</span></a></li>
        <li><a><i class="iconfont icon-kechengzhuanhuafuwu"></i><span>帮助中心</span></a></li>
        <li><a><i class="iconfont icon-yonghu"></i><span>登陆</span></a></li>
        <li><a><i class="btn btn-default btn-sm"></i><span>注销</span></a></li>
        <button type="button" class="btn btn-primary btn-lg">
            <span class="glyphicon glyphicon-user"></span>系统首页
        </button>
        <button type="button" class="btn btn-primary btn-lg">
            <span class="glyphicon glyphicon-user"></span>帮助中心
        </button>
        <button type="button" class="btn btn-primary btn-lg">
            <span class="glyphicon glyphicon-user"></span>登陆
        </button>
        <button type="button" class="btn btn-primary btn-lg">
            <span class="glyphicon glyphicon-user"></span>注销
        </button>

    </ul>
</div>

