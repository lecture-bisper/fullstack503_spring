package bitc.fullstack503.board1.mapper;

import bitc.fullstack503.board1.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//  데이터베이스와 연동되어 실행 방법만 제공하는 인터페이스
//  JSP의 DAO 클래스의 기능을 수행

//  @Mapper : Mybatis 의 Mapper 로써 데이터베이스와 연동됨을 스프링 프레임워크에 알려주는 어노테이션
//  MyBatis 에서 제공하는 SQL 쿼리문 XML 파일과 1:1로 연동되어 있음
//  메소드 오버로딩을 사용할 수 없음 (xml 파일이 메소드 오버로딩을 사용할 수 없음)
//  Mapper 파일에 등록된 메소드 명과 데이터 타입을 xml 파일에서 그대로 사용함
@Mapper
public interface BoardMapper {

//  게시글 전체 목록 조회
  public List<BoardDTO> selectBoardList() throws Exception;

//  글 등록
  public void insertBoard(BoardDTO board) throws Exception;
  
//  글 상세보기
  public BoardDTO selectBoardDetail(int boardIdx) throws Exception;

//  @Param : MyBatis의 xml 파일에서 사용할 변수명을 지정하는 어노테이션, @Param 을 사용하지 않을 경우 매개변수의 이름을 그대로 사용함
//  글 삭제
  public void deleteBoard(@Param("idx") int boardIdx) throws Exception;

//  글 수정
  public void updateBoard(BoardDTO board) throws Exception;

  public void updateHitCnt(@Param("boardIdx") int boardIdx) throws Exception;
}












