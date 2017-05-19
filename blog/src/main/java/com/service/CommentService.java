package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CommentDao;
import com.vo.Comment;

@Service
public class CommentService {

	@Autowired
	private CommentDao comDao;
	
	public int addComment(Comment com){
		return comDao.add(com);
	}
	
	public List<Comment> listCommentForArticle(int aid){
		return comDao.listCommentForArticle(aid);
	}
}
