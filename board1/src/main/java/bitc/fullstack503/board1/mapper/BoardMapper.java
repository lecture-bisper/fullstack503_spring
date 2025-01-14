package bitc.fullstack503.board1.mapper;

import bitc.fullstack503.board1.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

  public List<BoardDTO> selectBoardList() throws Exception;
}












