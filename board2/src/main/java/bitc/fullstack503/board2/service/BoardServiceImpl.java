package bitc.fullstack503.board2.service;

import bitc.fullstack503.board2.dto.BoardDTO;
import bitc.fullstack503.board2.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardMapper boardMapper;

//  게시판 목록 보기 구현
  @Override
  public List<BoardDTO> selectBoardList() throws Exception {
    return boardMapper.selectBoardList();
  }

//  게시판 글 상세 보기 구현
  @Override
  public BoardDTO selectBoardDetail(int boardIdx) throws Exception {
    boardMapper.updateHitCnt(boardIdx);
    BoardDTO board = boardMapper.selectBoardDetail(boardIdx);
    return board;
  }
}












