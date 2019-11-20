package com.personal.web.controller;

import com.personal.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	@ResponseBody
	@RequestMapping("/getInvoiceNum.action")
	public String getInvoiceNum(){
	//	System.out.println( invoiceService.getMaxInNum());
		return invoiceService.getMaxInNum();
	}
	@GetMapping("getInvoiceId.action")
	@ResponseBody
	public int getInvoiceId(){
		return invoiceService.getID();
	}
}
