package bitc.fullstack503.board2.mapper;

import bitc.fullstack503.board2.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

//  게시판 목록 보기
  List<BoardDTO> selectBoardList() throws Exception;

//  게시판 글 상세 보기
  BoardDTO selectBoardDetail(@Param("boardIdx")int boardIdx) throws Exception;

  void updateHitCnt(@Param("boardIdx") int boardIdx);
}












