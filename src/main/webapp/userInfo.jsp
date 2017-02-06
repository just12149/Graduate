
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String context = request.getContextPath();
    String userName = (String) session.getAttribute("userName");

%>
<html>
<head>
    <title></title>
    <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/boostrap3.jsp"></jsp:include>
    <script src="<%=context%>/resources/js/loginValidform.js"></script>
    <script type="text/javascript" src="<%=context%>/resources/frame/bootstrap3/js/bootstrap.min.js"></script>
</head>
<body ng-app="InfoApp" ng-controller="InfoCtrl">
<div class="page-content" id="centent">
    <div class="container" style="margin-top: 20px">
        <%--头部--%>
        <div class="table-header">
            <table width="100%">
                <thead>
                <tr>
                    <th>会员信息</th>
                </tr>
                </thead>
            </table>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover">
                <tbody>
                <tr style="display: none">
                    <td class="col-sm-2 control-label">用户id:</td>
                    <td class="col-sm-6"><label id="userId" name="userId"></label></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">用户姓名:</td>
                    <td class="col-sm-6"><label id="userName" name="userName"></label></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">公司名称:</td>
                    <td class="col-sm-6"><label id="companyName" name="companyName"></label></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">联系电话:</td>
                    <td class="col-sm-6"><label id="phone" name="phone"></label></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">电子邮箱:</td>
                    <td class="col-sm-6"><label id="email" name="email"></label></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">联系QQ:</td>
                    <td class="col-sm-6"><label id="qq" name="qq"></label></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">微信号:</td>
                    <td class="col-sm-6"><label id="weChat" name="weChat"></label></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">公司地址:</td>
                    <td class="col-sm-6"><label id="address" name="address"></label></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">职位:</td>
                    <td class="col-sm-6"><label id="position" name="position"></label></td>
                </tr>
                </tbody>

            </table>
        </div>

        <%--body--%>
        <div>
            <%--<form class="form-horizontal" >--%>
            <div class="col-sm-offset-2 col-sm-8">
                <div class="col-sm-4"></div>
                <%--<button type="submit" id="submit" class="btn btn-primary col-sm-3" onclick="modifyVipInfo()">修改信息</button>--%>
                <button type="button" id="submit" class="btn btn-primary col-sm-4" onclick="modifyVipInfo()">修改信息
                </button>
                <%--<div class="col-sm-1"></div>--%>
                <%--<button type="reset" id="reset" class="btn btn-primary col-sm-3" onclick="modifyPass()">修改密码</button>--%>
            </div>
            <%--</form>--%>
        </div>

        <%--footer--%>
        <footer>

        </footer>

    </div>

    <%--修改个人信息模态框--%>
    <div class="modal fade" id="myInfoModal" tabindex="100" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="infoModalLabel">个人信息修改</h4>
                    <span id="infoCheckButton"></span>
                </div>
                <div class="modal-body">
                    <form id="infoEditForm" class="form-inline">
                        <table class=" table-condensed">
                            <tr style="display: none">
                                <td align="right" width="100px">
                                    <div class="form-group">
                                        <label for="userIdModel">用户ID</label>
                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="userIdModel" class="form-control" id="userIdModel"/>
                                    <%--<span id="userIdModelSpan" style="color: #a94442;display: none;"></span>--%>
                                </td>
                            </tr>
                            <tr>
                                <td align="right" width="100px">
                                    <div class="form-group">
                                        <label for="userNameModel"><span style="color: red"> * </span>用户姓名:</label>
                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="userNameModel" class="form-control" id="userNameModel"
                                           style="width: 220px" onfocus="removeValidateShowClass(this)"/>
                                    <%--<span id="userNameModelSpan" style="color: #a94442;display: none;"></span>--%>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    <div class="form-group">
                                        <label for="companyNameModel"><span style="color: red"> * </span>公司名称:</label>

                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="companyNameModel" class="form-control"
                                           id="companyNameModel" style="width: 220px"
                                           onfocus="removeValidateShowClass(this)"/>
                                    <%--<span id="companyNameModelSpan" style="color: #a94442;">*</span>--%>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    <div class="form-group">
                                        <label for="phoneModel"><span style="color: red"> * </span>联系电话:</label>

                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="phoneModle" class="form-control" id="phoneModel"
                                           style="width: 220px" onfocus="removeValidateShowClass(this)"/>
                                    <%--<span id="phoneModleSpan" style="color: #a94442;">*</span>--%>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    <div class="form-group">
                                        <label for="emailModel"><span style="color: red"> * </span>电子邮箱:</label>
                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="emailModel" class="form-control" id="emailModel"
                                           style="width: 220px" onfocus="removeValidateShowClass(this)"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    <div class="form-group">
                                        <label for="qqModel">联系QQ:</label>

                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="qqModel" class="form-control" id="qqModel"
                                           style="width: 220px" onfocus="removeValidateShowClass(this)"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    <div class="form-group">
                                        <label for="weChatModel">微信号:</label>

                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="weChatModel" class="form-control" id="weChatModel"
                                           style="width: 220px" onfocus="removeValidateShowClass(this)"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    <div class="form-group">
                                        <label for="addressModel">公司地址:</label>

                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="addressModel" class="form-control" id="addressModel"
                                           style="width: 220px" onfocus="removeValidateShowClass(this)"/>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    <div class="form-group">
                                        <label for="positionModel">职位:</label>
                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="positionModel" class="form-control" id="positionModel"
                                           style="width: 220px" onfocus="removeValidateShowClass(this)"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary btn-sm" onclick="submitNewInfoForm()">保 存</button>
                    <button type="button" class="btn btn-primary btn-sm" id="infoCloseBtn" data-dismiss="modal">关闭
                    </button>
                </div>
            </div>
        </div>
    </div>


