package com.personal.service;

import com.personal.pojo.Department;
import com.personal.pojo.Scheduling;

import java.util.List;
public interface SchedulingService {
	public List<Scheduling> getDeptId(Scheduling sch);
	List<Department> getDeptIds(Scheduling sch);
}
