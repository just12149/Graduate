package graduate.dao;

import graduate.model.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ${niuting} on 2017/2/10.
 */
public interface UserInfoDao {

    //public List<User>query(@Param("pageStart") Integer pageStart, @Param("pageEnd") Integer pageEnd);

    public void insertUserInfo(@Param("userInfo") UserInfo userInfo);

    public void updateUserInfo(@Param("userInfo") UserInfo userinfo);

    public void deleteUserInfo(@Param("userId") Integer userId);

    public UserInfo selectUserInfoByUserId(@Param("userId") Integer userId);
}
