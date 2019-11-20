package com.personal.service.impl;

import java.util.List;

import com.personal.mapper.SchedulingMapper;
import com.personal.pojo.Department;
import com.personal.pojo.Scheduling;
import com.personal.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SchedulingServiceImpl  implements SchedulingService {
	@Autowired
	private SchedulingMapper schmapper;
	@Override
	public List<Scheduling> getDeptId(Scheduling sch) {
		return schmapper.getDeptID(sch) ;
	}

	@Override
	public List<Department> getDeptIds(Scheduling sch) {
		return schmapper.selectDeptIds(sch);
	}
}
