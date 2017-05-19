package com.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vo.Setting;

@Repository
public class SettingDao {

	@Autowired
	private JdbcTemplate jt;
	
	public void add(Setting set){
		String sql = "insert into usersetting(username,blogname,idiograph,mtime) values(?,?,?,?)";
		jt.update(sql, new Object[]{set.getUsername(), set.getBlogName(), set.getIdiograph(),new Date()});
	}
	
	public Setting getUserSetting(String username){
		String sql = "select username,blogname,idiograph,mtime from usersetting where username=?";
		List<Setting> settings = jt.query(sql, new Object[]{username}, new BeanPropertyRowMapper<Setting>(Setting.class));
		if(settings.size()>0){
			return settings.get(0);
		}
		return null;
	}
	
	public int updateUserSetting(Setting set){
		String sql = "update usersetting set blogname=?, idiograph=?, mtime=? where username=?";
		return jt.update(sql, new Object[]{set.getBlogName(), set.getIdiograph(), new Date(), set.getUsername()});
	}
}
