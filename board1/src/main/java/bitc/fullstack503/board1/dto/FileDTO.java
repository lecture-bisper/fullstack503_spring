package bitc.fullstack503.board1.dto;

import lombok.Data;

//  t_file 테이블의 데이터를 주고 받기 위한 DTO 클래스

@Data
public class FileDTO {

  private int fileIdx;
  private int boardIdx;
  private String originalFileName;
  private String storedFileName;
  private long fileSize;
  private String createId;
  private String createDate;
  private String updateId;
  private String updateDate;
}












