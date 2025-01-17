package bitc.fullstack503.board1.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

//  DTO : 데이터베이스의 데이터 타입과 자바의 데이터 타입이 서로 다르기 때문에 데이터베이스와 타입과 자바의 타입을 서로 맞추기 위해서 사용하는 데이터 전송용 자바 클래스
//  DTO 클래스 생성 시 필드는 반드시 접근제한자를 private 로 사용하고, 데이터 입출력을 위해서 Getter/Setter 를 사용해야 함

// @Data : Lombok 라이브러리에서 제공하는 어노테이션
// 자동으로 Getter/Setter 메소드를 생성하여 제공
// 자동으로 toString 메소드를 생성하여 제공
// @Getter, @Setter, @ToString 어노테이션이 합쳐진 어노테이션

// @Getter : Lombok 라이브러리에서 제공하는 Getter 메소드를 자동으로 생성하는 어노테이션
// @Setter : Lombok 라이브러리에서 제공하는 Setter 메소드를 자동으로 생성하는 어노테이션
// @ToString : Lombok 라이브러리에서 제공하는 toString메소드를 자동으로 생성하는 어노테이션

@Data
//@Getter
//@Setter
//@ToString
public class BoardDTO {

  private int boardIdx;
  private String title;
  private String contents;
  private String createId;
  private String createDate;
  private String updateId;
  private String updateDate;
  private int hitCnt;
//  업로드된 파일 목록
  private List<FileDTO> fileList;
}












