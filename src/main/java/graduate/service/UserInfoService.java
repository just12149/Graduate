package graduate.service;

import graduate.model.UserInfo;

/**
 * Created by ${niuting} on 2017/1/11.
 */
public interface UserInfoService {

    /**
     * 编辑用户信息
     * @param userInfo
     */

    void saveUserInfo(UserInfo userInfo);

    /**
     * 修改用户信息
     * @param userInfo
     */
    void updateUserInfo(UserInfo userInfo);

    /**
     * 删除用户信息
     * @param userId
     */
    void removeUserInfo(Integer userId);

    /**
     * 根据用户Id查询用户信息
     * @param userId
     * @return
     */
    UserInfo findUserInfoByUserId(Integer userId);







}
