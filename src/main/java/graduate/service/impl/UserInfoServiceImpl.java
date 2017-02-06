package graduate.service.impl;

import graduate.dao.UserInfoDAO;
import graduate.model.UserInfo;
import graduate.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by ${niuting} on 2017/1/12.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDAO userInfoDAO;

    /**
     * 用户信息的新增
     *
     * @param userInfo
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void saveUserInfo(UserInfo userInfo) {
        userInfoDAO.insertUserInfo(userInfo);
    }

    /**
     * 用户信息的修改
     *
     * @param userInfo
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateUserInfo(UserInfo userInfo) {

        userInfoDAO.updateUserInfo(userInfo);
    }

    /**
     * 用户信息的删除
     *
     * @param userId
     */

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void removeUserInfo(Integer userId) {
        userInfoDAO.deleteUserInfo(userId);
    }

    /**
     * 根据用户Id进行用户信息的查询
     *
     * @param userId
     * @return
     */
    @Override

    public UserInfo findUserInfoByUserId(Integer userId) {

        UserInfo userInfo = userInfoDAO.selectUserInfoByUserId(userId);

        return userInfo;

    }

}
