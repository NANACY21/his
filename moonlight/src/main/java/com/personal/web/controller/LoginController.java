package com.personal.web.controller;

import javax.servlet.http.HttpSession;

import com.personal.pojo.User;
import com.personal.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/login")
public class LoginController {
	private UserService userService;
	@RequestMapping("/login.action")
	@ResponseBody
	public User getUserByNameAndPass(User user , HttpSession session){
		User u= userService.selectByNameAndPass(user);
		if(null!=u){
			session.setAttribute("user",u);
		}
		return u;
	}
}
