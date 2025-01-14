package bitc.fullstack503.board1.service;

import bitc.fullstack503.board1.dto.BoardDTO;
import bitc.fullstack503.board1.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardMapper boardMapper;

  @Override
  public List<BoardDTO> selectBoardList() throws Exception {

    return boardMapper.selectBoardList();
  }
}












