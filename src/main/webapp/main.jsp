<%@ page import="graduate.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/18
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String context = request.getContextPath();
    String userName = (String) session.getAttribute("userName");
    if (session.getAttribute("user") == null) {
        out.println("<script>alert('您还未登录，请先登录。');window.location.href='/user/loginPage.do';</script>");
    }
%>

<script type="text/javascript" src="<%=context%>/resources/js/loginValidform.js"></script>
<script type="text/javascript" src="<%=context%>/resources/util/validFormUtil.js"></script>
<jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>
<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>
    <script language="javascript">
        window.onload=function(){
            window.setInterval("realSysTime(clock)",1000); //实时获取并显示系统时间
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-right" role="navigation">
            <img class="nav-user-photo" src="resources/bootstrap/avatars/user.jpg" alt="Jason's Photo"/>
            <small>欢迎光临,</small>
            <%=userName%>
            </img>
            <div id="clock"></div>
            <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                <li>
                    <a href="/user/updatePwdPage.do">
                        <i class="icon-cog"></i>修改密码
                    </a>
                </li>
                <li>
                    <a href="/user/userInfoPage.do">
                        <i class="icon-user"></i>个人资料
                    </a>
                </li>

                <li>
                    <a href="javascript:void(0)" onclick="logout()">
                        <i class="icon-off"></i>安全退出
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<script>


    function logout() {
        $.ajax({
            url: "/user/logout.do",
            type: 'post',
            dataType: 'json',
            success: function (dataJson) {
                window.location.href = '<%=context%>/user/loginPage.do';
            }
        });
    }
</script>