package cn.wxf.note.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.wxf.note.entity.User;
@Repository("userDao")
public interface UserDao {
	User findByName(String name);
	int addUser(User user);
	User findById(String userId);
	int changePwd(@Param("userId") String userId, @Param("newPassword") String newPassword);
}
