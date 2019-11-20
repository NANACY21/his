package com.personal.service;

import com.personal.pojo.Department;
import com.personal.utils.PageBean;

import java.util.List;



public interface DepartmentService {
	// 查询所有
	public List<Department> listDepts();

	// 搜索框查找
	public List<Department> getDeptByNameOrNo(String flag);

	//添加
	public int saveDepartment(Department department);

	// 删除
	public int delDepartmentById(int id);

	// 批量删除
	public boolean delMultiDepts(int[] ids);

	// 编辑
	public Department editDepartmentById(int id);
	public List<Department> listDeptCategoryID();

	public List<Department> getDeptNames();

	//分页
	public List<Department> listdeptpages(PageBean<Department> pageBean);
	public int getDeptCount();
	public int updateDepartment(Department dept);
	public int removeDepartment(int id);
	public int megerDepartment(Department department);
	public Department getDepartment(int id);
	public List<Department> getDepartments();
	public int removeMultiDepartments(Integer[] ids);
	public List<Department>  getDepartmentByMessage(Department department);
	
	public List<Department> getDepartmentsByPages(PageBean<Department> pageBean);
	
	public int getDepartmentsCount();
	Department getDeptById(int id);
}
