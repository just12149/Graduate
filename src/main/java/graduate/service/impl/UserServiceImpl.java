package graduate.service.impl;


import graduate.dao.UserDAO;
import graduate.dao.UserInfoDAO;
import graduate.model.User;
import graduate.model.UserInfo;
import graduate.service.UserService;
import graduate.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${niuting} on 2017/1/11.
 */

@Service
public class UserServiceImpl implements UserService {
    /* @Resource(name="userao")*/
    @Resource
    private UserDAO userDAO;

    UserInfoDAO userInfoDAO;

    public UserInfoDAO getUserInfoDAO() {
        return userInfoDAO;
    }

    public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
        this.userInfoDAO = userInfoDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * 编辑会员
     *
     * @param user
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateUser(User user, UserInfo userInfo) {
        userDAO.updateUser(user);
    }

    /**
     * 新增会员
     *
     * @param user
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void saveUser(User user) {
        user.setLoginTime(DateUtils.getCurrentTime(DateUtils.FORMAT_19));
        userDAO.insertUser(user);

       /* userInfo.setInfoId(user.getUserId());
        userInfo.setUserId(user.getUserId());
        userInfoDAO.insertUserInfo(userInfo);*/


    }

    /**
     * 删除会员
     *
     * @param userId
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void removeUser(Integer userId) {
        userDAO.deleteUser(userId);
    }

    /**
     * 根据会员编号查询会员
     *
     * @param userId
     * @return
     */
    @Override

    public User findUserById(Integer userId) {


        return userDAO.selectUserById(userId);

    }

    /**
     * 根据登录账号查询会员
     *
     * @param loginName
     * @return
     */
    @Override

    public User findUserByLoginName(String loginName) {

        User user = userDAO.selectUserByLoginName(loginName);
        return user;
    }


    /**
     * 根据状态查询所有会员列表
     *
     * @param userState
     * @return
     */
    @Override

    public List<User> findUserByStateList(Integer userState) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (!StringUtils.isEmpty(userState)) {
            param.put("userState", userState);
        }

        List<User> userList = userDAO.selectUserByStateList(userState);
        return userList;
    }

}