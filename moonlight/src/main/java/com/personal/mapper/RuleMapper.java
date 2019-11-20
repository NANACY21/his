package com.personal.mapper;

import com.personal.pojo.Rule;

public interface RuleMapper {
    public int insertRule(Rule rule);
    int deleteByPrimaryKey(Integer id);

    int insert(Rule record);

    int insertSelective(Rule record);

    Rule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rule record);

    int updateByPrimaryKey(Rule record);

//    public String insertRule(Rule rule);
}