</body>
<style>
    input[alert='warning'] {
        -webkit-box-shadow: 0 0 10px red !important;
        -moz-box-shadow: 0 0 10px red !important;
        box-shadow: 0 0 10px red !important;
    }
</style>
<script>

    /**
     * 柯彭程
     * 获取焦点 删除验证状态
     * @param eleSelf 输入input元素
     */
    function removeValidateShowClass(eleSelf) {
        if ($(eleSelf).parent().next()) {
            //清除红色边框
            $(eleSelf).attr('alert', '');
            //清除警告提示语
            $(eleSelf).parent().next().remove();
        }
    }

    /**
     * 添加警告红色边框css样式
     * @param ele
     * @param warningStr
     */
    function waringBorderClassAndSpan(ele, warningStr) {
        //添加前先清除原来的。
        removeValidateShowClass(ele);
        $(ele).attr('alert', 'warning');
        var eleHeight = $(ele).css('height');
        if (eleHeight == undefined) {
            eleHeight = $(ele).attr('height');
        }
        $(ele).parent().after('<span class="form-control-feedback" aria-hidden="true" style="color: red;line-height: ' + eleHeight + ';text-align:center ">' + warningStr + '</span>');
    }

    //模态框隐藏事件
    $('#myInfoModal').on("hide.bs.modal", function () {
        //表单重置
        $('#infoEditForm').get(0).reset();
        //警告样式清除
        var inputArray = $('input');
        for (var i = 0; i < inputArray.length; i++) {
            removeValidateShowClass(inputArray.get(i));
        }

    });

    //模态框加载事件
    $('#myInfoModal').on("show.bs.modal", function () {
        //模态框会员数据加载
        $('#userIdModel').val($('#userId').html());
        $('#userNameModel').val($('#userName').html());
        $('#companyNameModel').val($('#companyName').html());
        $('#phoneModel').val($('#phone').html());
        $('#emailModel').val($('#email').html());
        $('#qqModel').val($('#qq').html());
        $('#weChatModel').val($('#weChat').html());
        $('#addressModel').val($('#address').html());
        $('#positionModel').val($('#position').html());
    });


    //页面加载从后台请求 用户信息数据
    function loadUserInfo() {
        //表格加载信息
        $('#userId').append('${user.userId}');
        $('#userName').append('${user.userName}');
        $('#companyName').append('${companyInfo.companyName}');
        $('#phone').append('${companyInfo.phone}');
        $('#email').append('${companyInfo.eMail}');
        $('#qq').append('${companyInfo.qq}');
        $('#weChat').append('${companyInfo.weChat}');
        $('#address').append('${companyInfo.address}');
        $('#position').append('${companyInfo.position}');
    }
    //显示修改密码模态框
    function modifyPass() {

        $('#myModal').modal('show');
    }

    function modifyVipInfo() {
        $('#myInfoModal').modal('show');
    }

    //修改会员信息模态框提交
    function submitNewInfoForm() {
        //提交表单验证
        var userNameModelVal = $('#userNameModel').val();
        var companyNameModelVal = $('#companyNameModel').val();
        var phoneModelVal = $('#phoneModel').val();
        var emailModelVal = $('#emailModel').val();
        var qqModelVal = $('#qqModel').val();
        var weChatModelVal = $('#weChatModel').val();
        var addressModelVal = $('#addressModel').val();
        var positionModelVal = $('#positionModel').val();


        //验证用户名子长度不能超过60个字符
        var mes2 = verificationName(userNameModelVal);
        if (mes2 != null) {
            waringBorderClassAndSpan($('#userNameModel').get(0), mes2);
            return false;
        }

        //验证公司名称长度不能超过60个字符
        var mes3 = verificationCompanyName(companyNameModelVal);
        //mes不等于null表示验证匹配成功，所以不能注册。
        if (mes3 != null) {
            waringBorderClassAndSpan($('#companyNameModel').get(0), mes3);
            return false;
        }

        //验证手机号
        var mes4 = verificationPhone(phoneModelVal)
        //mes不等于null表示验证匹配成功，所以不能注册。
        if (mes4 != null) {
            waringBorderClassAndSpan($('#phoneModel').get(0), mes4);
            return false;
        }

        //验证电子邮箱
        var mes5 = verificationEmail(emailModelVal);
        //mes不等于null表示验证匹配成功，所以不能注册。
        if (mes5 != null) {
            waringBorderClassAndSpan($('#emailModel').get(0), mes5);
            return false;
        }

        //验证qq
        var mes6 = verificationQQ(qqModelVal);
        //mes不等于null表示验证匹配成功，所以不能注册。
        if (mes6 != null) {
            waringBorderClassAndSpan($('#qqModel').get(0), mes6);
            return false;
        }

        //验证微信号
        var mes7 = verificationWeChat(weChatModelVal);
        //mes不等于null表示验证匹配成功，所以不能注册。
        if (mes7 != null) {
            waringBorderClassAndSpan($('#weChatModel').get(0), mes7);
            return false;
        }

        //验证公司地址
        var mes8 = verificationAddress(addressModelVal);
        //mes不等于null表示验证匹配成功，所以不能注册。
        if (mes8 != null) {
            waringBorderClassAndSpan($('#addressModel').get(0), mes8);
            return false;
        }

        //验证职位
        var mes9 = verification(positionModelVal);
        //mes不等于null表示验证匹配成功，所以不能注册。
        if (mes9 != null) {
            waringBorderClassAndSpan($('#positionModel').get(0), mes9);
            return false;
        }
        //验证通过提交后台修改
        $.ajax({
            url: "<%=context%>/user/UserInfoUpdate.do",
            type: 'post',
            data: {
                userId: $('#userIdModel').val(),
                userName: $('#userNameModel').val(),
                companyName: $('#companyNameModel').val(),
                phone: $('#phoneModel').val(),
                email: $('#emailModel').val(),
                qq: $('#qqModel').val(),
                weChat: $('#weChatModel').val(),
                address: $('#addressModel').val(),
                position: $('#positionModel').val(),
            },
            dataType: 'json',
            success: function (backData) {
                if (backData) {
                    alert("修改成功");
                    $('#infoCloseBtn').click();
                    window.location.reload();
                } else {
                    alert("修改失败");
                }
            }
        });
    }

    //主函数
    $(function () {
        loadUserInfo();
    });

</script>
</body>
</html>
