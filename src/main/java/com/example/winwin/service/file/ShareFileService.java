package com.example.winwin.service.file;

import com.example.winwin.dto.file.ShareFileDto;
import com.example.winwin.mapper.file.ShareFileMapper;
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
public class ShareFileService {

    private final ShareFileMapper shareFileMapper;
    @Value("${file.dir}")
    private String fileDir;

//    나눔 파일 등록하기
    public void shareFileRegister(ShareFileDto shareFileDto){
        if(shareFileDto == null){
            throw new IllegalArgumentException("파일 정보가 누락되었습니다.");
        }

        shareFileMapper.shareFileInsert(shareFileDto);
    }

//    파일 DB등록 및 파일 저장처리
    public void registerAndSaveFiles(List<MultipartFile> files, Long shareNumber) throws IOException{
        for(MultipartFile file : files){
            System.out.println("====================================================");
            System.out.println(file);
            System.out.println("====================================================");

            ShareFileDto shareFileDto = saveShareFile(file);
            shareFileDto.setShareNumber(shareNumber);
            shareFileRegister(shareFileDto);
        }
    }

//    업로드 파일 저장처리
    public ShareFileDto saveShareFile(MultipartFile file) throws IOException{
//      사용자가 업로드 한 파일 이름(확장자 포함)
        String originalName = file.getOriginalFilename();
//      이미지 파일에 띄어쓰기가 있는경우 띄어쓰기 없애주기
        originalName = originalName.replaceAll("\\s+", "");
//      파일 이름에 붙여줄 uuid 생성하기(파일이름의 중복이 나오지 않게 처리)
        UUID uuid = UUID.randomUUID();
//      uuid와 파일이름 합쳐주기
        String systemName = uuid.toString() + "_" + originalName;

//      상위경로와 하위경로 합치기
        File uploadPath = new File(fileDir, getUploadPath());

//      경로에 폴더가 없다면 생성하기
        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }

//      전체 경로와 파일이름 연결하기
        File uploadFile = new File(uploadPath, systemName);

        file.transferTo(uploadFile);

//      썸네일 저장하기
        if(Files.probeContentType(uploadFile.toPath()).startsWith("image")){
            FileOutputStream out = new FileOutputStream(new File(uploadPath, "th_" + systemName));
            Thumbnailator.createThumbnail(file.getInputStream(), out, 300, 200);
            out.close();
        }

        ShareFileDto shareFileDto = new ShareFileDto();
        shareFileDto.setFileSystemName(originalName);
        shareFileDto.setFileUuid(uuid.toString());
        shareFileDto.setFileUploadPath(getUploadPath());

        return shareFileDto;
    }

//    파일 저장되는 하위 경로를 현재 날짜로 설정하기
    public String getUploadPath(){
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

//    나눔 글 번호로 파일 조회하기
    public List<ShareFileDto> shareFileFindList(Long shareNumber){
        if(shareNumber == null){
            throw new IllegalArgumentException("나눔 글 번호가 일치하지 않습니다.");
        }

        return shareFileMapper.shareFileList(shareNumber);
    }

//    나눔 글 번호로 파일 삭제하기
    public void shareFileRemove(Long shareNumber){
        if (shareNumber == null){
            throw new IllegalArgumentException("나눔 글 번호가 일치하지 않습니다.");
        }

//        실제 파일경로에 첨부파일 삭제하기
        List<ShareFileDto> shareFileList = shareFileFindList(shareNumber);

        for(ShareFileDto file : shareFileList){
            File target = new File(fileDir, file.getFileUploadPath() +  "/" + file.getFileUuid() + "_" + file.getFileSystemName());
            File thumbnail = new File(fileDir, file.getFileUploadPath() + "/th" + file.getFileUuid() + "_" + file.getFileSystemName());

            if(target.exists()) {
                target.delete();
            }

            if(thumbnail.exists())  {
                thumbnail.delete();
            }
        }

        shareFileMapper.shareFileDelete(shareNumber);
    }

//    나눔 글 전날 업러도 된 것 조회하기
    public List<ShareFileDto> shareFileFindList(){

        return shareFileMapper.shareOldSelect();
    }
}
