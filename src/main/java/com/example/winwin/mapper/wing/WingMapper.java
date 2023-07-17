package com.example.winwin.mapper.wing;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WingMapper {
    public void insertWingLog(@Param("wingAmount")int wingAmount, @Param("userNumber")Long userNumber);
}
