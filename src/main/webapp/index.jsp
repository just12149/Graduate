<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%

    Integer roleId = (Integer) session.getAttribute("roleId");

    String scheme = request.getScheme();
    String serverName = request.getServerName();
    int serverPort = request.getServerPort();
    String context = request.getContextPath();
    String basePath = scheme + "://" + serverName + ":" + serverPort + "/";
    //String webName = DataCacheUtil.getWebConfig().getWebName();
    //String webLogo = DataCacheUtil.getWebConfig().getWebLogo();
%>
<html>
<head>
    <title>用户中心登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/newLogin.css">

    <style type="text/css">
        input:focus {
            background-color: #EEE9BF;
        }
    </style>
    <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/boostrap3.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>
    <script type="text/javascript" src="/resources/js/loginValidform.js"></script>
    <script type="text/javascript" src="<%=context%>/resources/js/canvas-particle.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            var config = {
                vx: 4,
                vy: 4,
                height: 2,
                width: 2,
                count: 100,
                color: "121, 162, 185",
                stroke: "100,200,180",
                dist: 6000,
                e_dist: 20000,
                max_conn: 10
            }
            CanvasParticle(config);
        }
    </script>


    <script>
        $(function () {
            $(document).keyup(function (e) {
                var curKey = e.which;
                if (curKey == 13) {
                    document.getElementById("send-btn").click();
                }
            });
//    $(".i-text").focus(function(){
//      $(this).addClass('h-light');
//    });
//    $(".i-text").focusout(function(){
//      $(this).removeClass('h-light');
//    });
            $("#loginName").focus(function () {
                var username = $(this).val();
                if (username == '请输入账号') {
                    $(this).val('');
                }
            });
            $("#loginName").focusout(function () {
                var username = $(this).val();
                if (username == '') {
                    $(this).val('请输入账号');
                }
            });
            $("#validateCode").focus(function () {
                var validateCode = $(this).val();
                if (validateCode == '输入验证码') {
                    $(this).val('');
                }
            });
            $("#validateCode").focusout(function () {
                var validateCode = $(this).val();
                if (validateCode == '') {
                    $(this).val('输入验证码');
                }
            });
        });
        function loginSubmit() {
            var loginName = $("#loginName").val();
            var loginPwd = $("#loginPwd").val();
            var validateCode = $("#validateCode").val();
            if (!(loginName != null && loginName.length > 0)) {
                $(".error-box").html("账号不能为空!");
                $(".error-box").show();
                return false;
            }
            if (loginName == "请输入账号") {
                $(".error-box").html("账号不能为空!");
                $(".error-box").show();
                return false;
            }
            var mes = verificationUserName(loginName);
            if (mes != null) {
                $(".error-box").html(mes);
                $(".error-box").show();
                return false;
            }
            if (!(loginPwd != null && loginPwd.length > 0)) {
                $(".error-box").html("登录密码不能为空!");
                $(".error-box").show();
                return false;
            }
            if (!(validateCode != null && validateCode.length > 0)) {
                $(".error-box").html("验证码不能为空!");
                $(".error-box").show();
                return false;
            }


            $.ajax({
                url: "/user/login.do",
                type: 'post',
                data: {
                    loginName: loginName,
                    loginPwd: loginPwd,

                    validateCode: validateCode
                },
                dataType: 'json',
                success: function (dataJson) {
                    var isSuccess = dataJson.success;
                    if (!isSuccess) {
                        $(".error-box").html(dataJson.msg);
                        $(".error-box").show();
                    } else {
                        $(".error-box").hide();
                            if(<%=roleId%>==1){
                            window.location.href = '/user/main.do';
                            }else{
                            window.location.href = '/user/admin.do';
                            }
                    }
                }
            });
        }
        function refreshCode() {
            var obj = $("#checkCode");
            obj.attr("src", "<%=basePath%>codeNumber/getCodeNumber.do?random=" + Math.random());
        }
        //跳转注册页面
        function toRegister() {
            window.location.href = "<%=context%>/user/registPage.do";
        }

        //跳转密码找回
        function toPassGetBack() {
            window.location.href = "<%=context%>/user/PwdGetBackPage.do";
        }

        //获取焦点输入框改变属性
        function txtFocus() {
            var e = window.event;
            var obj = e.srcElement;   //当前对象
            obj.style.background = "#ffff66";
        }
        //
        function txtBlur() {
            var e = window.event;
            var obj = e.srcElement;
            obj.style.background = "#ffffff";
        }


    </script>
</head>
<body>
<div class="top">
    <span class="logo"></span>
    <dl class="top_nav">
        <span>|</span>
        <dd><a href="<%=context%>/user/registPage.do">还没有账号</a></dd>
        <span>|</span>
        <dd><a href="<%=context%>/user/PwdGetBackPage.do">找回密码</a></dd>
        <span>|</span>
        <dd><a href="<%=context%>/user/main.do">随便看看</a></dd>
    </dl>
</div>

<div class="login_box">
    <div class="login">
        <div class="login_top"><i></i><b></b></div>
        <div class="login_con">
            <form action="/user/login.do">
                <div class="lohin_tit"></div>
                <ul class="lohin_web">
                    <li><input name="loginName" id="loginName" required="" type="text" aria-label="姓名" placeholder="姓名">
                    </li>

                    <li><input name="loginPwd" id="loginPwd" required="" type="password" aria-label="密码"
                               placeholder="密码（不少于 6 位）" width="200px">
                        <%--记住我 &nbsp;<input  name="remeberMe" id="remeberMe" required="" type="checkbox" aria-label="记住"--%>
                        <%--placeholder="记住我">--%>
                    </li>


                    <li>
                        <label for="validateCode" style="color: white"></label>
                        <table>
                            <tr>
                                <td><input style="width: 245px;" type="text" placeholder="输入验证码" width="20"
                                           maxlength="100" id="validateCode" name="validateCode" class="i-text yzm"
                                           nullmsg="请输入验证码！"></td>
                                <td><img style="display: table-cell; vertical-align:middle;height: 40px;"
                                         src="/codeNumber/getCodeNumber.do" id="checkCode" onclick="refreshCode()"
                                         class="yzm-img"/></td>
                            </tr>
                        </table>

                    </li>

                </ul>
                <a class="login_btn" id="share" onclick="loginSubmit()" style="display: block">立即登录</a>

                <div class="error-box" style="color: red;margin-left: 40px"></div>
            </form>

        </div>
        <div class="login_yy"></div>
    </div>

</div>
<div class="footer">Copyright@2017 小型新闻发布管理系统<span>|</span>陕ICP备11007473号</div>


</body>
</html>