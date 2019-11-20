package com.personal.mapper;

import com.personal.pojo.User;

import java.util.List;



public interface UserMapper {
	List<User> selectUsersByDeptAndRegistLevel(User user);
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
	public List<User> getDoctorsByDeptNoAndLevel(User user);
	User selectByNameAndPass(User user);

	public List<User> selectDoctors(User user);

	User selectUser(User user);

	List<User> selectRealName(Integer usertype);
}