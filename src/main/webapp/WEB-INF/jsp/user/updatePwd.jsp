<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/30
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String userName = (String) session.getAttribute("userName");
    String context = request.getContextPath();
%>
<html>
<head>
    <title>更改密码</title>
 <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>
    <script type="text/javascript" src="<%=context%>/resources/js/loginValidform.js"></script>
</head>
<body>
<div class="page-content" id="centent">
    <div class="container" style="margin-top: 20px">

        <div class="table-header">
            <table width="100%">
                <thead>
                <tr>
                    <th>修改会员密码</th>
                </tr>
                </thead>
            </table>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover">
                <thead>

                </thead>
                <tbody>
                <tr>
                    <td class="col-sm-2 control-label">原密码:</td>
                    <td class="col-sm-6"><input type="password" id="oldPwd" name="oldPwd"/></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">新密码:</td>
                    <td class="col-sm-6"><input type="password" id="newPwd" name="newPwd"
                                                onfocus="removeValidatePass(this)"/></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">确认新密码:</td>
                    <td class="col-sm-6"><input type="password" id="renewPwd" name="renewPwd"
                                                onfocus="removeValidatePass(this)"/></td>
                </tr>
                </tbody>

            </table>
        </div>
        <div>
            <button type="button" class="btn btn-primary btn-sm" onclick="submitnewPwdForm()">确认修改密码</button>
        </div>

    </div>
</div>

<script>
    function removeValidatePass(eleSelf) {
        if ($(eleSelf).parent().next()) {
            $(eleSelf).attr('style', '');
            $(eleSelf).next().remove();
        }
    }

    function validatePass(ele, warningStr) {
        for (var i = 0; i < ele.length; i++) {
            var oldStyle = $(ele[i]).attr('style');
            if (oldStyle == undefined) {
                oldStyle = '';
            }
            removeValidatePass(ele[i]);
            $(ele[i]).attr('style', oldStyle + ' -webkit-box-shadow: 0 0 10px red!important; -moz-box-shadow: 0 0 10px red!important;box-shadow: 0 0 10px red!important; ');
            //这里是元素的父元素添加说明
            //先清空
            var eleHeight = $(ele[i]).css('height');
            if (eleHeight == undefined) {
                eleHeight = $(ele[i]).attr('height');
            }
            $(ele[i]).after('<span class="form-control-feedback" aria-hidden="true" style="color: red;line-height: ' + eleHeight + ';text-align:center " >' + warningStr[i] + '</span>');
        }
    }

    function submitnewPwdForm() {
        var newPwd = $('#newPwd').val();
        var renewPwd = $('#renewPwd').val();
        var oldPwd = $('#oldPwd').val();

        //验证输入合法性

        //验证新密码,验证确认新密码
        var msg1 = verificationPassword(newPwd, renewPwd);
        if (msg1 != null) {
            //msg不为空则说明验证报错
            //边框变红，添加警告
            validatePass([$('#newPwd')[0], $('#renewPwd')[0]], ['', msg1]);
            return false;
        }
        if ((renewPwd != '') && (newPwd != '') && (newPwd == renewPwd)) {
            $.ajax({
                url: "<%=context%>/user/modifyOldPass.do",
                type: 'post',
                data: {
                    oldPwd: oldPwd,
                    newPwd: newPwd
                },
                dataType: 'json',
                success: function (reBackData) {

                    if (reBackData['success'] == "true") {
                        alert('修改密码成功');
                        $('#span1').html('');
                        $('#span2').html('');

                    } else {

                        if (reBackData['msg'] != null) {
                            alert(reBackData['msg']);
                            $('#newPwd').val('');
                            $('#renewPwd').val('');
                            $('#oldPwd').val('');
                        } else {
                            alert('用户超时，请重新登录系统。');
                            window.location.href = "<%=context%>/user/LoginPage.do";
                        }

                    };
                }
            });
        } else {
            return;
        }
    }
</script>
</body>
</html>
