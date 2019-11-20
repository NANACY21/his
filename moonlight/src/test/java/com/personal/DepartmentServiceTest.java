package com.personal;

import java.util.List;

import com.personal.pojo.Department;
import com.personal.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-dao.xml","classpath:applicationContext-transaction.xml"})

public class DepartmentServiceTest {


    @Autowired
    private DepartmentService departmentService;


    @Test
    public void testSearchDepartments(){
        Department dept = new Department();
        dept.setDeptcode("XDTK");
        dept.setDepttype(2);
        List<Department> depts = departmentService.getDepartmentByMessage(dept);
        for(Department d:depts){
            System.out.println(d);
        }
    }
}
