package com.personal.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.personal.pojo.Department;
import com.personal.pojo.Scheduling;
import com.personal.pojo.User;
import com.personal.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/scheduling")
public class SchedulingController {
	@Autowired
	private SchedulingService schse;

	@RequestMapping("/getUser.action")
	@ResponseBody
	public List<Scheduling> getUser(String scheddate, String noon, int deptid, int registleid) throws ParseException {

		Scheduling sch = new Scheduling();
		User user = new User();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date scdate = sdf.parse(scheddate);
		sch.setScheddate(scdate);
		sch.setNoon(noon);
		sch.setDeptid(deptid);
		user.setRegistleid(registleid);
		sch.setUser(user);
		System.out.println("========================" + sch.getNoon());
		return schse.getDeptId(sch);
	}

	@ResponseBody
	@GetMapping("/getDeptNames.action")
	public List<Department> getDeptNames(String day, String noon) throws ParseException{
		Scheduling sch = new Scheduling();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = sdf.parse(day);
		sch.setScheddate(dd);
		sch.setNoon(noon);
		return schse.getDeptIds(sch);
	}
}
