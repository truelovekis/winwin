package com.example.winwin.mapper.myPage;

import com.example.winwin.dto.user.ResumeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResumeMapper {
    public Long insertResume(ResumeDto resumeDto);
    public List<ResumeDto> selectResumeList(Long userNumber);
    public ResumeDto selectResume(Long userNumber);
    public String selectPhone(Long userNumber);
}
