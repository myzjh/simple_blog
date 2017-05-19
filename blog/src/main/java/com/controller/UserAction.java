package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.ArticleService;
import com.service.SettingService;
import com.service.UserService;
import com.util.Page;
import com.vo.Article;
import com.vo.Setting;
import com.vo.User;
/**
 * 用户控制器
 * @author zhangjh
 *
 */
@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleService artService;
	@Autowired
	private SettingService setService;
	
	@RequestMapping("/loginPage")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(User user, ModelMap model,HttpSession session, Page<Article> page){
		user = userService.login(user);
		if(user == null){
			return "error";
		}
		model.put("user", user);
		session.setAttribute("username", user.getUsername());
		
		Setting set = setService.getUserSetting(user.getUsername());
		session.setAttribute("setting", set);
		
		//article of user
		if(page == null){
			page = new Page<Article>();
		}
		page = artService.listArticlesForUserByPage(user, page);
		model.put("articles", page);
		return "home";
	}
	
	@RequestMapping("/home")
	public String home(ModelMap model, HttpSession session, Page<Article> page){
		String username = (String) session.getAttribute("username");
		if(username == null){
			return "error";
		}
		User user = new User();
		user.setUsername(username);
		model.put("user", user);
		//article of user
		if(page == null){
			page = new Page<Article>();
		}
		page = artService.listArticlesForUserByPage(user, page);
		model.put("articles", page);
		return "home";
	}
	
	@RequestMapping("/home/{num}")
	public String home(@PathVariable int num, ModelMap model, HttpSession session, Page<Article> page){
		String username = (String) session.getAttribute("username");
		if(username == null){
			return "error";
		}
		User user = new User();
		user.setUsername(username);
		model.put("user", user);
		//article of user
		if(page == null){
			page = new Page<Article>();
		}
		page.setCurrentPage(num);
		page = artService.listArticlesForUserByPage(user, page);
		model.put("articles", page);
		return "home";
	}
	
	@RequestMapping("/reg")
	public String toRegister(){
		return "register";
	}
	
	@RequestMapping("/register")
	public String register(User user, HttpSession session){
		boolean flag = userService.register(user);
		System.out.println(flag);
		if(flag){
			session.setAttribute("username", user.getUsername());
			Setting set = setService.getUserSetting(user.getUsername());
			session.setAttribute("setting", set);
			
			return "redirect:/user/home";
		}
		return "error";
	}
	
	@RequestMapping("/setting")
	public String setting(){
		return "setting";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("username");
		return "redirect:/index";
	}
}
