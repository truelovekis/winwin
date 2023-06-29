package com.example.winwin.service.myPage;

import com.example.winwin.dto.user.UserDto;
import com.example.winwin.dto.user.UserPfpDto;
import com.example.winwin.mapper.file.MyPageFile;
import com.example.winwin.mapper.myPage.UserInfoMapper;
import com.example.winwin.vo.myPage.MyPageVo;
import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class MyPageService {
    private final UserInfoMapper userInfoMapper;
    private final MyPageFile myPageFile;
    private final MyPageVo myPageVo;

    @Value("${pfp.dir}")
    private String pfpDir;

//    본인 정보 불러오기
    @Transactional(readOnly = true)
    public MyPageVo getUserInfo(Long userNumber){
        if(userNumber == null){
            throw new IllegalArgumentException("로그인이 필요한 서비스입니다.");
        }

        myPageVo.setUserVo(
                Optional.ofNullable(userInfoMapper.selectUserInfo(userNumber))
                .orElseThrow(()->{throw new IllegalArgumentException("회원정보가 존재하지 않습니다.");})
        );
        myPageVo.setMentorTag(userInfoMapper.selectMentorTag(userNumber));
        myPageVo.setInterestTag(userInfoMapper.selectInterestTag(userNumber));
        myPageVo.setBoardCnt(userInfoMapper.selectBoardCnt(userNumber));
        myPageVo.setCommentCnt(userInfoMapper.selectCommentCnt(userNumber));

        return myPageVo;
    }

//    본인 정보 수정하기
    public void updateUserInfo(UserDto userDto){
        if(userDto == null){
            throw new IllegalArgumentException("수정할 회원정보가 없습니다.");
        }

        userInfoMapper.updateUserInfo(userDto);
    }


//    관심태그 수정하기
    public void modifyInterestTag(Long userNumber, List<String> tagList){
        if(userNumber == null || tagList == null){
            throw new IllegalArgumentException("수정할 관심태그 정보가 없습니다.");
        }

        userInfoMapper.deleteInterestTag(userNumber);
        tagList.forEach(subNumber ->
                userInfoMapper.insertInterestTag(Integer.valueOf(subNumber), userNumber)
        );
    }

//    프로필 사진 등록하기
    public void registerProfile(UserPfpDto userPfpDto){
        if(userPfpDto == null){
            throw new IllegalArgumentException("수정할 이미지 정보가 없습니다.");
        }
        myPageFile.insertProfile(userPfpDto);
    }

    //    파일 저장
    public UserPfpDto saveFile(MultipartFile file) throws IOException {
//        사용자가 올린 파일 이름(확장자를 포함 함)
        String originName = file.getOriginalFilename();
        originName = originName.replaceAll("\\s+", "");
//        파일이름에 붙여줄 uuid 생성(파일이름 중복이 나오지 않게 처리)
        UUID uuid = UUID.randomUUID();
//        uuid와 파일이름을 합쳐준다.
        String sysName = uuid.toString() + "_" + originName;

//        날짜가 필요없기에 상위 경로만.
        File uploadPath = new File(pfpDir);

        //        경로가 존재하지 않는다면(폴더가 없다면)
        if(!uploadPath.exists()){
//            경로에 필요한 폴더를 생성한다.
            uploadPath.mkdirs();
        }

//        전체 경로와 파일이름을 연결한다.
        File uploadFile = new File(uploadPath, sysName);

//        썸네일 크기로 파일을 저장한다.
        if(Files.probeContentType(uploadFile.toPath()).startsWith("image")) {
            FileOutputStream out = new FileOutputStream(new File(uploadPath, sysName));
            Thumbnailator.createThumbnail(file.getInputStream(), out, 200, 200);
            out.close();
        }

        UserPfpDto userPfpDto =new UserPfpDto();
        userPfpDto.setPfpSystemName(originName);
        userPfpDto.setPfpUuid(uuid.toString());
        userPfpDto.setPfpUploadPath(uploadPath.toString());

        return userPfpDto;
    }

//    프로필 사진 불러오기
    public UserPfpDto getProfile(Long userNumber){
        if(userNumber == null){
            throw new IllegalArgumentException("로그인이 필요합니다.");
        }
        return myPageFile.selectProfile(userNumber);
    }

//    프로필 사진 수정하기
    public void modifyProfile(UserPfpDto userPfpDto){
        if(userPfpDto == null){
            throw new IllegalArgumentException("수정할 이미지 정보가 없습니다.");
        }
        myPageFile.updateProfile(userPfpDto);
    }

//    프로필 사진 DB 에서 삭제
    public void removeProfile(Long userNumber){
        if (userNumber == null) {
            throw new IllegalArgumentException("회원 정보가 없습니다.");
        }

        UserPfpDto userPfpDto = myPageFile.selectProfile(userNumber);

        if(userPfpDto == null){
            return;
        }

        File target = new File(pfpDir, userPfpDto.getPfpUuid() + "_" + userPfpDto.getPfpSystemName());

        if(target.exists()){
            target.delete();
        }

        myPageFile.deleteProfile(userNumber);
    }

//    회원 탈퇴
    public void withdrawUser(Long userNumber){
        if(userNumber == null){
            throw new IllegalArgumentException("회원정보가 없습니다.");
        }
        userInfoMapper.deleteUser(userNumber);
    }

}
