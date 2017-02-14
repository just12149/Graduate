package graduate.action;

import graduate.model.User;
import graduate.model.UserInfo;
import graduate.service.UserInfoService;
import graduate.service.UserService;
import graduate.utils.DateUtils;
import graduate.utils.Md5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ${niuting} on 2017/1/11.
 */

@Controller
@RequestMapping("/user")
public class UserAction {

    @Resource
    private UserService userService;

    @Resource
    private UserInfoService userInfoService;

    //请求会员登录页面
    @RequestMapping("/loginPage.do")
    public ModelAndView PageRequest(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("user/login");
        return modelAndView;
    }

    //跳转会员注册页面
    @RequestMapping("/registPage.do")
    public ModelAndView InfoPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("regist/regist");
        return modelAndView;
    }

      //跳转会员私人信息页
      @RequestMapping("/userInfoPage.do")
      public ModelAndView userInfo(HttpServletRequest request) {
          ModelAndView modelAndView = new ModelAndView("user/userInfo");
          HttpSession session = request.getSession();
          Map<String, Object> map = new HashMap<String, Object>();
          if (session != null) {
              User user = (User) session.getAttribute("user");

              Integer userId = user.getUserId();
              UserInfo userInfo = userInfoService.findUserInfoByUserId(userId);
              map.put("user", user);
              map.put("userInfo", userInfo);
              modelAndView.addAllObjects(map);
          }
          return modelAndView;
      }

      //跳转密码找回页面
      @RequestMapping("/PwdGetBackPage.do")
      public ModelAndView PwdGetBack(HttpServletRequest request) {
          ModelAndView modelAndView = new ModelAndView("user/pwdGetback");
          return modelAndView;
      }
      //跳转密码修改页面
      @RequestMapping("/updatePwdPage.do")
      public String ModifyPwd(HttpServletRequest request) {
          return "user/updatePwd";
      }

    //跳入主页面

    @RequestMapping("/main.do")

    public ModelAndView GoMain(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("user/main");
        return modelAndView;
    }

    //跳入主页面

    @RequestMapping("/admin.do")

    public ModelAndView GoAdmin(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("user/admin");
        return modelAndView;
    }

    //获取Cookie记录
    @ResponseBody
    @RequestMapping("/getCookies.do")
    public Map<String, Object> getCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String loginName = request.getParameter("loginName");
        String loginPwd = "";
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                if (StringUtils.equals(cookies[i].getName(), loginName)) {
                    loginPwd = cookies[i].getValue();
                }
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginPwd", loginPwd);
        return map;
    }

    //验证会员登录
    @ResponseBody
    @RequestMapping("/login.do")
    public Map<String, Object> Login(HttpServletRequest request, HttpServletResponse response) {
        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");
        String validateCode = request.getParameter("validateCode");

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

        if (StringUtils.isEmpty(validateCode)) {
            result.put("success", false);
            result.put("msg", "验证码不能为空！");
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

        if (!pattern.matcher(validateCode).matches()) {
            result.put("success", false);
            result.put("msg", "验证码错误！");
            return result;
        }

        //校验验证码 在请求登录页面的时候session 已经被创建
        HttpSession session = request.getSession();
        //在验证码中请求方法中有session.setAttribute(session.getId(), randomCode.toString());
        if (session.getAttribute(session.getId()) != null) {
            String code = (String) session.getAttribute(session.getId());
            if (!code.toLowerCase().equals(validateCode.trim().toLowerCase())) {
                result.put("success", false);
                result.put("msg", "验证码错误！");
                return result;
            }
        } else {
            result.put("success", false);
            result.put("msg", "验证码错误！");
            return result;
        }
        //验证登录账户密码
        User user = userService.findUserByLoginName(loginName);
        if (user == null) {
            result.put("success", false);
            result.put("msg", "登录账号不存在！");
            return result;
        } else {
            if (!user.getLoginPwd().equals(Md5Util.toMD5(loginPwd.trim()))) {
                result.put("success", false);
                result.put("msg", "登录密码错误！");
                return result;
            }
            //如果用户状态不为0则禁止，则不准登录
            if (!user.getUserState().equals("0")) {
                result.put("success", false);
                result.put("msg", "该账号已被禁用，请联系管理员！");
                return result;
            }
            //验证登录账户密码成功 设置session
            //更新对应user的登录时间信息
            user.setLoginTime(DateUtils.getCurrentTime(DateUtils.FORMAT_19));
            //更新对应user的登录次数信息
            if (user.getLoginNumber() != null) {
                Integer loginNumber = Integer.parseInt(user.getLoginNumber());
                loginNumber++;
                user.setLoginNumber(String.valueOf(loginNumber));
            } else {
                user.setLoginNumber("1");
            }
            //设置cookies 记住账户密码
            String remeberMe = request.getParameter("remeberMe");
            if (StringUtils.equalsIgnoreCase("true", remeberMe)) {
                Cookie userInfoCooki = new Cookie(user.getLoginName(), loginPwd.trim());
                userInfoCooki.setMaxAge(1000 * 60 * 60 * 24);
                response.addCookie(userInfoCooki);
            }
            Integer userId = user.getUserId();
            userService.updateUser(user, userInfoService.findUserInfoByUserId(user.getUserId()));
            //移除session中的验证码信息
            session.removeAttribute(session.getId());
            //设置15分钟过期
            session.setMaxInactiveInterval(900);
            session.setAttribute("user", user);
            session.setAttribute("userName", user.getUserName());
            session.setAttribute("roleId",user.getRoleId());
        }
        return result;
    }

    //会员注册
    @ResponseBody
    @RequestMapping("/Regist.do")
    public Map<String, Object> Regist(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        //StringUtils.isEmpty()
        if (request.getParameter("loginName") == null || request.getParameter("loginName").equals("")) {
            map.put("state", "帐户名为空");
            return map;
        }
        if (userService.findUserByLoginName(request.getParameter("loginName")) != null) {
            map.put("state", "帐户名重复");
            return map;
        } else {
            User user = new User();
            UserInfo userInfo = new UserInfo();

            user.setLoginName(request.getParameter("loginName"));
            user.setLoginPwd(Md5Util.toMD5(request.getParameter("loginPwd")));
            user.setUserName(request.getParameter("userName"));
            user.setCreatedTime(DateUtils.getCurrentTime(DateUtils.FORMAT_19));
            user.setLoginNumber("0");
            user.setUserState("0");

            userInfo.setSex(Integer.parseInt(request.getParameter("sex")));
            userInfo.setTel(request.getParameter("tel"));
            userInfo.setEducation(Integer.parseInt(request.getParameter("education")));
            userInfo.setAge(Integer.parseInt(request.getParameter("age")));
            userInfo.setMail(request.getParameter("email"));
            userInfo.setAddress(request.getParameter("province"));

            userService.saveUser(user);
            userInfo.setUserId(user.getUserId());
            userInfoService.saveUserInfo(userInfo);

            map.put("state", "注册成功");
            map.put("user", user);
            map.put("UserInfo", userInfo);
            //添加session 登录管理中心用
            HttpSession session = request.getSession();
            //账户密码设置session
            user.setLoginTime(DateUtils.getCurrentTime(DateUtils.FORMAT_19));
            if (user.getLoginNumber() != null) {
                Integer loginNumber = Integer.parseInt(user.getLoginNumber());
                loginNumber++;
                user.setLoginNumber(String.valueOf(loginNumber));
            } else {
                user.setLoginNumber("1");
            }
            //更新对应user的登录时间信息
            userService.updateUser(user, userInfoService.findUserInfoByUserId(user.getUserId()));
            //移除session中的验证码信息
            session.removeAttribute(session.getId());
            //设置15分钟过期
            session.setMaxInactiveInterval(900);
            session.setAttribute("user", user);
            session.setAttribute("userName", user.getUserName());
            map.put("isContainUser", false);
            return map;
        }
    }


    //注册会员账户检查是否重复
    @ResponseBody
    @RequestMapping("/vipCheckUserNameDuplicate.do")
    public Map<String, Object> vipCheckUserNameDuplicate(HttpServletRequest request) {
        String userLoginName = request.getParameter("loginName");
        Map<String, Object> map = new HashMap<String, Object>();
        if (userLoginName != null && !userLoginName.equals("")) {
            User user = userService.findUserByLoginName(userLoginName);
            if (user != null) {
                map.put("isContainUser", true);
                return map;
            } else {
                return map;
            }
        } else {
            map.put("error", "loginName 是空");
            return map;
        }
    }

    //密码找回action
    @ResponseBody
    @RequestMapping("/GetPwdBack.do")
    public Map<String, Object> GetPwdBack(HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();
        User user = userService.findUserByLoginName(request.getParameter("loginName"));
        if (user == null) {
            result.put("msg", "登录账户未注册");
            return result;
        }
        if (user != null) {
            UserInfo userInfo = userInfoService.findUserInfoByUserId(user.getUserId());

            if (userInfo.getMail().equals(request.getParameter("email"))) {
                result.put("success", true);
                result.put("msg", "登录账号和Mail地址匹配成功");
                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(600);
                session.setAttribute("user", user);
                session.setAttribute("userExist", (user != null));

                return result;
            }
        }

        result.put("success", false);
        result.put("msg", "登录账号和mail地址匹配不成功");
        return result;
    }


    //会员信息修改
    @ResponseBody
    @RequestMapping("/UserInfoUpdate.do")
    public boolean UserInfoUpdate(HttpServletRequest request) {
        HttpSession session = request.getSession();

        User user = userService.findUserById(Integer.parseInt(request.getParameter("userId")));
        String userId = request.getParameter("userId");
        System.out.println(userId);
        UserInfo userInfo = userInfoService.findUserInfoByUserId(Integer.parseInt(userId));
        user.setUserName(request.getParameter("userName"));
        userInfo.setAddress(request.getParameter("address"));
        userInfo.setAge(Integer.parseInt(request.getParameter("age")));
        userInfo.setEducation(Integer.parseInt(request.getParameter("education")));
        userInfo.setMail(request.getParameter("email"));
        userInfo.setSex(Integer.parseInt(request.getParameter("sex")));
        userInfo.setTel(request.getParameter("tel"));
        try {
            userService.updateUser(user,userInfo);
            userInfoService.updateUserInfo(userInfo);
            session.setAttribute("userName", request.getParameter("userName"));
            session.setAttribute("user", user);
            return true;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return false;
    }


    //获取会员信息
    @ResponseBody
    @RequestMapping("/getVipInfo.do")
    public Map<String, Object> getVipInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<String, Object>();
        if (session != null) {
            User user = (User) session.getAttribute("user");
            Integer userId = user.getUserId();
            UserInfo userInfo = userInfoService.findUserInfoByUserId(userId);

            map.put("user", user);
            map.put("userInfo", userInfo);

        } else {
            //如果session里的用户不存在或者失效了。再次请求用户。
//            String userId = request.getParameter("userId");
//            if(userId!=null) {
//                User user = userService.findUserById(Integer.parseInt(userId));
//                map.put("user", user);
//            }
        }
        return map;
    }


    //修改会员登录后的密码
    @ResponseBody
    @RequestMapping("/modifyOldPass.do")
    public Map<String, Object> modifyOldPass(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            String oldPwd = request.getParameter("oldPwd");
            String newPwd = request.getParameter("newPwd");
            HttpSession session = request.getSession();
            User user = new User();
            if (session != null) {
                user = (User) session.getAttribute("user");
                String old = Md5Util.toMD5(oldPwd);
                if (user.getLoginPwd().equals(Md5Util.toMD5(oldPwd))) {
                    user.setLoginPwd(Md5Util.toMD5(newPwd));
                    userService.updateUser(user, null);
                    map.put("msg", "修改成功");
                    map.put("success", "true");
                } else {
                    map.put("msg", "原密码错误");
                    map.put("success", false);
                }
            } else {
                map.put("success", "false");
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("success", "false");
        return map;


    }

    //非验证修改密码
    @ResponseBody
    @RequestMapping("/PwdRevise.do")
    public Map<String, Object> vipPassRevise(HttpServletRequest request) {
        String newPass = request.getParameter("newPass");
        HttpSession session = request.getSession();
        User user = new User();
        Map<String, Object> result = new HashMap<String, Object>();
        if (session != null) {
            user = (User) session.getAttribute("user");
            user.setLoginPwd(Md5Util.toMD5(newPass));
            //修改新密码
            userService.updateUser(user, null);
            result.put("success", true);
            return result;
        }
        result.put("success", true);
        return result;
    }


    /**
     * 退出登录
     *
     * @param request
     * @param attr
     * @return
     */
    @ResponseBody
    @RequestMapping("/logout.do")
    public Map<String, Object> logout(HttpServletRequest request, RedirectAttributes attr) {
        //invalidate()使无效,作废
        request.getSession().invalidate();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        return result;
    }

}
