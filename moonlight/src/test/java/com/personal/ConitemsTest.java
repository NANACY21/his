package com.personal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.personal.mapper.ConstantItemMapper;
import com.personal.mapper.MedicalrecordMapper;
import com.personal.mapper.RegisterMapper;
import com.personal.pojo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-dao.xml" })
public class ConitemsTest {
	@Autowired
	private ConstantItemMapper cm;
	@Autowired
	private RegisterMapper regmapper;
	@Autowired
	private MedicalrecordMapper mm;
	

	@Test
	public void test1() {
		List<ConstantItem> names = cm.selectConstantName(1);
		for (ConstantItem nn : names) {
			System.out.println(nn);
		}
	}
	
	@Test
	public void test2() throws ParseException {
		Register reg = new Register();
		Date dd = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dd = sdf.parse("2019-04-01");
		reg.setVisitdate(dd);
		reg.setNoon("上午");
		Department dept = new Department();
		dept.setId(1);
		reg.setDept(dept);
		RegistLevel regl = new RegistLevel();
		regl.setId(2);
		reg.setRegistLevel(regl);
		
		List<User> users = regmapper.selectUserIds(reg);
		for(User uu:users){
			System.out.println(uu.getId()+"::"+uu.getRealname());
		}
		
	}
	
	@Test
	public void test3() {
		Register reg = new Register();
		reg.setVisitstate(1);
		reg.setUserid(1);
		List<Register> regs = regmapper.selectRealName(reg);
		for(Register rr:regs){
			System.out.println(rr.getCasenumber()+"-"+rr.getRealname()+"-"+rr.getAge());
		}
		
	}
	
	@Test
	public void test4() {
		Register r1 = new Register();
		r1.setCasenumber("600600");
		Register r = regmapper.selectOne(r1);
		System.out.println(r);
		System.out.println(r.getConstantitem().getConstantname());
	}
	
	@Test
	public void test5() {
		Medicalrecord mr = new Medicalrecord();
		mr.setCasenumber("600619");
		mr.setRegistid(38);
		mm.insertSelective(mr);
	}
	
	@Test
	public void test6() {
		Register reg = new Register();
		reg.setVisitstate(2);
		reg.setId(37);
		int reult = regmapper.updateVisitState(reg);
		System.out.println(reult);
	}
	
	@Test
	public void test7() throws ParseException {
		Register reg = new Register();
		reg.setCasenumber("800814");
		reg.setRealname("laoxian");
		reg.setGender(72);
		reg.setIdnumber("230644685748");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = sdf.parse("2019-07-11");
		reg.setBirthdate(dd);
		reg.setAge(25);
		reg.setAgetype("岁");
		reg.setHomeaddress("haerbin");
		Date ee = sdf.parse("2015-04-15");
		reg.setVisitdate(ee);
		reg.setNoon("上午");
		Department dept = new Department();
		dept.setId(1);
		reg.setDept(dept);
		reg.setUserid(1);
		RegistLevel regl = new RegistLevel();
		regl.setId(1);
		reg.setRegistLevel(regl);
		reg.setSettleid(2);
		int aa = regmapper.insertRegister(reg);
		System.out.println(aa);
		
	}
}
