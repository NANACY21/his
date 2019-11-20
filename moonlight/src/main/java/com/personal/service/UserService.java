package com.personal.service;

import com.personal.pojo.Department;
import com.personal.pojo.User;

import java.util.List;



public interface UserService {
	public List<User> getDoctors(User user);
	
	public User login(User user);

	public List<User> getDocRealName(Integer usertype);
	List<Department> getAllDept();

	User selectByNameAndPass(User user);
}
