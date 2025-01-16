package bitc.fullstack503.board1.service;

import bitc.fullstack503.board1.dto.BoardDTO;
import bitc.fullstack503.board1.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//  BoardService 인터페이스를 구현한 BoardServiceImpl 클래스

//  @Service : 스프링 프레임워크에 해당 파일이 서비스 파일임을 알려주는 어노테이션
@Service
public class BoardServiceImpl implements BoardService {

//  데이터베이스 사용을 위해 Mapper 인터페이스 타입의 변수를 선언
//  @Autowired 어노테이션을 사용하여 스프링 프레임워크가 자동으로 객체를 생성하고 관리함
  @Autowired
  private BoardMapper boardMapper;

//  부모 인터페이스인 BoardService 에서 상속받아 구현한 메소드
  @Override
  public List<BoardDTO> selectBoardList() throws Exception {
//  BoardMapper 에서 제공하는 selectBoardList() 메소드를 사용하여 데이터를 가져옴
    return boardMapper.selectBoardList();
  }
  
//  글 등록, 매개변수로 BoardDTO 클래스 타입의 객체를 받음
  @Override
  public void insertBoard(BoardDTO board) throws Exception {
//    Mapper 에서 제공하는 insertBoard() 메소드를 호출
    boardMapper.insertBoard(board);
  }

//  글 상세보기
  @Override
  public BoardDTO selectBoardDetail(int boardIdx) throws Exception {
    // 조회수 업데이트
    boardMapper.updateHitCnt(boardIdx);
    return boardMapper.selectBoardDetail(boardIdx);
  }

//  글 삭제
  @Override
  public void deleteBoard(int boardIdx) throws Exception {
//    BoardMapper 객체에서 제공하는 deleteBoard() 메소드를 사용하여 지정한 데이터를 삭제
    boardMapper.deleteBoard(boardIdx);
  }

  @Override
  public void updateBoard(BoardDTO board) throws Exception {
//    BoardMapper 객체에서 제공하는 updateBoard() 메소드를 사용하여 지정한 데이터를 클라이언트에서 전달받은 데이터로 수정
    boardMapper.updateBoard(board);
  }
}












