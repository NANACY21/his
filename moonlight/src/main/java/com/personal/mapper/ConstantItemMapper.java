package com.personal.mapper;


import com.personal.pojo.ConstantItem;

import java.util.List;

public interface ConstantItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstantItem record);

    int insertSelective(ConstantItem record);

    ConstantItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConstantItem record);

    int updateByPrimaryKey(ConstantItem record);
    List<ConstantItem> selectConstantName(Integer id);
}