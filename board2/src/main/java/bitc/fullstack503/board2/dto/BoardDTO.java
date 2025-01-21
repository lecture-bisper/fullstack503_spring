package bitc.fullstack503.board2.dto;

import lombok.Data;

// 게시판 데이터 전달용 DTO 클래스
@Data
public class BoardDTO {

  private int boardIdx;
  private String title;
  private String contents;
  private int hitCnt;
  private String createId;
  private String createDate;
  private String updateId;
  private String updateDate;
}












