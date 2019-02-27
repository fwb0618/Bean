package com.yc.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yc.pojo.User;

@Repository
public interface UserDao {
	
	//取全部用户+分页+按条件匹配
	public List<User> getAllUsers(@Param("skip") int skip,@Param("size") int size,
			@Param("search_name") String search_name,@Param("search_account") String search_account);
	
	//用户数量
	public int getCount(@Param("search_name") String search_name,@Param("search_account") String search_account);
	
	//添加用户
	public int addUser(User user);
	
	//更新用户
	public int updateUser(User user);
	
	//删除用户
	public int deleteUserById(int id);
	
}
