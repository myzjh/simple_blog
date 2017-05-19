package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.service.PhotoService;
import com.vo.Photo;
import com.vo.User;
/**
 * 图片控制类
 * @author zhangjh
 *
 */
@Controller
@RequestMapping("/p")
public class PhotoAction {

	@Autowired
	private PhotoService photoService;
	
	@RequestMapping("/show")
	public String show(ModelMap model){
		String username = "admin";
		User user = new User();
		user.setUsername(username);
		List<Photo> photos = photoService.listPhotoForUser(user);
		model.put("photos", photos);
		return "photo";
	}
	
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, ModelMap model){
		String username = "admin";
		if(file.isEmpty()){
			return "error";
		}
		
		//save file
		String path = request.getSession().getServletContext().getRealPath("/")
				+"userImg/"+username+"_"+System.currentTimeMillis()+"_"+file.getOriginalFilename();
		String uri = "/blog/userImg/"+username+"_"+System.currentTimeMillis()+"_"+file.getOriginalFilename();
		File fileTemp = new java.io.File(path);
		if(!fileTemp.getParentFile().exists()){
			fileTemp.getParentFile().mkdirs();
		}
		try {
			//转存文件
			file.transferTo(fileTemp);
			
			//保存文件信息
			Photo photo = new Photo();
			photo.setUri(uri);
			photo.setUsername(username);
			photoService.add(photo);
		} catch (IllegalStateException e) {
			model.put("err", e.getMessage());
		} catch (IOException e) {
			model.put("err", e.getMessage());
		}
		
		return "redirect:/p/show";
	}
}
