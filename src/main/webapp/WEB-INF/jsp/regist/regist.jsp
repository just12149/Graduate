<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/27
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context = request.getContextPath(); %>


<html>
<head>
    <title>用户注册</title>
    <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/boostrap3.jsp"></jsp:include>

    <script type="text/javascript" src="<%=context%>/resources/js/loginValidform.js"></script>


    <script src="/resources/js/province/distpicker.data.js"></script>
    <script src="/resources/js/province/distpicker.js"></script>
    <script src="/resources/js/province/main.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=context%>/resources/css/main.css" rel="stylesheet">
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
    <script type="text/javascript" src="<%=context%>/resources/js/canvas-particle.js"></script>
</head>
<body >
<div class="container">
    <header>
        <h1> 用户注册</h1>
    </header>
    <div id="registForm" class="form-horizontal" method="post" role="form">
        <div class="form-group">
            <label for="loginName" class="col-sm-2 control-label"><span style="color:red">会员账号</span></label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="loginName" name="loginName" placeholder="请输入登录名称"
                       onfocus="removeValidateShow(this)" minlength="6" check-type="required"
                       required-message="会员账号必须填写" value="just12149">
            </div>
        </div>

        <div class="form-group">
            <label for="loginPwd" class="col-sm-2 control-label"><span style="color:red">登录密码</span></label>

            <div class="col-sm-6">
                <input type="password" class="form-control" id="loginPwd" name="loginPwd" placeholder="请输入登录密码"
                       onfocus="removeValidateShow(this)" minlength="6" check-type="required"  value="123456">
            </div>
        </div>

        <div class="form-group">
            <label for="confirmLoginPwd" class="col-sm-2 control-label"><span style="color:red">确认密码</span></label>

            <div class="col-sm-6">
                <input type="password" class="form-control" id="confirmLoginPwd" name="confirmLoginPwd"
                       placeholder="请输入确认登录密码" value="123456"
                       onfocus="removeValidateShow(this)" minlength="6" check-type="required">
            </div>
        </div>

        <div class="form-group">
            <label for="userName" class="col-sm-2 control-label"><span style="color:red">用户姓名</span></label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="userName" name="userName" placeholder="请输入登录名称"
                       onfocus="removeValidateShow(this)" minlength="6" check-type="required" value="just">
            </div>
        </div>

        <div class="form-group">
            <label for="sex" class="col-sm-2 control-label"><span style="color:red">性别</span></label>

            <div class="col-sm-6">
                <label class="checkbox-inline">
                    <input type="radio"  name="sex"  id="sex" value="0" checked> 女
                </label>
                <label class="checkbox-inline">
                    <input type="radio"  name="sex" id="sex" value="1"> 男
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-2 control-label"><span style="color:red">年龄层次</span></label>

            <div class="col-sm-6">
                <label class="checkbox-inline">
                    <input type="radio"  name="age"  id="age" value="0" > 60后
                </label>
                <label class="checkbox-inline">
                    <input type="radio"  name="age" id="age" value="1"> 70后
                </label>
                <label class="checkbox-inline">
                    <input type="radio"  name="age"  id="age" value="2" checked> 80后
                </label>
                <label class="checkbox-inline">
                    <input type="radio"  name="age"  id="age" value="3" > 90后
                </label>
                <label class="checkbox-inline">
                    <input type="radio"  name="age"  id="age" value="4" > 00后
                </label>
                <label class="checkbox-inline">
                    <input type="radio"  name="age"  id="age" value="5" > 10后
                </label>
            </div>
        </div>

        <div class="form-group">
            <label for="tel" class="col-sm-2 control-label"><span style="color:red">会员联系方式</span></label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="tel" name="tel" placeholder="请输入联系方式"
                       onfocus="removeValidateShow(this)" minlength="6" check-type="required" value="18829716498">
            </div>
        </div>

        <div class="form-group">
            <label for="email" class="col-sm-2 control-label"><span style="color:red">会员邮箱</span></label>

            <div class="col-sm-6">
                <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱"
                       onfocus="removeValidateShow(this)" minlength="6" check-type="required" value="just12149525@163.com">
            </div>
        </div>

        <div class="form-group">
            <label for="education" class="col-sm-2 control-label"><span style="color:red">受教育程度</span></label>

            <div class="col-sm-6">
                <select class="form-control" id="education" name="education">
                    <option value="5" >博士及以上</option>
                    <option value="4">硕士</option>
                    <option value="3">本科</option>
                    <option value="2">专科</option>
                    <option value="1" selected="selected">高中及以下</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="province" class="col-sm-2 control-label"><span style="color:red">所在地区</span></label>

            <form class="col-sm-6   form-inline">
                <div data-toggle="distpicker" >
                    <div class="form-group" >

                        <select class="form-control" id="province"></select>
                        <select class="form-control" id="city"></select>
                        <select class="form-control" id="district"></select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-8">
                        <div class="col-sm-3"></div>
                        <input type="button" id="submit" class="btn btn-primary col-sm-5"  >注册</input>
                        <div class="col-sm-3"></div>
                        <input type="reset" id="reset" class="btn btn-primary col-sm-5">重置</input>
                        <%--<button type="button" id="reset1" class="btn btn-primary col-sm-3" onclick="registerSumit()" >cao</button>--%>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    //监测账户是否已经注册全局变量
    var accountExist = false;
    /**
     * 获取焦点 删除验证状态
     * @param eleSelf
     */
    function removeValidateShow(eleSelf) {
        if ($(eleSelf).parent().next()) {
            $(eleSelf).attr('style', '');
            $(eleSelf).parent().next().remove();
        }
    }

    $(function () {
        $("#submit").on('click', validate);
        function validate() {
            //清除之前的所有警告样式
            for (var i = 0; i < $('input').length; i++) {
                removeValidateShow($('input').get(i));
            }

            //会员账号
            var loginName = $('#loginName').val();
            //登录密码
            var loginPwd = $('#loginPwd').val();
            //确认密码
            var confirmLoginPwd = $('#confirmLoginPwd').val();
            //用户姓名
            var userName = $('#userName').val();


            //手机号码
            var tel = $('#tel').val();
            //电子邮箱
            var email = $('#email').val();
            //年龄
            var age = $('#age').val();
            //性别
            var sex = $('#sex').val();
            //学历
            var education = $('#education').val();
            //地址
            //var province = $('#province').val();
            var province = $("#province").val();
            var city = $("#city").val();
            var district = $("#district").val();
            if (accountExist) {
                return false;
            }
            //验证会员账号
            var mes = verificationUserName(loginName);
            //mes不等于null表示验证匹配成功，所以不能注册。
            if (mes != null) {
                waringBorderAndSpan($('#loginName').get(0), mes);
                return false;
            }
            //验证会员密码
            var mes1 = verificationPassword(loginPwd, confirmLoginPwd);
            if (mes1 != null) {
                waringBorderAndSpanArray([$('#loginPwd').get(0), $('#confirmLoginPwd').get(0)], ['', mes1]);
                return false;
            }

            //验证用户名称长度不能超过60个字符
            var mes2 = verificationName(userName);
            if (mes2 != null) {
                waringBorderAndSpan($('#userName').get(0), mes2);
                return false;
            }
            //验证手机号
            var mes3 = verificationPhone(tel)
            if (mes3 != null) {
                waringBorderAndSpan($('#tel').get(0), mes3);
                return false;
            }

            //验证电子邮箱
            var mes4 = verificationEmail(email);
            if (mes4 != null) {
                waringBorderAndSpan($('#email').get(0), mes4);
                return false;
            }
            //验证地址
            var mes5 = verificationAddress(province);
            if (mes5 != null) {
                waringBorderAndSpan($('#province').get(0), mes5);
                return false;
            }
            //验证通过提交注册
            $.ajax({
                url: '<%=context%>/user/Regist.do',
                //  data: $("#registerForm").serialize(),
                data: {
                    loginName: $('#loginName').val(),
                    loginPwd: $('#loginPwd').val(),
                    userName: $('#userName').val(),
                    tel: $('#tel').val(),
                    email: $('#email').val(),
                    sex: $('#sex').val(),
                    age: $('#age').val(),
                    province: $('#province').val(),
                    education: $('#education').val()
                },
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    //  alert(data.state);
                    if (data.state == '注册成功') {
                        alert('注册成功,即将跳转会员管理页面！');
                        window.location.href = '<%=context%>/user/loginPage.do';
                    } else {
                        alert(data.state);
                    }
                }, error: function (e) {
                    alert(e);
                }
            });

        }

        //验证是否重复帐户名
        $('#loginName').blur(function () {
            if ($('#loginName').val() != null || $('#loginName').val() != '') {
                $.ajax({
                    url: '<%=context%>/user/vipCheckUserNameDuplicate.do',
                    type: 'post',
                    data: {
                        loginName: $('#loginName').val(),
                    },
                    dataType: 'json',
                    success: function (data) {
                        if (data.isContainUser) {
                            waringBorderAndSpan($('#loginName').get(0), '用户账户已经注册');
                            accountExist = true;
//                alert('用户账户重名');
//                $('#loginName').val('');
                        } else {
                            accountExist = false;
                        }
                    }
                });
            }
        })

    });

</script>
</html>
