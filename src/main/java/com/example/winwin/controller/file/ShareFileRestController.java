package com.example.winwin.controller.file;

import com.example.winwin.dto.file.ShareFileDto;
import com.example.winwin.service.file.ShareFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sharefiles/*")
public class ShareFileRestController {

    private final ShareFileService shareFileService;

    @Value("${file.dir}")
    private String fileDir;

    //    나눔 페이지 리스트에 파일 업로드한 이미지 띄어주기
    @GetMapping("/imgList")
    public List<ShareFileDto> imgList(Long shareNumber){
        return shareFileService.shareFileFindList(shareNumber);
    }

    //    서버 컴퓨터에 저장된 파일 복사해서 넘겨주는 핸들러
    @GetMapping("/display")
    public byte[] display(String fileSystemName)throws IOException {
        System.out.println("=============================");
        System.out.println(fileSystemName);
        System.out.println("=============================");

        return FileCopyUtils.copyToByteArray(new File(fileDir, fileSystemName));
    }
}
