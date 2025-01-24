package bitc.fullstack503.board4.service;

import bitc.fullstack503.board4.entity.JpaBoardEntity;
import bitc.fullstack503.board4.repository.JpaBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaBoardServiceImpl implements JpaBoardService {

//  @Autowired 를 사용하여 JpaBoardRepository 를 스프링 프레임워크가 관리하도록 설정
  @Autowired
  private JpaBoardRepository jpaBoardRepository;

//  게시물 목록 가져오기
  @Override
  public List<JpaBoardEntity> selectBoardList() {
//    jpaBoardRepository 를 사용하여 JpaRepository에서 제공한 쿼리 메소드를 실행
    return jpaBoardRepository.findAllByOrderByBoardIdxDesc();
  }

//  게시물 상세 보기
  @Override
  public JpaBoardEntity selectBoardDetail(int boardIdx) {

//    Optional : 데이터베이스에서 데이터를 조회 시 조회된 데이터가 Null 일 경우 이 null은 자바의 null과 의미가 조금 다름
//    데이터베이스의 null은 특정 컬럼에 데이터가 없다는 의미로 사용되고, 자바의 null 은 객체의 참조 주소가 없다는 의미
//    데이터베이스의 null 을 자바 소스코드에 그대로 적용 시 원하지 않는 오류가 발생할 수 있음
//    이러한 오류를 줄이기 위해서 만들어진 데이터 타입이 Optional
//    데이터베이스에서 가져온 데이터를 Optional 타입에 저장하고 실제 데이터가 있는지 여부를 확인한 후 자바 객체 타입으로 출력
    
//    JpaRespositoy에서 제공하는 기본 검색 메소드 findById() 를 사용하여 데이터를 조회
//    가져온 데이터를 Optional 타입에 저장
    Optional<JpaBoardEntity> optBoard = jpaBoardRepository.findById(boardIdx);

//    Optional 타입에 저장된 데이터가 존재하는 여부 확인
    if (optBoard.isPresent()) {
//      데이터가 있을 경우 반환할 데이터 타입의 객체 생성
//      get() 메소드를 사용하여 Optional 타입에 저장된 데이터를 출력
      JpaBoardEntity board = optBoard.get();
//      현재 게시물의 조회수 증가
      board.setHitCnt(board.getHitCnt() + 1);
//      수정된 데이터를 다시 데이터베이스에 저장
      jpaBoardRepository.save(board);

//      수정된 데이터를 컨트롤러로 반환
      return board;
    }
    else {
      throw new NullPointerException();
    }
  }

//  데이터베이스의 insert 와 update 기능을 한번에 처리
  @Override
  public void saveBoard(JpaBoardEntity board) {
//    JpaRepository 에서 제공하는 save() 메소드는 insert와 update 기능을 한번에 구현함
    jpaBoardRepository.save(board);
  }

  @Override
  public void deleteBoard(int boardIdx) {
//    JpaRepository 에서 제공하는 deleteById() 메소드를 사용하여 delete 기능 구현
    jpaBoardRepository.deleteById(boardIdx);
  }

}












