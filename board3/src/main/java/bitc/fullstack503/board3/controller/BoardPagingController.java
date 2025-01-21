package bitc.fullstack503.board3.controller;

import bitc.fullstack503.board3.dto.BoardDTO;
import bitc.fullstack503.board3.service.PageBoardService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board/page")
public class BoardPagingController {

  @Autowired
  private PageBoardService pageBoardService;

//  RequestParam 의 추가 옵션
//  required : 지정한 파라미터가 전달되었는지 확인, 기본값 true, false 사용 시 지정한 파라미터값이 전달되지 않아도 오류가 발생하지 않음
//  defaultValue : 지정한 파라미터 값 전달되지 않았을 경우 지정한 값을 대신 사용
//  value : 클라이언트에서 전달받는 파라미터의 이름을 지정
  @GetMapping("/board")
  public ModelAndView selectPageBoardList(
      @RequestParam(required = false, defaultValue = "1", value = "pageNum") int pageNum
  ) {
    ModelAndView mav = new ModelAndView("page/pageBoardList");

//    PageInfo : PageHelper 라이브러리에서 제공하는 데이터 타입, HashMap 과 비슷한 데이터 타입
//    첫번째 매개변수 : 서비스를 사용하여 DB에서 데이터를 가져오는 메소드를 입력
//    두번째 매개변수 : 한 페이지에 출력할 페이지 이동 버튼 수
    PageInfo<BoardDTO> pageBoardList = new PageInfo<>(pageBoardService.selectPageBoardList(pageNum), 5);
    mav.addObject("pageBoardList", pageBoardList);

    return mav;
  }

//  PageInfo : PageHelper 라이브러리에서 제공하는 클래스
//  페이징 기법을 쉽게 사용할 수 있도록 여러가지 정보를 제공

//  list : PageInfo 에 저장된 게시물 목록 (List 타입)
//  pageNum : 현재 페이지 번호
//  pageSize : 한 페이지당 출력할 게시물 수
//  size : 현재 페이지에 출력된 게시물 수
//  startRow : 현재 페이지의 첫번째 요소가 데이터베이스에 있는 줄 번호
//  endRow : 현재 페이지의 마지막 요소가 데이터베이스에 있는 줄 번호
//  pages : 전체 페이지 수
//  prePage : 이전 페이지
//  nextPage : 다음 페이지
//  isFirstPage : 현재 페이지가 첫 페이지인지 여부 확인, true/false
//  isLastPage : 현재 페이지가 마지막 페이지인지 여부 확인, true/false
//  hasPreviousPage : 이전 페이지가 존재하는지 여부 확인, true/false
//  hasNextPage : 다음 페이지가 존재하는지 여부 확인, true/false
//  navigatePages : 네비게이션 블록의 크기
//  navigatePageNums : 전체 네비게이션 페이지 번호, 배열로 구성
//  navigateFirstPage : 네비게이션 블록의 첫 페이지 번호
//  navigateLastPage : 네비게이션 블록의 마지막 페이지 번호
}












