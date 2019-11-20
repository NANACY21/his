package com.personal.web.controller;

import java.util.List;

import com.personal.pojo.Department;
import com.personal.service.DepartmentService;
import com.personal.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	@GetMapping("depts.action")
	@ResponseBody
	public List<Department> listDepts() {
		return departmentService.listDepts();
	}

	@GetMapping("/listpages.action")
	@ResponseBody
	public PageBean<Department> listdepts(int page, int pageSize) {
		int count = departmentService.getDeptCount();
		PageBean<Department> pageBean = new PageBean<>();
		pageBean.setPageSize(pageSize);
		pageBean.setOffset(page * pageSize);
		List<Department> depts = departmentService.listdeptpages(pageBean);
		pageBean.setCount(count);
		pageBean.setContents(depts);
		return pageBean;
	}

	@GetMapping("/list.action")
	@ResponseBody
	public List<Department> list(){
		return departmentService.listDepts();
	}
	@GetMapping("/sel.action")
	@ResponseBody
	public List<Department> selDept(String flag){
		return departmentService.getDeptByNameOrNo(flag);
	}

	@RequestMapping("/adddept.action")
	@PostMapping("/adddept.action")
//	@PostMapping("add.action")
	@ResponseBody
	public String adddept(Department department) {
		int result = departmentService.saveDepartment(department);
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	@RequestMapping("/deldept.action")
	@GetMapping("/del.action")
	@PostMapping("delete.action")
	@ResponseBody
	public String deldept(int id) {
		int result = departmentService.removeDepartment(id);
//		departmentService.delDepartmentById(id);
		if (result ==1) {
			return "success";
		} else {
			return "fail";
		}
	}
	@GetMapping("deletes.action")
	@ResponseBody
	public String delDepts(String id) {

		String[] ids = id.split(",");
		int[] idds = new int[ids.length];
		for(int a = 0;a<ids.length;a++){
			idds[a] = Integer.parseInt(ids[a]);
		}
		departmentService.delMultiDepts(idds);
		return "1";

	}
	@RequestMapping("/updept.action")
	public String updept(Department department) {
		int result = departmentService.megerDepartment(department);
		if (result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	@RequestMapping("/editdept.action")
	public Department editdept(int id) {
		Department dept = departmentService.getDepartment(id);
		return dept;
	}

	@RequestMapping("/getall.action")
	public List<Department> getall() {
		return departmentService.getDepartments();
	}
	
	@RequestMapping("/searchdept.action")
	public List<Department> searchdept(Department department){
		return departmentService.getDepartmentByMessage(department);
	}
	
	@RequestMapping("/getallpages.action")
	public PageBean<Department> getallpages(int pageSize, int page) {
		int count = departmentService.getDepartmentsCount();
		PageBean<Department> pageBean = new PageBean<>();
		pageBean.setPageSize(pageSize);
		pageBean.setOffset(page * pageSize);
		List<Department> depts = departmentService.getDepartmentsByPages(pageBean);
		pageBean.setCount(count);
		pageBean.setContents(depts);
		return pageBean;
	}
	@GetMapping("selone.action")
	@ResponseBody
	public Department getDepartment(int id) {
		return departmentService.editDepartmentById(id);
	}
	@GetMapping("seldeptid.action")
	@ResponseBody
	public List<Department> getDepartmentids() {
		return departmentService.listDeptCategoryID();
	}
	@PostMapping("/getDeptById.action")
	@ResponseBody
	public Department getDeptById(int id){
		return departmentService.getDeptById(id);

	}

	@ResponseBody
	@RequestMapping("/updatedept.action")
	//@PostMapping("/updatedept.action")
//	@PostMapping("/update.action")
	public String updatedept(@RequestBody Department dept) {

		System.out.println(dept);
		int i = departmentService.updateDepartment(dept);
		System.out.println(i);
		if (i > 0) {
			return "success";
		} else {
			return "error";
		}
	}
	@GetMapping("selDeptByNameorCode.action")
	@ResponseBody
	public List<Department> getDepartmentByCodeName(String flag) {
		//System.out.println(flag);
		List<Department> depts= departmentService.getDeptByNameOrNo(flag);

		return depts;

	}

	@GetMapping("/getdeptsnames.action")
	@ResponseBody
	public List<Department> getDeptsNames(){
		return departmentService.getDeptNames();
	}
}
