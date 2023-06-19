package com.example.winwin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// 이 인터페이스를 등록하고 Mapper를 사용하기 위한 어노테이션이다.
@Mapper
public interface TimeMapper {
//    Mapper.xml의 쿼리 id와 일치하는 메소드 이름을 사용하면 알아서 Mapping된다.
    String getTime();

//    권장하지 않음
    @Select("SELECT SYSDATE FROM DUAL")
    String getTime2();
}
