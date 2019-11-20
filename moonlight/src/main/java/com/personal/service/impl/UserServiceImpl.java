package com.personal.service.impl;

import java.util.List;

import com.personal.mapper.DepartmentMapper;
import com.personal.mapper.UserMapper;
import com.personal.pojo.Department;
import com.personal.pojo.User;
import com.personal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper usermapper;
	@Autowired
	private DepartmentMapper daptmapper;
	@Override
	public List<User> getDoctors(User user) {
		return usermapper.selectDoctors(user);
//		usermapper.getDoctorsByDeptNoAndLevel(user);
	}

	@Override
	public User login(User user) {
		return usermapper.selectUser(user);
	}

	@Override
	public List<User> getDocRealName(Integer usertype) {
		return usermapper.selectRealName(usertype);
	}

	@Override
	public List<Department> getAllDept() {
		return daptmapper.selectAllDepartments();
	}

	@Override
	@Transactional(readOnly = true)
	public User selectByNameAndPass(User user) {
		return usermapper.selectByNameAndPass(user);
	}

}
