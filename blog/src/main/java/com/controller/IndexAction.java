package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.ArticleService;
import com.util.Page;
import com.vo.Article;
/**
 * 主页控制器
 * @author zhangjh
 *
 */
@Controller
public class IndexAction {
	
	@Autowired
	private ArticleService artService;
	
	@RequestMapping("/index")
	public String index(Page<Article> page, ModelMap model){
		if(page == null){
			page = new Page<Article>();
		}
		page = artService.listArticlesByPage(page);
		model.put("articles", page);
		return "index";
	}
	
	@RequestMapping("/index/{num}")
	public String indexOfPage(@PathVariable int num, Page<Article> page, ModelMap model){
		if(page == null){
			page = new Page<Article>();
		}
		page.setCurrentPage(num);
		Page<Article> list = artService.listArticlesByPage(page);
		model.put("articles", list);
		return "index";
	}
}
