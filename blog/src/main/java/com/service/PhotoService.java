package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PhotoDao;
import com.vo.Photo;
import com.vo.User;

@Service
public class PhotoService {

	@Autowired
	private PhotoDao photoDao;
	
	public void add(Photo photo){
		photoDao.add(photo);
	}
	
	public List<Photo> listPhotoForUser(User user){
		return photoDao.listPhotoForUser(user);
	}
}
