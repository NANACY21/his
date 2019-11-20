package com.personal.web.controller;

import java.util.List;

import com.personal.pojo.Department;
import com.personal.pojo.Rule;
import com.personal.pojo.User;
import com.personal.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//@Controller
@RestController
@RequestMapping("/rule")
public class RuleController {

	@Autowired
	private RuleService ruleService;
	@RequestMapping("/userlist.action")
	public List<User> userlist(User user){
		return ruleService.getUsersByMessage(user);
	}

	@RequestMapping("/addrule.action")
	public String addRule(String message){
		String[] strs = message.split("@");

		for(String str:strs){
			String [] r = str.split("-");
			Rule rule = new Rule();
			rule.setRulename(r[0]);
			Department department = new Department();
			department.setId(Integer.valueOf(r[1]));
			rule.setDepartment(department);
			User user = new User();
			user.setId(Integer.valueOf(r[2]));
			rule.setUser(user);
			rule.setWeek(r[3]);
			ruleService.saveRule(rule);
		}
		return "success";
	}

	@PostMapping("/addrules.action")
	@ResponseBody
	public String makeRules(String[] uid, String[] cks, String deptid, String rulename){
		int result = 0;
		result = ruleService.addRule(uid, cks, deptid, rulename);
		if(result>0){
			return "ok";
		}
		return "no";

	}
}
