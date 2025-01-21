package bitc.fullstack503.board3.service;

import bitc.fullstack503.board3.dto.BoardDTO;
import bitc.fullstack503.board3.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardMapper boardMapper;

//  게시물 목록
  @Override
  public List<BoardDTO> selectBoardList() {
    return boardMapper.selectBoardList();
  }

//  게시물 상세
  @Override
  public BoardDTO selectBoardDetail(int boardIdx) {
    boardMapper.updateHitCnt(boardIdx);
    return boardMapper.selectBoardDetail(boardIdx);
  }

//  게시물 등록
  @Override
  public void insertBoard(BoardDTO board) {
    boardMapper.insertBoard(board);
  }

//  게시물 수정
  @Override
  public void updateBoard(BoardDTO board) {
    boardMapper.updateBoard(board);
  }

//  게시물 삭제
  @Override
  public void deleteBoard(int boardIdx) {
    boardMapper.deleteBoard(boardIdx);
  }
}












