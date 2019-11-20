package com.personal.web.controller;

import java.util.List;

import com.personal.mapper.ConstantItemMapper;
import com.personal.pojo.ConstantItem;
import com.personal.service.ConstantitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 医院医疗系统
 */
@Controller
@RequestMapping("/contantsitem")
public class ConstantitemController {
	@Autowired
	private ConstantItemMapper ctm;
	
	@Autowired
	private ConstantitemService cs;

	@GetMapping("/findnames.action")
	@ResponseBody
	public List<ConstantItem> queryContantsitem() {
		return ctm.selectConstantName(1);
	}
	
	@GetMapping("/findpaytype.action")
	@ResponseBody
	public List<ConstantItem> queryContant() {
		return cs.selectPayService();
	}
}
