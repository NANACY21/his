package com.personal.pojo;

import java.util.Date;

public class Register {
    private Integer id;

    private String casenumber;

    private String realname;

    private Integer gender;

    private String idnumber;

    private Date birthdate;

    private Integer age;

    private String agetype;

    private String homeaddress;

    private Date visitdate;

    private String noon;

    //private Integer deptid;
    private Department dept;

    private Integer userid;

   // private Integer registleid;
    private RegistLevel registLevel;
    private Integer settleid;

    private String isbook;

    private Date registtime;

    private Integer registerid;

    private Integer visitstate;
    private ConstantItem constantitem;

    public ConstantItem getConstantitem() {
        return constantitem;
    }

    public void setConstantitem(ConstantItem constantitem) {
        this.constantitem = constantitem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber == null ? null : casenumber.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAgetype() {
        return agetype;
    }

    public void setAgetype(String agetype) {
        this.agetype = agetype == null ? null : agetype.trim();
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress == null ? null : homeaddress.trim();
    }

    public Date getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(Date visitdate) {
        this.visitdate = visitdate;
    }

    public String getNoon() {
        return noon;
    }

    public void setNoon(String noon) {
        this.noon = noon == null ? null : noon.trim();
    }

   /* public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }*/

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

   /* public Integer getRegistleid() {
        return registleid;
    }

    public void setRegistleid(Integer registleid) {
        this.registleid = registleid;
    }*/

    public Integer getSettleid() {
        return settleid;
    }

    public void setSettleid(Integer settleid) {
        this.settleid = settleid;
    }

    public String getIsbook() {
        return isbook;
    }

    public void setIsbook(String isbook) {
        this.isbook = isbook == null ? null : isbook.trim();
    }

    public Date getRegisttime() {
        return registtime;
    }

    public void setRegisttime(Date registtime) {
        this.registtime = registtime;
    }

    public Integer getRegisterid() {
        return registerid;
    }

    public void setRegisterid(Integer registerid) {
        this.registerid = registerid;
    }

    public Integer getVisitstate() {
        return visitstate;
    }

    public void setVisitstate(Integer visitstate) {
        this.visitstate = visitstate;
    }

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public RegistLevel getRegistLevel() {
		return registLevel;
	}

	public void setRegistLevel(RegistLevel registLevel) {
		this.registLevel = registLevel;
	}

	
}