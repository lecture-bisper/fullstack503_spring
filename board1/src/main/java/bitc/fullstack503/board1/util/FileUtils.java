package bitc.fullstack503.board1.util;

import bitc.fullstack503.board1.dto.FileDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//  @Bean : 스프링 프레임워크 혹은 각종 서드 파티 회사에서 제공하는 라이브러리의 클래스를 사용 시 사용하는 어노테이션
//  @Component : 사용자가 직접 작성한 클래스를 스프링 프레임워크에서 관리를 맡기기 위해서 사용하는 어노테이션
// @Bean, @Component 은 스프링 프레임워크에서 객체를 생성하여 사용하고 관리하는 라이브러리를 뜻하는 어노테이션

@Component
public class FileUtils {

  public List<FileDTO> parseFileInfo(int boardIdx, String createId, MultipartHttpServletRequest multipart) throws Exception {

//    ObjectUtils : 스프링 프레임워크에서 제공하는 유틸 클래스
//    업로드된 정보가 존재하는지 여부를 확인
    if (ObjectUtils.isEmpty(multipart)) {
//      업로드 된 정보가 없으면 null을 반환
      return null;
    }
    
//    업로드 된 정보가 있을 경우 데이터 가져오기

//    반환할 데이터 객체 생성
    List<FileDTO> fileList = new ArrayList<>();

//    지정한 날짜를 기준으로 패턴 생성, 4자리 년도, 2자리 월, 2자리 일 형식으로 패턴 생성
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//    현재 위치를 기준으로 현재 시간을 가져옴
    ZonedDateTime current = ZonedDateTime.now();

//    기준이 되는 폴더와 위에서 생성한 패턴에 맞는 날짜 정보를 사용하여 전체 경로 문자열 생성
    String path = "C:/fullstack503/images/" + current.format(formatter);

//    위에서 만든 전체 경로를 기준으로 File 클래스 타입의 객체 생성
    File file = new File(path);

//    해당 폴더가 존재하는지 확인, 있으면 true/ 없으면 false
    if (file.exists() == false) {
//      지정한 경로의 폴더를 생성
//      mkdirs() : 폴더를 생성하는 메소드, mkdir()/mkdirs() 가 존재
//      mkdir() : 지정한 폴더 1개만 생성, 생성하고자 하는 폴더의 상위 폴더가 없으면 오류
//      mkdirs() : 지정한 폴더를 생성하기 위해 존재하는 모든 상위 폴더를 다 함께 생성
      file.mkdirs();
    }

//    업로드 된 파일 정보에서 전체 파일 이름 목록을 가져옴
    Iterator<String> iterator = multipart.getFileNames();

    String newFileName;
    String originalFileExt;
    String contentType;

//    hasNext() : Iterator 타입의 객체에서 출력할 데이터가 있는지 확인하는 메소드
//    가져올 데이터가 있는지 확인
    while (iterator.hasNext()) {
//      next() : Iterator 타입의 객체에서 실제로 데이터를 출력
//      파일 이름을 하나 가져옴
      String name = iterator.next();
//      가져온 파일 이름을 가지고 해당 파일의 전체 정보를 가져옴
      List<MultipartFile> multipartFileList = multipart.getFiles(name);

//      가져온 파일 목록에서 반복문으로 내용을 하나씩 출력
      for (MultipartFile uploadFile : multipartFileList) {
//        현재 파일의 파일 타입을 가져옴
        contentType = uploadFile.getContentType();

        if (ObjectUtils.isEmpty(contentType)) {
          break;
        }
        else {
//          가져온 파일 타입 정보를 기준으로 파일의 확장자를 설정
          if (contentType.contains("image/jpeg")) {
            originalFileExt = ".jpg";
          }
          else if (contentType.contains("image/png")) {
            originalFileExt = ".png";
          }
          else if (contentType.contains("image/gif")) {
            originalFileExt = ".gif";
          }
          else {
            break;
          }
        }

//        System.nanoTime() : 현재 시간을 기준으로 nano 초로 표시함
//        현재 시간을 기준으로 확장자를 가지고 있는 파일명을 새로 생성함
        newFileName = System.nanoTime() + originalFileExt;

//        FileDTO 클래스 타입의 객체 생성
        FileDTO fileDTO = new FileDTO();
//        가져온 파일 정보를 FileDTO 클래스 타입의 객체에 저장
        fileDTO.setBoardIdx(boardIdx); // 첫번째 매개변수로 받아온 게시물 번호 저장
        fileDTO.setFileSize(uploadFile.getSize()); // 현재 파일의 크기 저장
        fileDTO.setOriginalFileName(uploadFile.getOriginalFilename()); // 원본 파일명 저장
        fileDTO.setStoredFileName(path + "/" + newFileName); // 서버에 저장될 전체 경로 및 파일명을 저장
        fileDTO.setCreateId(createId); // 사용자 ID 저장

//        반환할 List 에 생성한 FileDTO 클래스 타입의 객체를 저장
        fileList.add(fileDTO);

//        전체 경로 + 새 파일명을 가지고 File 클래스 타입의 객체 생성
        file = new File(path + "/" + newFileName);
//        지정한 경로로 파일을 저장, 현재까지 메모리에 저장되어 있던 파일 정보를 실제 디스크로 저장
        uploadFile.transferTo(file);
      }
    }

//    생성된 List<FileDTO> 타입 데이터를 반환
    return fileList;
  }
}












