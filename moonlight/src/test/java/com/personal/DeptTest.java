package com.personal;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.personal.mapper.*;
import com.personal.pojo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-dao.xml"})
public class DeptTest {
	@Autowired
	private DepartmentMapper dm;
	@Autowired
	private UserMapper um;

	@Autowired
	private RuleMapper rm;

	@Autowired
	private InvoiceMapper im;

	@Autowired
	private SettlecategoryMapper settlecategoryMapper;

	@Autowired
	private SchedulingMapper sm;
	@Test
	public void test0001(){
		List<Department> depts  = dm.selectAllDepartments();
		for(Department dept:depts){
			System.out.println(dept.getDeptname());
		}
	}
	@Test
	public void test0002(){
		List<Department> depts  = dm.getDeptByNameOrNo("");
		for(Department dept:depts){
			System.out.println(dept.getDeptname());
		}
	}
	@Test
	public void test1() {
		List<Department> depts = dm.selectAllDepartments();

		for (Department dd : depts) {
			System.out.println(dd.getDeptname() + ":::" + dd.getConstantItem().getConstantname());
		}

	}

	@Test
	public void test2() {
		Department dept = dm.selectDepartmentById(13);
		System.out.println(dept);
	}

	@Test
	public void test3() {
		List<Department> depts = dm.selectDeptTypes();
		for (Department dd : depts) {
			System.out.println(dd);
		}
	}

	@Test
	public void test4() {
		RegistLevel reg = new RegistLevel();
		reg.setRegistname("专家号");
		Department dep = new Department();
		dep.setDeptname("心血管内科");
		User user = new User(dep, reg);

		List<User> users = um.selectDoctors(user);

		for (User uu : users) {
			System.out.println(uu);
		}

	}

	@Test
	public void test5() {
		List<Department> depts = dm.mohusel("心血管内科");
		for(Department dd:depts){
			System.out.println(dd);
		}

	}
	@Test
	public void test6() {
		Rule rule = new Rule();
		rule.setRulename("askjfaldskfjaf");
		rule.setDeptid(2);
		rule.setUserid(3);
		rule.setWeek("54766856");
		rm.insert(rule);

	}
	@Test
	public void test7() {
		User user = new User();
		user.setUsetype(2);
		user.setUsername("ghy");
		user.setPassword("ghy123");
		User user1 = um.selectUser(user);
		System.out.println(user1);
	}

	@Test
	public void test8() {
		int inv = im.selectMaxID();
		System.out.println(inv);

	}

	@Test
	public void test9() {
		List<Settlecategory> sett = settlecategoryMapper.selectName();
		for(Settlecategory see:sett){
			System.out.println(see.getId()+"::"+see.getSettlename());
		}
	}

	@Test
	public void test10() {
		List<User> names = um.selectRealName(3);
		for(User nn:names){
			System.out.println(nn.getId()+"::"+nn.getRealname());
		}

	}

	@Test
	public void test11() throws ParseException {
		Scheduling sch = new Scheduling();
		Date dd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dd = sdf.parse("2019-04-01");
		sch.setScheddate(dd);
		sch.setNoon("上午");

		List<Department> depts = sm.selectDeptIds(sch);
		for(Department dept:depts){
			System.out.println(dept.getId()+"::"+dept.getDeptname());
		}
	}

	@Test
	public void test12() {
		List<Department> depts = dm.selectDeptNames();
		for(Department dd:depts){
			System.out.println(dd.getId()+"::"+dd.getDeptname());
		}
	}
}
