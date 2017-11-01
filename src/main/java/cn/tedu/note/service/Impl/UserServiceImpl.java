package cn.tedu.note.service.Impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;
import cn.tedu.note.service.PasswordException;
import cn.tedu.note.service.UserNameException;
import cn.tedu.note.service.UserNotFoundException;
import cn.tedu.note.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")
	private UserDao userDao;
	@Value("#{jdbc.salt}")
	private String salt;
	public User login(String name, String password) throws UserNotFoundException, PasswordException {
		System.out.println("login");
		
		
		User user = userDao.findByName(name.trim());
		if(password==null || password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		if(name==null || name.trim().isEmpty()){
			throw new UserNotFoundException("用户名不能为空");
		}
		
		if(user==null){
			throw new UserNotFoundException("用户不存在");
		}
		String pwd = DigestUtils.md5Hex(password+"还在吃屎吗");
		
		if(pwd.equals(user.getPassword())){
			return user;
		}
		throw new PasswordException("密码错误");
		
	}

	public User regist(String name, String nick, String password, String confirm)
			throws UserNameException, PasswordException {
		//检查name，不能重复
		if(name==null || name.trim().isEmpty()){
			throw new UserNameException("用户名不能为空");
		}
		User u = userDao.findByName(name);
		if(u!=null){
			throw new UserNameException("该用户名已注册");
		}
		//检查密码
		if(password==null || password.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		if(confirm==null || confirm.trim().isEmpty()){
			throw new PasswordException("密码不能为空");
		}
		if(!password.equals(confirm)){
			throw new PasswordException("前后密码不一致");
		}
		//检查nick
		if(nick==null || nick.trim().isEmpty()){
			nick=name;
		}
		User user = new User();
		String id = UUID.randomUUID().toString();
		String token = "";
		user.setId(id);
		user.setName(name);
		user.setNick(nick);
		password = DigestUtils.md5Hex(password+salt);
		user.setPassword(password);
		user.setToken(token);
		int n = userDao.addUser(user);
		if(n!=1){
			throw new RuntimeException("添加失败");
		}
		return user;
	}

	public int changePwd(String userId,String password,String newPassword,String finalPassword) throws UserNotFoundException {
		if(userId==null || userId.trim().isEmpty()){
			throw new UserNotFoundException("该用户不存在");
		}
		User user = userDao.findById(userId);
		password= DigestUtils.md5Hex(password+"还在吃屎吗");
		if(!user.getPassword().equals(password)){
			throw new UserNotFoundException("密码错误");
		}
		if(!newPassword.equals(finalPassword)){
			throw new UserNotFoundException("前后密码不一致");
		}
		newPassword=DigestUtils.md5Hex(newPassword+"还在吃屎吗");
		int i=userDao.changePwd(userId,newPassword);
		return i;
	}

}
