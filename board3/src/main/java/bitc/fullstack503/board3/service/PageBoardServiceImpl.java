package bitc.fullstack503.board3.service;

import bitc.fullstack503.board3.dto.BoardDTO;
import bitc.fullstack503.board3.mapper.PageBoardMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageBoardServiceImpl implements PageBoardService {

  @Autowired
  private PageBoardMapper pageBoardMapper;

//  Page : PageHelper 라이브러리에서 제공하는 데이터 타입, ArrayList 와 비슷한 데이터 타입
  @Override
  public Page<BoardDTO> selectPageBoardList(int pageNum) {
//    첫번째 매개변수 : 현재 페이지 번호를 입력
//    두번째 매개변수 : 한 페이지에 표시할 게시물 수를 설정
//    PageHelper 라이브러리가 mapper 를 사용하여 전체 데이터를 불러온 후 자동으로 제어함
//    mapper 의 sql 문에 limit 로 개수 제한을 할 필요가 없음
    PageHelper.startPage(pageNum, 3);
    return pageBoardMapper.selectPageBoardList();
  }
}












