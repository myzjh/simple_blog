package com.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vo.Comment;

@Repository
public class CommentDao {

	@Autowired
	private JdbcTemplate jt;
	
	public int add(Comment com){
		String sql = "insert into comment(aid,content,username,ctime) values(?,?,?,?)";
		return jt.update(sql, new Object[]{com.getAid(),com.getContent(),com.getUsername(),new Date()});
	}
	
	public List<Comment> listCommentForArticle(int aid){
		String sql = "select id,aid,content,username,ctime from comment where aid=?";
		return jt.query(sql, new Object[]{aid}, new BeanPropertyRowMapper<Comment>(Comment.class));
	}
}
