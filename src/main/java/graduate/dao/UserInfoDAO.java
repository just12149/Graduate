package graduate.dao;


import graduate.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * Created by ${niuting} on 2017/1/11.
 */
@Service

public interface UserInfoDAO {



    //public List<User>query(@Param("pageStart") Integer pageStart, @Param("pageEnd") Integer pageEnd);

    public void insertUserInfo(@Param("userInfo") UserInfo userInfo);

    public void updateUserInfo(@Param("userInfo") UserInfo userinfo);

    public void deleteUserInfo(@Param("userId") Integer userId);

    public UserInfo selectUserInfoByUserId(@Param("userId") Integer userId);



}
