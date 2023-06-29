package com.example.winwin.service.mentor;

import com.example.winwin.dto.mentor.CategoryVo;
import com.example.winwin.mapper.mentor.CategoryMapper;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public List<CategoryVo> findCategoryJ(){
        List<CategoryVo> categoryJ = categoryMapper.categoryJ();

        for (int i=0; i<categoryJ.size(); i++){
            categoryJ.get(i).getMainCode();
            categoryJ.get(i).getMainName();
        }

        return categoryJ;
    }

    public List<CategoryVo> findCategoryH(){
        List<CategoryVo> categoryH = categoryMapper.categoryH();

        for (int i=0; i<categoryH.size(); i++){
            categoryH.get(i).getSubNumber();
            categoryH.get(i).getSubName();
        }

        return categoryH;
    }

    public List<CategoryVo> findSubCategory(String maindCode){
        List<CategoryVo> subCategory = categoryMapper.subCategory(maindCode);
        return subCategory;
    }
}
