package com.personal.service.impl;

import com.personal.mapper.InvoiceMapper;
import com.personal.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceMapper invmapper;
	@Override
	public String getMaxInNum() {
	
		return invmapper.getInvoicenum();
	}

	@Override
	public int getID() {
		return invmapper.selectMaxID();
	}

}
