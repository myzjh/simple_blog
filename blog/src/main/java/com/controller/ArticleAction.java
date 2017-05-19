package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.ArticleService;
import com.service.CommentService;
import com.vo.Article;
import com.vo.Comment;
/**
 * 文章控制器
 * @author zhangjh
 *
 */
@Controller
@RequestMapping("/article")
public class ArticleAction {

	@Autowired
	private ArticleService artService;
	@Autowired
	private CommentService comService;
	
	@RequestMapping("/add")
	public @ResponseBody Map<String, Object> add(@RequestBody Article article, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		String username = (String) session.getAttribute("username");
		if(username == null || StringUtils.isEmpty(username)){
			map.put("result", "nologin");
		}else{
			article.setUsername(username);
			int result = artService.add(article);
			map.put("result", result);
		}
		return map;
	}
	
	@RequestMapping("/addPage")
	public String addPage(){
		return "write";
	}
	
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET)
	public String getArticle(@PathVariable int id,ModelMap model){
		model.put("article", artService.getArticle(id));
		
		//comments
		List<Comment> comments = comService.listCommentForArticle(id);
		model.put("comments", comments);
		return "article";
	}
	
	@ResponseBody
	@RequestMapping(value="/del/{id}",method=RequestMethod.GET)
	public String delArticle(@PathVariable int id){
		try{
			artService.delArticle(id);
			return "error:0";
		}catch (Exception e){
			return "error:"+e.getMessage();
		}
	}
}
