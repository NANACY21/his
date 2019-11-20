package com.personal.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.personal.pojo.Department;
import com.personal.pojo.User;
import com.personal.service.DepartmentService;
import com.personal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private DepartmentService deptService;
	@Autowired
	private UserService userservicr;

	@GetMapping("/getalldept.action")
	@ResponseBody
	public List<Department> getDept() {
		return userservicr.getAllDept();
	}

	@PostMapping("/getdoctors.action")
	@ResponseBody
	public List<User> getdoctors(User user) {
		return userservicr.getDoctors(user);
	}

	@RequestMapping("/login.action")
	@ResponseBody
	public User getUserByNameAndPass(User user, HttpSession session) {
		System.out.println(user.getPassword());
		User u = userservicr.selectByNameAndPass(user);
		System.out.println(u);
		if (null != u) {
			session.setAttribute("user", u);
		}
		return u;
	}

	@RequestMapping("/logout.action")
	@ResponseBody
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		session.invalidate();
		return "success";
	}
	@GetMapping("/depts.action")
	@ResponseBody
	public List<Department> queryDepts(){
		return deptService.listDepts();
	}

	@PostMapping("/getdoctors.action")
	@ResponseBody
	public List<User> Userswork(User user){
		return userservicr.getDoctors(user);
	}

	@PostMapping("/login.action")
	@ResponseBody
	public User userLogin(User user,HttpSession session){
		User u = userservicr.login(user);
		if(u!=null){
			session.setAttribute("user",u);
		}
		return u;
	}

	@GetMapping("/logout.action")
	@ResponseBody
	public String userLogout(HttpSession session){
		session.removeAttribute("user");
		session.invalidate();
		return "success";
	}

	@GetMapping("/getRealName.action")
	@ResponseBody
	public List<User> getRealName(){
		return userservicr.getDocRealName(3);
	}
}
