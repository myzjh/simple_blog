package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.CommentService;
import com.vo.Comment;
/**
 * 评论控制器
 * @author zhangjh
 *
 */
@Controller
@RequestMapping("/comment")
public class CommentAction {

	@Autowired
	private CommentService comService;
	
	@RequestMapping("/say")
	public @ResponseBody Map<String, Object> add(@RequestBody Comment com, HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		String username = (String) session.getAttribute("username");
		if(StringUtils.isEmpty(username)){
			map.put("result", "nologin");
		}else{
			com.setUsername(username);
			int result = comService.addComment(com);
			map.put("result", result);
		}
		return map;
	}
	
	@RequestMapping(value="/comments/{aid}")
	public @ResponseBody Map<String, Object> listCommentsForArticle(@PathVariable int aid){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Comment> result = comService.listCommentForArticle(aid);
		map.put("result", result);
		return map;
	}
}
