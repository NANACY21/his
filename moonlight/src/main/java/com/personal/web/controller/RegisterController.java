package com.personal.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.personal.mapper.RegistLevelMapper;
import com.personal.mapper.SettlecategoryMapper;
import com.personal.pojo.Register;
import com.personal.pojo.User;
import com.personal.service.RegisterService;
import com.personal.utils.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	@Autowired
	private RegistLevelMapper remapper;
	@Autowired
	private SettlecategoryMapper Setmapper ;
	
	@ResponseBody
	@RequestMapping("/getMaxReNum.action")
	public String getMaxReNum(){
		return registerService.getMaxReNum();
	}

	/*@ResponseBody
	@RequestMapping("/getRegistlevel.action")
	public List<Registlevel> getRegistlevel(){
		//System.out.println(remapper.getRegistlevel());
		return remapper.getRegistlevel();
	}*/
	@RequestMapping("/getUser.action")
	@ResponseBody
	public List<User> getUser(Register register) {

		List<User> ls = registerService.getDoctors(register);
		System.out.println(register.getNoon() + "===============================");
		return ls;
	}

	@ResponseBody
	@GetMapping("/getRegisterCaseNum.action")
	public int getRegisterCaseNum(){
		return registerService.getCaseNum();
	}

	@ResponseBody
	@PostMapping("/getAge.action")
	public int getAge(String birth) throws Exception{
		Date days = DateFormatUtils.parse(birth);
		int age = DateFormatUtils.getAges(days);
		return age;
	}

	@ResponseBody
	@PostMapping("/getUsers.action")
	public List<User> getUsers(Register reg){
		System.out.println(reg.getNoon());
		return registerService.getUserIds(reg);
	}

	@ResponseBody
	@GetMapping("/getRegisterRealnames.action")
	public List<Register> getRegisterRealnames(Register reg,String uid){
		reg.setVisitstate(1);
		reg.setUserid(Integer.parseInt(uid));
		return registerService.getRealNames(reg);
	}

	@ResponseBody
	@GetMapping("/getRegisterRealnameds.action")
	public List<Register> getRegisterRealnameds(Register reg,String uid){
		reg.setVisitstate(3);
		reg.setUserid(Integer.parseInt(uid));
		return registerService.getRealNames(reg);
	}

	@ResponseBody
	@GetMapping("/getDeptRegisters.action")
	public List<Register> getDeptRegisters(Register reg,String deptid){
		reg.setVisitstate(1);
		reg.setUserid(Integer.parseInt(deptid));
		return registerService.getRealNames(reg);
	}
	@ResponseBody
	@GetMapping("/getDeptRegisterds.action")
	public List<Register> getDeptRegisterds(Register reg,String deptid){
		reg.setVisitstate(3);
		reg.setUserid(Integer.parseInt(deptid));
		return registerService.getRealNames(reg);
	}

	@ResponseBody
	@GetMapping("/getRegister.action")
	public Register getRegister(Register reg,String casenumber){
		System.out.println(casenumber);
		reg.setCasenumber(casenumber);
		Register regg = registerService.getOne(reg);
		//System.out.println(regg.getConstantitem().getConstantname());
		return regg;
	}

	@ResponseBody
	@PostMapping("/saveVisitstate.action")
	public int saveVisitstate(Register reg,int regid){
		reg.setId(regid);
		int result = registerService.editVisitState(reg);
		return result;
	}

	@ResponseBody
	@PostMapping("/saveRegister.action")
	public int saveRegister(Register reg){
		return registerService.addRegister(reg);
	}
}
