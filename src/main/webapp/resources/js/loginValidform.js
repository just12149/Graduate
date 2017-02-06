/**
 * 校验用户名
 * @param userName
 */
function verificationUserName(userName) {
    if (userName == null || userName.length == 0) {
        return "账号不能为空！";
    }
    if (userName.length < 6) {
        return "账号不能少于6个字符！";
    }
    if (userName.length > 32) {
        return "账号不能大于32个字符！";
    }

    return null;
}
/**
 * 校验登录密码
 * @param password
 * @param newPassword
 * @returns {*}
 */
function verificationPassword(password, newPassword) {
    if (password == null || password.length == 0) {
        return "密码不能为空！";
    }
    if (password.length < 6) {
        return "密码不能少于6个字符！";
    }
    if (password.length > 32) {
        return "密码不能大于32个字符！";
    }

    if (password != newPassword) {
        return "两次密码输入不一致！";
    }
    if (/^(.)\1+$/.test(password)) {
        return "密码不能是连续相同字符";
    }
    return null;
}

/**
 *
 * 校验中英文姓名输入 带长度限制
 * @param password
 * @param newPassword
 * @returns {*}
 */
function verificationName(name) {
    if (name == null || name.length == 0) {
        return "姓名不能为空！";
    }
    if (name.length < 1) {
        return "姓名不能少于2个字符！";
    }
    if (name.length > 60) {
        return "姓名不能大于60个字符！";
    }

    return null;
}



/**
 * 验证手机号码
 * @param mobileNumber
 * @returns {*}
 */
function verificationPhone(mobileNumber) {
    if (mobileNumber == null || mobileNumber.length == 0) {
        return "手机号码不能为空！";
    }

    if (!/^[1]\d{10}$/.test(mobileNumber)) {
        return "请输入正确的手机号码！";
    }
    return null;
}

/**
 * 验证邮箱
 * @param email
 */
function verificationEmail(email) {
    if (email == null || email.length == 0) {
        return "邮箱地址不能为空！";
    }
    if (email.length < 5) {
        return "邮箱地址不能少于5个字符！";
    }
    if (email.length > 60) {
        return "邮箱地址不能大于60个字符！";
    }
    if (!/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(email)) {
        return "请输入正确邮箱地址！";
    }
    return null;
}


/**
 * 验证地址
 * @param address
 */
function verificationAddress(address) {
    //允许为空或者不输入
    if (address == null || address.length == 0) {
        return null;
    }

    if (address != null && address.length > 120) {
        return "公司地址不能大于120个字符！";
    }


    return null;
}

/**
 * 验证职位
 * @param position
 */
function verification(position) {
    //允许为空或者不输入
    if (position == null || position.length == 0) {
        return null;
    }

    if (position != null && position.length > 60) {
        return "验证职位不能大于60个字符！";
    }

    if (!/^[a-zA-Z0-9-_ \u4e00-\u9fa5]+$/.test(position)) {
        return "验证职位须由中英文字母，数字，-和_组成！";
    }
    return null;
}

/**
 *  验证不通过显示红色阴影和提示按时间消失
 * @param ele 需要红色影阴影显示的元素 dom元素
 * @param eleSpan 显示提示的元素 dom元素
 * @param warningStr 提示的文字
 */
function waringBorder(ele, eleSpan, warningStr) {
    var oldStyle = $(ele).attr('style');
    if (oldStyle == undefined) {
        oldStyle = '';
    }
    $(ele).attr('style', oldStyle + ' -webkit-box-shadow: 0 0 10px red; -moz-box-shadow: 0 0 10px red;box-shadow: 0 0 10px red; ');
    $(eleSpan).html(warningStr);
    setTimeout(function () {
        $(ele).attr('style', '');
        $(eleSpan).html('');
    }, 2000);

}

/**
 *  验证不通过显示红色阴影和提示不消失
 * @param ele 需要红色影阴影显示的元素 dom元素
 * @param warningStr 提示的文字
 */
function waringBorderAndSpan(ele, warningStr) {
    var oldStyle = $(ele).attr('style');
    if (oldStyle == undefined) {
        oldStyle = '';
    }
    removeValidateShow(ele);

    $(ele).attr('style', oldStyle + ' -webkit-box-shadow: 0 0 10px red!important; -moz-box-shadow: 0 0 10px red!important;box-shadow: 0 0 10px red!important; ');
    //这里是元素的父元素添加说明
    //先清空
    var eleHeight = $(ele).css('height');
    if (eleHeight == undefined) {
        eleHeight = $(ele).attr('height');
    }
    $(ele).parent().after('<span class="form-control-feedback" aria-hidden="true" style="color: red;line-height: ' + eleHeight + ';text-align:center ">' + warningStr + '</span>');
}

/**
 *  验证不通过显示红色阴影和提示 多个dom元素变红
 * @param ele 需要红色影阴影显示的元素 dom元素数组
 * @param warningStr 提示的文字 数组
 */
function waringBorderAndSpanArray(ele, warningStr) {

    for (var i = 0; i < ele.length; i++) {
        var oldStyle = $(ele[i]).attr('style');
        if (oldStyle == undefined) {
            oldStyle = '';
        }
        removeValidateShow(ele[i]);
        $(ele[i]).attr('style', oldStyle + ' -webkit-box-shadow: 0 0 10px red!important; -moz-box-shadow: 0 0 10px red!important;box-shadow: 0 0 10px red!important; ');
        //这里是元素的父元素添加说明
        //先清空
        var eleHeight = $(ele[i]).css('height');
        if (eleHeight == undefined) {
            eleHeight = $(ele[i]).attr('height');
        }
        $(ele[i]).parent().after('<span class="form-control-feedback" aria-hidden="true" style="color: red;line-height: ' + eleHeight + ';text-align:center " >' + warningStr[i] + '</span>');
    }

}

/**
 *
 * 获取焦点 删除验证状态
 * @param eleSelf 输入input元素
 */
function removeValidateShow(eleSelf) {
    if ($(eleSelf).parent().next()) {
        $(eleSelf).attr('style', '');
        $(eleSelf).parent().next().remove();
    }
}