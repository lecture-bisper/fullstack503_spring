package bitc.fullstack503.board1.service;

import bitc.fullstack503.board1.dto.BoardDTO;
import bitc.fullstack503.board1.dto.FileDTO;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

//  BoardService 는 인터페이스 이므로 사용 방법만 제공
//  해당 인터페이스를 구현하는 클래스가 반드시 필요함
public interface BoardService {

//  실행 시 BoardDTO 클래스 타입의 List를 반환
  public List<BoardDTO> selectBoardList() throws Exception;

  public void insertBoard(BoardDTO board) throws Exception;

  public void insertBoard(BoardDTO board, MultipartHttpServletRequest multipart) throws Exception;

  public BoardDTO selectBoardDetail(int boardIdx) throws Exception;

  public void deleteBoard(int boardIdx) throws Exception;

  public void updateBoard(BoardDTO board) throws Exception;

  public FileDTO selectBoardFileInfo(int fileIdx, int boardIdx) throws Exception;
}












