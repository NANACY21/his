package com.personal.service.impl;

import java.util.List;

import com.personal.mapper.SettlecategoryMapper;
import com.personal.pojo.Settlecategory;
import com.personal.service.SettlecategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SettlecategoryServiceImpl implements SettlecategoryService {
	@Autowired
	private SettlecategoryMapper settlecategorymapper;
	
	@Override
	public List<Settlecategory> settleNames() {
		return settlecategorymapper.selectName();
	}

}
