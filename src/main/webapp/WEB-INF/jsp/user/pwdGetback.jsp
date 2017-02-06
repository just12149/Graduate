<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String context = request.getContextPath();
    Boolean sessionIsEmpty = (Boolean) session.getAttribute("userExist");
%>

<html>
<head>
    <title>密码找回</title>
    <link rel="stylesheet" href="<%=context%>/resources/frame/bootstrap3/css/bootstrap.min.css">
    <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/boostrap3.jsp"></jsp:include>
    <script type="text/javascript" src="<%=context%>/resources/js/loginValidform.js"></script>
    <script type="text/javascript" src="<%=context%>/resources/frame/bootstrap3/js/bootstrap.min.js"></script>
    <style>
        .warning {
            -webkit-box-shadow: 0 0 10px red;
            -moz-box-shadow: 0 0 10px red;
            box-shadow: 0 0 10px red;
        }
    </style>
</head>
<script>

    /**
     *
     * 获取焦点 删除验证状态
     * @param eleSelf 输入input元素
     */
    function removeGBValidateShow(eleSelf) {
        if ($(eleSelf).parent().next()) {

            $(eleSelf).removeClass('warning');
            $(eleSelf).parent().next().remove();
        }
    }

    function waringGBBorderAndSpanArray(ele, warningStr, addClass) {

        for (var i = 0; i < ele.length; i++) {

            removeGBValidateShow(ele[i]);
            $(ele[i]).addClass(addClass)
            //这里是元素的父元素添加说明
            //先清空
            $(ele[i]).parent().after('<span class="form-control-feedback" aria-hidden="true" style="color: red">' + warningStr[i] + '</span>');
        }

    }
</script>
<body>
<div class="container">

    <header>
        <h1>密码找回</h1>

        <h3>请输入需要找回密码的账号和当时注册的邮箱。如果忘记邮箱：请联系客服找回密码</h3>

        <h3>客服电话 029-88338338</h3>
    </header>

    <div>
        <form class="form-horizontal">


            <div class="form-group">
                <label for="loginName" class="col-sm-2 control-label"><span style="color:red;"> * </span>会员账号</label>

                <div class="col-sm-6">
                    <input type="email" class="form-control" id="loginName" name="loginName" placeholder=""
                           onfocus="removeGBValidateShow(this)" check-type="required" required-message="会员账号必须填写">
                </div>
            </div>

            <div class="form-group">
                <label for="email" class="col-sm-2 control-label"><span style="color:red;"> * </span>电子邮箱</label>

                <div class="col-sm-6">
                    <input type="text" class="form-control" id="email" name="email" placeholder="xxxx@xx.com"
                           onfocus="removeGBValidateShow(this)" check-type="mail required">
                </div>
            </div>


            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-8">

                    <button type="button" id="submit" class="btn btn-primary col-sm-3" onclick="getBack()">重置密码</button>

                </div>
            </div>

        </form>
    </div>


    <footer>
        <%--修改密码模态框--%>
        <div class="modal fade" id="myModal" tabindex="100" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">密码修改</h4>
                        <span id="checkButton"></span>
                    </div>
                    <div class="modal-body">
                        <form id="editForm" class="form-inline">
                            <table class="table table-condensed">
                                <tr>
                                    <td align="right" width="25%">
                                        <div class="form-group">
                                            <label for="newPass"><span style="color:red;"> * </span>新密码:</label>
                                            <%--<span id="loginPwdSpan" style="color: #a94442;">新密码</span>--%>
                                        </div>
                                    </td>
                                    <td><input type="password" name="newPass" class="form-control" id="newPass"
                                               style="width: 200px"
                                               onfocus="removeGBValidateShow(this)"/></td>
                                </tr>
                                <tr>
                                    <td align="right" width="25%">
                                        <div class="form-group">
                                            <label for="reNewPass"><span style="color:red;"> * </span>确认新密码:</label>
                                        </div>
                                    </td>
                                    <td><input type="password" name="reNewPass" class="form-control" id="reNewPass"
                                               style="width: 200px"
                                               onfocus="removeGBValidateShow(this)"/></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary btn-sm" onclick="submitNewPassForm()">保 存</button>
                        <button type="button" class="btn btn-primary btn-sm" id="editCloseBtn" data-dismiss="modal">关闭
                        </button>
                    </div>
                </div>
            </div>
        </div>


    </footer>

</div>
</body>
<script>
    //模态框隐藏重置
    $("#myModal").on("hide.bs.modal", function () {
        $('#editForm').get(0).reset();
        removeGBValidateShow($('#newPass').get(0));
        removeGBValidateShow($('#reNewPass').get(0));
    });

    //验证是否可以弹出模态框来修改密码
    function getBack() {
        var loginName = $('#loginName').val();
        var email = $('#email').val();

        //验证用户名
        var loginNameMsg = verificationUserName(loginName);
        if (loginNameMsg != null) {
            waringGBBorderAndSpanArray([$('#loginName').get(0)], [loginNameMsg], 'warning');
            return false;
        }

        //验证邮箱
        var emailMsg = verificationEmail(email)
        if (emailMsg != null) {
            waringGBBorderAndSpanArray([$('#email').get(0)], [emailMsg], 'warning');
            return false;
        }

        //提交
        if ($('#loginName').val() != null && $('#loginName').val() != '' && $('#email').val() != null && $('#email').val() != '') {
            $.ajax({
                url: '<%=context%>/user/GetPwdBack.do',
                data: {
                    loginName: $('#loginName').val(),
                    email: $('#email').val()
                },
                type: 'post',
                dataType: 'json',
                success: function (data) {
//          alert(data.success);
                    if (data.success) {
                        //弹出模态框
                        $('#myModal').modal('show');
                    } else {
                        alert(data.msg)
                    }
                }, error: function (e) {
                    alert(e);
                }
            });
        }

    }

    //保存模态框修改数据到新密码
    function submitNewPassForm() {
        var newPass = $('#newPass').val();
        var reNewPass = $('#reNewPass').val();
        <%--alert(<%=sessionIsEmpty%>);--%>

        removeGBValidateShow($('#newPass').get(0));
        removeGBValidateShow($('#reNewPass').get(0));
        //验证会员密码
        var mes1 = verificationPassword(newPass, reNewPass);
        //mes不等于null表示验证匹配成功，所以不能注册。
        if (mes1 != null) {
            waringGBBorderAndSpanArray([$('#newPass').get(0), $('#reNewPass').get(0)], ['', mes1], 'warning');
            return false;
        }

        if (!<%=sessionIsEmpty%> && newPass != null) {
            $.ajax({
                url: "<%=context%>/user/PwdRevise.do",
                type: 'post',
                data: {
                    newPass: newPass
                },
                dataType: 'json',
                success: function (reBackData) {
//                    alert(reBackData['success']);
                    if (reBackData.success) {
                        alert('修改密码成功');
                        //关闭模态框并跳转登录页面
                        $('#editCloseBtn').click();
                        //session 失效 跳转
                        <% session.invalidate();%>
                        window.location.href = '<%=context%>/user/loginPage.do';
                    } else {
                        alert('修改密码失败');
                    }
                    ;
                }
            });
        } else {
            alert("修改密码时间超过10分钟，已经超时，请重新验证账户和邮箱。")
            $('#myModal').modal('hide');
        }
    }
</script>
</html>
