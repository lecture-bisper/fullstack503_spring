package bitc.fullstack503.board1.dto;

import lombok.Data;

@Data
public class BoardDTO {

  private int boardIdx;
  private String title;
  private String contents;
  private String createId;
  private String createDate;
  private String updateId;
  private String updateDate;
  private int hitCnt;
}












