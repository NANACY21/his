package com.personal.pojo;

import java.util.Date;
import java.util.List;

public class Scheduling {
    private Integer id;

    private Date scheddate;

    private Integer deptid;
    private Department dapt;
    private Integer userid;
    private User user;
    private String noon;

    private Integer ruleid;

    private Integer delmark;
    private List<Department> depts;
    public List<Department> getDepts() {
        return depts;
    }

    public void setDepts(List<Department> depts) {
        this.depts = depts;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getScheddate() {
        return scheddate;
    }

    public void setScheddate(Date scheddate) {
        this.scheddate = scheddate;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getNoon() {
        return noon;
    }

    public void setNoon(String noon) {
        this.noon = noon == null ? null : noon.trim();
    }

    public Integer getRuleid() {
        return ruleid;
    }

    public void setRuleid(Integer ruleid) {
        this.ruleid = ruleid;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }

	public Department getDapt() {
		return dapt;
	}

	public void setDapt(Department dapt) {
		this.dapt = dapt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
}