package bitc.fullstack503.board2.service;

import bitc.fullstack503.board2.dto.BoardDTO;

import java.util.List;

public interface BoardService {

//  게시판 목록 보기
  List<BoardDTO> selectBoardList() throws Exception;

//  게시판 글 상세 보기
  BoardDTO selectBoardDetail(int boardIdx) throws Exception;
}












