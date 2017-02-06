package graduate.dao;

import graduate.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ${niuting} on 2017/1/10.
 */
@Service
public  interface UserDAO {


    public Integer findCount();

    public List<User> query(@Param("pageStart") Integer pageStart, @Param("pageEnd") Integer pageEnd);

    public void insertUser(@Param("user") User user);

    public void updateUser(@Param("user") User user);

    public void deleteUser(@Param("userId") Integer userId);


    public User  selectUserById(@Param("userId") Integer userId);

    public User selectUserByLoginName(@Param("loginName") String loginName);


    public List<User> selectUserByStateList(@Param("userState") Integer userState);


}

