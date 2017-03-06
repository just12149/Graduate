package graduate.user.service.impl;


import graduate.user.dao.UserDao;
import graduate.user.dao.UserInfoDao;
import graduate.user.model.User;
import graduate.user.model.UserInfo;
import graduate.user.service.UserService;
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
    private UserDao userDao;

    UserInfoDao userInfoDAO;

    public UserInfoDao getUserInfoDAO() {
        return userInfoDAO;
    }

    public void setUserInfoDAO(UserInfoDao userInfoDAO) {
        this.userInfoDAO = userInfoDAO;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 编辑会员
     *
     * @param user
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateUser(User user, UserInfo userInfo) {
        userDao.updateUser(user);
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
        userDao.insertUser(user);

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
        userDao.deleteUser(userId);
    }

    /**
     * 根据会员编号查询会员
     *
     * @param userId
     * @return
     */
    @Override

    public User findUserById(Integer userId) {
        return userDao.selectUserById(userId);

    }

    /**
     * 根据登录账号查询会员
     *
     * @param loginName
     * @return
     */
    @Override

    public User findUserByLoginName(String loginName) {

        User user = userDao.selectUserByLoginName(loginName);
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

        List<User> userList = userDao.selectUserByStateList(userState);
        return userList;
    }

}