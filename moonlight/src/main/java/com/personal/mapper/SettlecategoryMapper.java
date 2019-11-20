package com.personal.mapper;

import com.personal.pojo.Settlecategory;

import java.util.List;

public interface SettlecategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Settlecategory record);

    int insertSelective(Settlecategory record);

    Settlecategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Settlecategory record);

    int updateByPrimaryKey(Settlecategory record);
    List<Settlecategory> getSettlecategory();
    List<Settlecategory> selectName();
}