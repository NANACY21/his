package com.personal.mapper;


import com.personal.pojo.Department;
import com.personal.utils.PageBean;

import java.util.List;

public interface DepartmentMapper {
   
	int deleteDepartmentById(int id);
	int insertDepartment(Department department);
	int insertSelective(Department record);
	int updateDepartment(Department department);

	int updateByPrimaryKeySelective(Department record);
	int getTotal();
	Department selectDepartmentById(int id);
	List<Department> selectDepartmentByMessage(Department department);
	List<Department> selectAllDepartments();
	List<Department> selectAllDepartmentsPages(PageBean<Department> pageBean);
	int getCount();
	List<Department> getDeptByNameOrNo(String  flag);
	public List<Department> selectDeptTypes();

	public List<Department> selectDeptCategoryID();

	public List<Department> mohusel(String flag);


	public List<Department> selectDeptNames();
}