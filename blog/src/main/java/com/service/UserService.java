package com.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dao.UserDao;
import com.vo.User;
/**
 * 业务逻辑
 * @author zhangjh
 *
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public boolean register(User user){
		Logger.getLogger(UserService.class).error(user.getUsername()+"_"+user.getPassword());
		if(StringUtils.isEmpty(user.getUsername())|| StringUtils.isEmpty(user.getPassword())){
			return false;
		}else{
			userDao.register(user);
			return true;
		}
	}
	
	public User login(User user){
		return userDao.login(user);
	}
}
