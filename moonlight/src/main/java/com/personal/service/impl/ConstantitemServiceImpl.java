package com.personal.service.impl;

import java.util.List;

import com.personal.mapper.ConstantItemMapper;
import com.personal.pojo.ConstantItem;
import com.personal.service.ConstantitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ConstantitemServiceImpl implements ConstantitemService {
	
	@Autowired
	private ConstantItemMapper constantitemMapper;
	@Override
	public List<ConstantItem> selectPayService() {
		return constantitemMapper.selectConstantName(5);
	}

}
