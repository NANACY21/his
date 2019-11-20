package com.personal.mapper;

import com.personal.pojo.RegistLevel;

import java.util.List;

public interface RegistLevelMapper {
    List<RegistLevel> selectAllRegistLevels();
    int deleteByPrimaryKey(Integer id);

    int insert(RegistLevel record);

    int insertSelective(RegistLevel record);

    RegistLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RegistLevel record);

    int updateByPrimaryKey(RegistLevel record);
    public List<RegistLevel> queryLevels();
}