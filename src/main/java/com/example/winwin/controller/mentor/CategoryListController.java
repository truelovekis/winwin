package com.example.winwin.controller.mentor;

import com.example.winwin.dto.mentor.CategoryVo;
import com.example.winwin.service.mentor.CategoryService;
import com.example.winwin.service.mentor.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category/*")
public class CategoryListController {
    private final MentorService mentorService;
    private final CategoryService categoryService;

    @GetMapping("/categoryJ")
    public List<CategoryVo> findCategoryJ(String mainCode){

        return categoryService.findCategoryJ();
    }

    @GetMapping("/categoryH")
    public List<CategoryVo> findCategoryH(){
        return categoryService.findCategoryH();
    }

    @GetMapping("/subCategory")
    public List<CategoryVo> findSub(String mainCode){
        return categoryService.findSubCategory(mainCode);
    }
}
