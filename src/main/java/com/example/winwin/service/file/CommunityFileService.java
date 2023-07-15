package com.example.winwin.service.file;

import com.example.winwin.dto.file.CommunityFileDto;
import com.example.winwin.mapper.file.CommunityFile;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CommunityFileService {
    private final CommunityFile communityFile;

    @Value("${file.dir}")
    private String fileDir;

    public void register(CommunityFileDto communityFileDto){
        if(communityFileDto == null) {
            throw new IllegalArgumentException("파일 정보 누락");
        }
        communityFile.insert(communityFileDto);
    }

    public void remove(Long communityNumber){
        if(communityNumber == null){
            throw new IllegalArgumentException("게시물 번호 누락");
        }

        List<CommunityFileDto> fileList = findList(communityNumber);

        for (CommunityFileDto file : fileList){
            File target = new File(fileDir, file.getFileUploadPath() + "/" + file.getFileUuid() + "_" + file.getFileSystemName());
            File thumbnail = new File(fileDir, file.getFileUploadPath() + "/th_" + file.getFileUuid() + "_" + file.getFileSystemName());

            if(target.exists()){
                target.delete();
            }

            if(thumbnail.exists()){
                thumbnail.delete();
            }
        }
        communityFile.delete(communityNumber);
    }

    public List<CommunityFileDto> findList(Long communityNumber){
        if (communityNumber == null){
            throw new IllegalArgumentException("게시물 번호 누락!");
        }
        return communityFile.selectList(communityNumber);
    }

    public CommunityFileDto saveFile(MultipartFile file) throws IOException {
        String originName = file.getOriginalFilename();
        originName = originName.replaceAll("\\s+", "");
        UUID uuid = UUID.randomUUID();
        String sysName = uuid.toString() + "_" + originName;
        File uploadPath = new File(fileDir, getUploadPath());
        if (!uploadPath.exists()){
            uploadPath.mkdirs();
        }
        File uploadFile = new File(uploadPath, sysName);
        file.transferTo(uploadFile);

        if(Files.probeContentType(uploadFile.toPath()).startsWith("image")){
            FileOutputStream out = new FileOutputStream(new File(uploadPath, "th_" + sysName));
            Thumbnailator.createThumbnail(file.getInputStream(), out, 200, 200);
            out.close();
        }

        CommunityFileDto communityFileDto = new CommunityFileDto();
        communityFileDto.setFileSystemName(originName);
        communityFileDto.setFileUuid(uuid.toString());
        communityFileDto.setFileUploadPath(getUploadPath());

        return communityFileDto;
    }

    public void registerAndSaveFiles(List<MultipartFile> files, Long communityNumber) throws IOException{
        for (MultipartFile file : files){
            if(!"".equals(file.getOriginalFilename())){
                CommunityFileDto communityFileDto = saveFile(file);
                communityFileDto.setCommunityNumber(communityNumber);
                register(communityFileDto);
            }

        }
    }

    private String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    public List<CommunityFileDto> findOldList(){
        return communityFile.selectOldList();
    }
}
