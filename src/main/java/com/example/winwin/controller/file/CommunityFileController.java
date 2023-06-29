package com.example.winwin.controller.file;

import com.example.winwin.dto.file.CommunityFileDto;
import com.example.winwin.service.file.CommunityFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files/*")
public class CommunityFileController {
    private final CommunityFileService communityFileService;

    @Value("${file.dir}")
    private String fileDir;

    @GetMapping("/imgList")
    public List<CommunityFileDto> imgList(Long communityNumber){
        return communityFileService.findList(communityNumber);
    }

    @GetMapping("/display")
    public byte[] display(String fileSystemName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileDir, fileSystemName));
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(String fileSystemName) throws UnsupportedEncodingException {

        Resource resource = new FileSystemResource(fileDir + fileSystemName);
        HttpHeaders headers = new HttpHeaders();

        String name = resource.getFilename();
        name = name.substring(name.indexOf('_')+1);

        headers.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name, "UTF-8"));

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
