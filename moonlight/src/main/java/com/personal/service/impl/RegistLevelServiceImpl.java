package com.personal.service.impl;

import java.util.List;

import com.personal.mapper.RegistLevelMapper;
import com.personal.pojo.RegistLevel;
import com.personal.service.RegistLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class RegistLevelServiceImpl implements RegistLevelService {

	@Autowired
	private RegistLevelMapper registLevelMapper;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<RegistLevel> getAllRegistLevel() {
		return registLevelMapper.selectAllRegistLevels();
	}

	@Override
	public List<RegistLevel> queryLevelsNames() {
		return registLevelMapper.queryLevels();
	}

}
