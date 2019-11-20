package com.personal.service.impl;

import com.personal.mapper.DepartmentMapper;
import com.personal.pojo.Department;
import com.personal.service.DepartmentService;
import com.personal.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper dm;

	@Override
	public List<Department> listDepts() {
		return dm.selectAllDepartments();
	}

	@Override
	public List<Department> getDeptByNameOrNo(String flag) {
		return dm.mohusel(flag);
//		return dm.getDeptByNameOrNo(flag);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return dm.insertDepartment(department);
	}

	@Override
	public int delDepartmentById(int id) {
		return dm.deleteDepartmentById(id);
	}

	@Override
	public boolean delMultiDepts(int[] ids) {
		try {
			for (int id : ids) {
				delDepartmentById(id);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Department editDepartmentById(int id) {
		return dm.selectDepartmentById(id);
	}

	@Override
	public List<Department> listDeptCategoryID() {
		return dm.selectDeptCategoryID();
	}

	@Override
	public List<Department> getDeptNames() {
		return dm.selectDeptNames();
	}

	@Override
	public List<Department> listdeptpages(PageBean<Department> pageBean) {
		return dm.selectAllDepartmentsPages(pageBean);
	}

	@Override
	public int getDeptCount() {
		return dm.getTotal();
	}

	@Override
	public int updateDepartment(Department dept) {
		return dm.updateDepartment(dept);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int removeDepartment(int id) {
		// TODO Auto-generated method stub
		return dm.deleteDepartmentById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int megerDepartment(Department department) {
		// TODO Auto-generated method stub
		return dm.updateDepartment(department);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Department getDepartment(int id) {
		// TODO Auto-generated method stub
		return dm.selectDepartmentById(id);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return dm.selectAllDepartments();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int removeMultiDepartments(Integer[] ids) {
		int result = 0;
		for (Integer id : ids) {
			result += this.removeDepartment(id);
		}
		return result;
	}

	@Override
	public List<Department> getDepartmentByMessage(Department department) {
		return dm.selectDepartmentByMessage(department);
	}

	@Override
	public List<Department> getDepartmentsByPages(PageBean<Department> pageBean) {

		return dm.selectAllDepartmentsPages(pageBean);
	}

	@Override
	public int getDepartmentsCount() {
		return dm.getCount();
	}

	@Override
	public Department getDeptById(int id) {
		return dm.selectDepartmentById(id);
	}

}