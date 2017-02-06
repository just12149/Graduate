package graduate.service;

import graduate.model.User;
import graduate.model.UserInfo;

import java.util.List;

/**
 * Created by ${niuting} on 2017/1/10.
 */
public interface UserService {
        /**
         * 新增会员
         * @param user

         */
        void saveUser(User user);
        /**
         * 编辑会员
         * @param user

         */
        void updateUser(User user, UserInfo userInfo);

        /**
         * 删除会员
         * @param userId
         */
        void removeUser(Integer userId);

        /**
         * 根据会员编号查询会员
         * @param userId
         * @return
         */
        User findUserById(Integer userId);

        /**
         * 根据登录账号查询会员
         * @param loginName
         * @return
         */
        User findUserByLoginName(String loginName);

        /**
         * 分页查询会员
         * @param loginName
         * @param userName
         * @param userState
         * @param page
         * @return
         */

   /*     PagingResult<User> findUserPage(String loginName,String userName,String userState,PageUtil page);
        *//**
         * 根据状态查询所有会员列表
         * @param userState
         * @return
         */
        List<User> findUserByStateList(Integer userState);
    }




