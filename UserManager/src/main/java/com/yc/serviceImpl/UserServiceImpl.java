package com.yc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.mybatis.mapper.UserDao;
import com.yc.pojo.User;
import com.yc.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAllUsers(int pagaNo, int size, String search_name, String search_account) {
		return userDao.getAllUsers((pagaNo-1)*size, size, "%"+search_name+"%", "%"+search_account+"%");
	}

	@Override
	public int getCount(String search_name, String search_account) {
		return userDao.getCount("%"+search_name+"%", "%"+search_account+"%");
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}

}
