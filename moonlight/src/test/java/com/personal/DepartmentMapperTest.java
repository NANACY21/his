package com.personal;

import java.util.List;

import com.personal.mapper.DepartmentMapper;
import com.personal.pojo.ConstantItem;
import com.personal.pojo.Department;
import com.personal.utils.PageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-dao.xml"})
public class DepartmentMapperTest {


    @Autowired
    private DepartmentMapper deptMapper;

    @Test
    public void test1(){
        Department dept = new Department();
        dept.setDeptcode("qqqq");
        dept.setDeptname("q部门");
        dept.setDepttype(1);
        ConstantItem item = new ConstantItem();
        item.setId(14);
        dept.setConstantItem(item);
        deptMapper.insertDepartment(dept);
    }

    @Test
    public void test2(){
        Department dept = new Department();
        dept.setId(139);
        dept.setDeptcode("qqqq2");
        dept.setDeptname("q部门1");
        dept.setDepttype(2);
        ConstantItem item = new ConstantItem();
        item.setId(17);
        dept.setConstantItem(item);
        deptMapper.updateDepartment(dept);
    }

    @Test
    public void testSelectDepartmentById(){
        Department dept = deptMapper.selectDepartmentById(3);
        System.out.println(dept);
    }



    @Test
    public void test3(){
        PageBean<Department> pageBean = new PageBean<>();
        pageBean.setPageSize(10);
        pageBean.setOffset(10);

        List<Department> depts = deptMapper.selectAllDepartmentsPages(pageBean);
        System.out.println(depts.size());
        for(Department dept :depts){
            System.out.println(dept);
        }
    }

}
