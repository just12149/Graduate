package graduate.action;

import graduate.model.User;
import graduate.service.UserInfoService;
import graduate.service.UserService;
import graduate.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ${niuting} on 2017/1/17.
 */

@Controller
@RequestMapping("/yonhu")
public class YonhuAction {

    @Resource
    UserService userService;
    @Resource
    UserInfoService  userInfoService;


    //验证会员登录
    @ResponseBody
    @RequestMapping("/login.do")
    public Map<String, Object> Login(HttpServletRequest request, HttpServletResponse response) {

        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");
        // String validateCode = request.getParameter("validateCode");

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);

        if (StringUtils.isEmpty(loginName)) {
            result.put("success", false);
            result.put("msg", "登录账号不能为空！");
            return result;
        }

        if (StringUtils.isEmpty(loginPwd)) {
            result.put("success", false);
            result.put("msg", "登录密码不能为空！");
            return result;
        }

        // 验证输入合法性
        // 只能输入由数字、26个英文字母或者下划线组成的字符串："^\w+$"。
        String regEx = "\\w+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(loginName);
        if (!matcher.matches()) {
            result.put("success", false);
            result.put("msg", "登录账号不存在！");
            return result;
        }

        if (!pattern.matcher(loginPwd).matches()) {
            result.put("success", false);
            result.put("msg", "登录密码错误！");
            return result;
        }

        HttpSession session = request.getSession();
        User user = userService.findUserByLoginName(loginName);
        if (user == null) {
            result.put("success", false);
            result.put("msg", "登录账号不存在！");
            return result;
        } else {
            if (loginPwd.equals(user.getLoginPwd())) {
                result.put("success", false);
                result.put("msg", "登录密码错误！");
                return result;
            }else{

                //验证登录账户密码成功 设置session
                user.setLoginTime(DateUtils.getCurrentTime(DateUtils.FORMAT_19));
                if (user.getLoginNumber() != null) {
                    Integer loginNumber = Integer.parseInt(user.getLoginNumber());
                    loginNumber = loginNumber++;
                    user.setLoginNumber(loginNumber.toString());
                } else {
                    user.setLoginNumber("1");
                }

                //更新对应user的登录时间信息
             //   Integer userId = user.getUserId();
              //  userService.updateUser(user, userInfoService.findUserInfoByUserId(user.getUserId()));
                return result;
            }

        }



    }
    //请求会员登录页面
    @RequestMapping("/loginPage.do")
    public ModelAndView vipPageRequest(HttpServletRequest request) {
        return  new ModelAndView("user/login");

    }


    //跳转会员注册页面
    @RequestMapping("/registPage.do")
    public ModelAndView toVipInfoPage(HttpServletRequest request) {
        return new ModelAndView("regist/regist");
    }



}
