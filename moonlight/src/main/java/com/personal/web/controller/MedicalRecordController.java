package com.personal.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.personal.pojo.Medicalrecord;
import com.personal.pojo.Register;
import com.personal.service.MedicalrecordService;
import com.personal.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/record")
//@RequestMapping("/medicalrecord")
public class MedicalRecordController {
	@Autowired
	private RegisterService registerService;
	@Autowired
	private MedicalrecordService ms;
	@PostMapping("/listregist.action")
	@ResponseBody
	public List<Register> listregist(Register register){
		 List<Register> ls= registerService.getRegister(register);
		return ls;
	}
	@PostMapping("/getRegister.action")
	@ResponseBody
	public Register getRegister(String casenumber){
		System.out.println(casenumber);
		return registerService.getRegisterById(casenumber);
	}
	@PostMapping("/addMedicalrecords.action")
	@ResponseBody
	public int addMedicalrecords(Medicalrecord medicalrecord){
		return ms.addSelective(medicalrecord);
	}
}
