package com.personal.web.controller;

import java.util.List;

import com.personal.pojo.Settlecategory;
import com.personal.service.SettlecategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/settlecategory")
public class SettlecategoryController {
	@Autowired
	private SettlecategoryService settlecategoryService;
	
	@ResponseBody
	@GetMapping("/getSettleName.action")
	public List<Settlecategory> getSettleName(){
		return settlecategoryService.settleNames();
	}
}
