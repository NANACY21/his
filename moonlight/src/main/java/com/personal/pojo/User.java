package com.personal.pojo;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String realname;

    private Integer usetype;

    private Integer doctitleid;

    private ConstantItem constantItem;

    private String isscheduling;

    private Integer deptid;
    private Department department;
    private Integer registleid;
    private RegistLevel registLevel;

    public User(Department department, RegistLevel registLevel) {
        this.department = department;
        this.registLevel = registLevel;
    }

    public User() {
    }

    private Integer delmark;

    public ConstantItem getConstantItem() {
		return constantItem;
	}

	public void setConstantItem(ConstantItem constantItem) {
		this.constantItem = constantItem;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public RegistLevel getRegistLevel() {
		return registLevel;
	}

	public void setRegistLevel(RegistLevel registLevel) {
		this.registLevel = registLevel;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getUsetype() {
        return usetype;
    }

    public void setUsetype(Integer usetype) {
        this.usetype = usetype;
    }

   
    public String getIsscheduling() {
        return isscheduling;
    }

    public void setIsscheduling(String isscheduling) {
        this.isscheduling = isscheduling == null ? null : isscheduling.trim();
    }


    public Integer getDoctitleid() {
        return doctitleid;
    }

    public void setDoctitleid(Integer doctitleid) {
        this.doctitleid = doctitleid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getRegistleid() {
        return registleid;
    }

    public void setRegistleid(Integer registleid) {
        this.registleid = registleid;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}