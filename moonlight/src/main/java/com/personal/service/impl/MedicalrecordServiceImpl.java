package com.personal.service.impl;

import com.personal.mapper.MedicalrecordMapper;
import com.personal.pojo.Medicalrecord;
import com.personal.service.MedicalrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicalrecordServiceImpl implements MedicalrecordService {
	@Autowired
	private MedicalrecordMapper mm;
	@Override
	public int addSelective(Medicalrecord record) {
		return mm.insertSelective(record);
	}

}
