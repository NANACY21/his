package com.personal.service.impl;

import java.util.List;

import com.personal.mapper.RegisterMapper;
import com.personal.pojo.Register;
import com.personal.pojo.User;
import com.personal.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrServiceImpl implements RegisterService {
	@Autowired
	private RegisterMapper registermapper;
	
	@Override
	public List<User> getDoctors(Register register) {
		return registermapper.getDoctors(register);
	}

	@Override
	public int getCaseNum() {
		return registermapper.selectCaseNum();
	}

	@Override
	public List<User> getUserIds(Register reg) {
		return registermapper.selectUserIds(reg);
	}

	@Override
	public List<Register> getRealNames(Register reg) {
		return registermapper.selectRealName(reg);
	}

	@Override
	public Register getOne(Register reg) {
		return registermapper.selectOne(reg);
	}

	@Override
	public int editVisitState(Register reg) {
		reg.setVisitstate(3);
		return registermapper.updateVisitState(reg);
	}

	@Override
	public int addRegister(Register reg) {
		return registermapper.insertRegister(reg);
	}

	@Override
	public String getMaxReNum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Register> getRegister(Register register) {
		return registermapper.getRegister(register);
	}

	@Override
	public Register getRegisterById(String casenumber) {
		return registermapper.getRegisterById(casenumber);
	}

}
