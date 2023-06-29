package com.example.winwin.mapper.mentor;

import com.example.winwin.dto.mentor.CategoryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    public List<CategoryVo> categoryH();
    public List<CategoryVo> categoryJ();

    public List<CategoryVo> subCategory(String mainCode);

}
