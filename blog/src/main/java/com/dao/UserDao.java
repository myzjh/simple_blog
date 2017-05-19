package com.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.util.CommonsUtil;
import com.vo.User;
/**
 * Repository用于标注数据访问组件，即DAO组件
 */
@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jt;
	
	public void register(User user){
		String sql = "insert into user(username,nickname,password,question,answer,ctime) values(?,?,?,?,?,?)";
		jt.update(sql, new Object[]{user.getUsername(), user.getNickname(), CommonsUtil.md5(user.getPassword()), user.getQuestion(), user.getAnswer(), new Date()});
	}
	
	public User login(User user){
		String sql = "select username,password from user where username=? and password=?";
		try{
			return jt.queryForObject(sql, new Object[]{user.getUsername(), CommonsUtil.md5(user.getPassword())}, new BeanPropertyRowMapper<User>(User.class));
		}catch (Exception e){
			System.out.println("login err:"+e.getMessage());
		}
		return null;
	}
}
