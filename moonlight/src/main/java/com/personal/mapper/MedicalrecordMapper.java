package com.personal.mapper;


import com.personal.pojo.Medicalrecord;

/**
 * ok
 */
public interface MedicalrecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Medicalrecord record);

    int insertSelective(Medicalrecord record);

    Medicalrecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Medicalrecord record);

    int updateByPrimaryKey(Medicalrecord record);
}