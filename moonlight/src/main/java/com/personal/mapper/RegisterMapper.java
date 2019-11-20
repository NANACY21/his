package com.personal.mapper;

import com.personal.pojo.Register;
import com.personal.pojo.User;

import java.util.List;

public interface RegisterMapper {
	 public List<User> getDoctors(Register register);
	 public List<Register>getRegister(Register register);
	 public Register getRegisterById(String casenumber);

	public List<User> selectUserIds(Register reg);

	public int selectCaseNum();

	public int insertRegister(Register reg);

	public List<Register> selectRealName(Register reg);

	public Register selectOne(Register reg);

	public int updateVisitState(Register reg);
}