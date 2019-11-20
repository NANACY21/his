package com.personal.mapper;

import com.personal.pojo.Department;
import com.personal.pojo.Scheduling;

import java.util.Date;
import java.util.List;



public interface SchedulingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Scheduling record);

    int insertSelective(Scheduling record);

    Scheduling selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Scheduling record);

    int updateByPrimaryKey(Scheduling record);

    List<Scheduling> getDeptID(Scheduling record);
    List<Department> selectDeptIds(Scheduling sch);
}