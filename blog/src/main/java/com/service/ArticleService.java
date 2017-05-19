package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ArticleDao;
import com.util.Page;
import com.vo.Article;
import com.vo.User;

@Service
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	public int add(Article article){
		return articleDao.add(article);
	}
	
	public List<Article> listArticles(){
		return articleDao.listArticles();
	}
	
	public Page<Article> listArticlesByPage(Page<Article> page){
		return articleDao.listArticlesByPage(page);
	}
	
	public List<Article> listArticlesForUser(User user){
		return articleDao.listArticlesForUser(user);
	}
	
	public Page<Article> listArticlesForUserByPage(User user, Page<Article> page){
		return articleDao.listArticlesForUserByPage(user, page);
	}
	
	public Article getArticle(int id){
		return articleDao.getArticle(id);
	}
	
	public void delArticle(int id){
		articleDao.del(id);
	}
}
