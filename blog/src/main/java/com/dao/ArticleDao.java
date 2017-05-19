package com.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.util.Page;
import com.vo.Article;
import com.vo.User;

@Repository
public class ArticleDao {

	@Autowired
	private JdbcTemplate jt;
	
	public int add(Article article){
		String sql = "insert into article(title,content,username,ctime,readCount) values(?,?,?,?,?)";
		return jt.update(sql, new Object[]{article.getTitle(), article.getContent(),article.getUsername(),new Date(),0});
	}
	
	public int del(int id){
		String sql = "delete from article where id=?";
		int result = jt.update(sql, new Object[]{id});
		return result;
	}
	
	public List<Article> listArticles(){
		String sql = "select id,title,content,username,ctime,readcount from article order by id desc";
		List<Article> list = jt.query(sql, new BeanPropertyRowMapper<Article>(Article.class));
		return list;
	}
	
	public Page<Article> listArticlesByPage(Page<Article> page){
		String sql = "select id,title,content,username,ctime,readcount from article order by id desc limit ?,?";
		List<Article> list = jt.query(sql, new Object[]{page.getStartItem(), page.getPageSize()}, new BeanPropertyRowMapper<Article>(Article.class));
		page.setList(list);
		
		//count
		String sqlcount = "select count(1) from article";
		int count = jt.queryForObject(sqlcount, new Object[]{}, Integer.class);
		page.setItemCount(count);
		return page;
	}
	
	public List<Article> listArticlesForUser(User user){
		String sql = "select id,title,content,username,ctime,readcount from article where username=? order by id desc";
		List<Article> list = jt.query(sql, new Object[]{user.getUsername()}, new BeanPropertyRowMapper<Article>(Article.class));
		return list;
	}
	
	public Page<Article> listArticlesForUserByPage(User user, Page<Article> page){
		String sql = "select id,title,content,username,ctime,readcount from article where username=? order by id desc limit ?,?";
		List<Article> list = jt.query(sql, new Object[]{user.getUsername(), page.getStartItem(), page.getPageSize()}, new BeanPropertyRowMapper<Article>(Article.class));
		page.setList(list);
		
		//总页数
		String sqlcount = "select count(1) from article where username=?";
		int count = jt.queryForObject(sqlcount, new Object[]{user.getUsername()}, Integer.class);
		page.setItemCount(count);
		return page;
	}
	
	public Article getArticle(int id){
		String sql = "select id,title,content,username,ctime,readcount from article where id=? ";
		return jt.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Article>(Article.class));
	}
	
}
