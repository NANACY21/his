package com.personal.service;

import com.personal.pojo.Register;
import com.personal.pojo.User;

import java.util.List;

public interface RegisterService {
	int getCaseNum();

	public List<User> getUserIds(Register reg);

	public List<Register> getRealNames(Register reg);

	public Register getOne(Register reg);

	public int editVisitState(Register reg);

	public int addRegister(Register reg);

	String getMaxReNum();

	public List<User> getDoctors(Register register);

	public List<Register> getRegister(Register register);

	public Register getRegisterById(String casenumber);
}

