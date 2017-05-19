package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SettingDao;
import com.vo.Setting;

@Service
public class SettingService {

	@Autowired
	private SettingDao setDao;
	
	public void add(Setting set){
		setDao.add(set);
	}
	
	public Setting getUserSetting(String username){
		return setDao.getUserSetting(username);
	}
	
	public void updateUserSetting(Setting set){
		Setting temp = setDao.getUserSetting(set.getUsername());
		if(temp == null){
			setDao.add(set);
		}else{
			setDao.updateUserSetting(set);
		}
	}
}
