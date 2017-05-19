package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.SettingService;
import com.vo.Setting;
/**
 * 用户设置控制器
 * @author zhangjh
 *
 */
@Controller
@RequestMapping("/setting")
public class SettingAction {

	@Autowired
	private SettingService setService;
	
	@RequestMapping("/update")
	public String update(Setting set, HttpSession session){
		String username = (String)session.getAttribute("username");
		if(username == null){
			return "error";
		}
		set.setUsername(username);
		setService.updateUserSetting(set);
		return "redirect:/user/home";
	}
}
