
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String context = request.getContextPath();
    String userName = (String) session.getAttribute("userName");
    String userInfo = (String) session.getAttribute("userInfo");

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
                    <td class="col-sm-2 control-label">性别:</td>
                    <td class="col-sm-6">

                        <label id="sex" name="sex"></label></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">所属年代:</td>
                    <td class="col-sm-6"><label id="age" name="age"></label></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">联系电话:</td>
                    <td class="col-sm-6"><label id="tel" name="tel"></label></td>
                </tr>

                <tr>
                    <td class="col-sm-2 control-label">电子邮箱:</td>
                    <td class="col-sm-6"><label id="email" name="email"></label></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">学历:</td>
                    <td class="col-sm-6"><label id="education" name="education"></label></td>
                </tr>
                <tr>
                    <td class="col-sm-2 control-label">地址:</td>
                    <td class="col-sm-6"><label id="address" name="address"></label></td>
                </tr>

                </tbody>

            </table>
        </div>


        <div>

            <div class="col-sm-offset-2 col-sm-8">
                <div class="col-sm-4"></div>

                <button type="button" id="submit" class="btn btn-primary col-sm-4" onclick="modifyVipInfo()">修改信息
                </button>

            </div>

        </div>

        <footer>

        </footer>

    </div>


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
                                        <label for="sexModel"><span style="color: red"> * </span>性别:</label>
                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="sexModel" class="form-control"
                                           id="sexModel" style="width: 220px"
                                           onfocus="removeValidateShowClass(this)"/>
                                </td>
                            </tr>

                            <tr>
                                <td align="right">
                                    <div class="form-group">
                                        <label for="ageModel"><span style="color: red"> * </span>所属年代:</label>
                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="ageModel" class="form-control"
                                           id="ageModel" style="width: 220px"
                                           onfocus="removeValidateShowClass(this)"/>
                                    <%--<span id="companyNameModelSpan" style="color: #a94442;">*</span>--%>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">
                                    <div class="form-group">
                                        <label for="telModel"><span style="color: red"> * </span>联系电话:</label>
                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="telModel" class="form-control" id="telModel"
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
                                        <label for="addressModel">地址:</label>

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
                                        <label for="educationModel">学历:</label>
                                    </div>
                                </td>
                                <td>
                                    <input type="text" name="educationModel" class="form-control" id="educationModel"
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



<style>
    input[alert='warning'] {
        -webkit-box-shadow: 0 0 10px red !important;
        -moz-box-shadow: 0 0 10px red !important;
        box-shadow: 0 0 10px red !important;
    }
</style>
<script>

    /**

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
        $('#telModel').val($('#tel').html());
        $('#emailModel').val($('#email').html());
        $('#sexModel').val($('#sex').html());
        $('#ageModel').val($('#age').html());
        $('#addressModel').val($('#address').html());
        $('#educationModel').val($('#education').html());
    });


    //页面加载从后台请求 用户信息数据
    function loadUserInfo() {
        //表格加载信息
        $('#userId').append('${user.userId}');
        $('#userName').append('${user.userName}');
        $('#tel').append('${userInfo.tel}');
        $('#sex').append('${userInfo.sex}');
        $('#age').append('${userInfo.age}');
        $('#email').append('${userInfo.mail}');
        $('#address').append('${userInfo.address}');
        $('#education').append('${userInfo.education}');

    }
    //显示修改密码模态框
    function modifyPass() {

        $('#myModal').modal('show');
    }

    function modifyVipInfo() {
        $('#myInfoModal').modal('show');
    }
    //模态框会员数据加载
    $('#userIdModel').val($('#userId').html());
    $('#userNameModel').val($('#userName').html());
    $('#sexModel').val($('#sex').html());
    $('#ageModel').val($('#age').html());
    $('#telModel').val($('#tel').html());
    $('#emailModel').val($('#email').html());
    $('#addressModel').val($('#address').html());
    $('#educationModel').val($('#education').html());
    //修改会员信息模态框提交
    function submitNewInfoForm() {
        //提交表单验证
        var userNameModelVal = $('#userNameModel').val();
        var sexModelVal = $('#sexModel').val();
        var ageModelVal = $('#ageModel').val();
        var telModelVal = $('#telModel').val();
        var emailModelVal = $('#emailModel').val();
        var addressModelVal = $('#addressModel').val();
        var educationModelVal = $('#educationModel').val();


        //验证用户名子长度不能超过60个字符
        var mes1 = verificationName(userNameModelVal);
        if (mes1 != null) {
            waringBorderClassAndSpan($('#userNameModel').get(0), mes1);
            return false;
        }

        //验证手机号
        var mes2 = verificationPhone(telModelVal)
        //mes不等于null表示验证匹配成功，所以不能注册。
        if (mes2 != null) {
            waringBorderClassAndSpan($('#telModel').get(0), mes2);
            return false;
        }

        //验证电子邮箱
        var mes3 = verificationEmail(emailModelVal);
        //mes不等于null表示验证匹配成功，所以不能注册。
        if (mes3 != null) {
            waringBorderClassAndSpan($('#emailModel').get(0), mes3);
            return false;
        }
        //验证地址
        var mes4 = verificationAddress(addressModelVal);
        //mes不等于null表示验证匹配成功，所以不能注册。
        if (mes4 != null) {
            waringBorderClassAndSpan($('#addressModel').get(0), mes4);
            return false;
        }

        //验证学历
        var mes5 = verification(educationModelVal);
        //mes不等于null表示验证匹配成功，所以不能注册。
        if (mes5 != null) {
            waringBorderClassAndSpan($('#educationModel').get(0), mes5);
            return false;
        }
        //验证通过提交后台修改
        $.ajax({
            url: "<%=context%>/user/UserInfoUpdate.do",
            type: 'post',
            data: {
                userId: $('#userIdModel').val(),
                userName: $('#userNameModel').val(),
                tel: $('#telModel').val(),
                sex: $('#sexModel').val(),
                age: $('#ageModel').val(),
                email: $('#emailModel').val(),
                address: $('#addressModel').val(),
                education: $('#educationModel').val(),
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
