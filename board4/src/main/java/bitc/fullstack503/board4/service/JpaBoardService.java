package bitc.fullstack503.board4.service;

import bitc.fullstack503.board4.entity.JpaBoardEntity;

import java.util.List;

public interface JpaBoardService {

  List<JpaBoardEntity> selectBoardList();

  JpaBoardEntity selectBoardDetail(int boardIdx);

  void saveBoard(JpaBoardEntity board);

  void deleteBoard(int boardIdx);
}












