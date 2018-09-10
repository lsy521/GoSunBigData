package com.hzgc.service.people.dao;

import com.hzgc.service.people.model.Picture;
import com.hzgc.service.people.model.PictureWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PictureMapper {

    int insert(PictureWithBLOBs record);

    int insertSelective(PictureWithBLOBs record);

    PictureWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PictureWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PictureWithBLOBs record);

    int updateByPrimaryKey(Picture record);
}