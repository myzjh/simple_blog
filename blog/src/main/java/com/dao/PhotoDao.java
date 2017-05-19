package com.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vo.Photo;
import com.vo.User;

@Repository
public class PhotoDao {

	@Autowired
	private JdbcTemplate jt;
	
	public void add(Photo photo){
		String sql = "insert into userphoto(username,uri,ctime) values(?,?,?)";
		jt.update(sql, new Object[]{photo.getUsername(), photo.getUri(), new Date()});
	}
	
	public List<Photo> listPhotoForUser(User user){
		String sql = "select uri,ctime from userphoto where username=?";
		return jt.query(sql, new Object[]{user.getUsername()}, new BeanPropertyRowMapper<Photo>(Photo.class));
	}
}
