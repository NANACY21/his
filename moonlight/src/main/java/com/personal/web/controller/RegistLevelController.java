package com.personal.web.controller;

import java.util.List;

import com.personal.pojo.RegistLevel;
import com.personal.service.RegistLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



//@Controller
@RestController
@RequestMapping("/registlevel")
public class RegistLevelController {

	@Autowired
	private RegistLevelService registLevelService;
	@RequestMapping("/getalllevels.action")
	public List<RegistLevel> getAll(){
		return registLevelService.getAllRegistLevel();
	}
	@GetMapping("/levelnames.action")
	@ResponseBody
	public List<RegistLevel> levelNames(){
		return registLevelService.queryLevelsNames();
	}
}
