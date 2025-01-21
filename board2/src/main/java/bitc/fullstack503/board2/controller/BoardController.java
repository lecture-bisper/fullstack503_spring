package bitc.fullstack503.board2.controller;

import bitc.fullstack503.board2.dto.BoardDTO;
import bitc.fullstack503.board2.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//  게시판용 Controller 클래스
@Controller
//  기본 주소를 /board 로 설정
@RequestMapping("/board")
public class BoardController {

  @Autowired
  private BoardService boardService;

  @RequestMapping("/")
  public String index() {
    return "index";
  }

//  게시판 목록 보기
  @RequestMapping("/boardList.do")
  public ModelAndView boardList() throws Exception {
    ModelAndView mav = new ModelAndView("board/boardList");

    List<BoardDTO> boardList = boardService.selectBoardList();
    mav.addObject("boardList", boardList);

    return mav;
  }

//  게시글 상세 보기, 로그인 상태에서만 사용 가능
//  매개변수로 HttpServletRequest 를 받아옴
  @RequestMapping("/boardDetail.do")
//  public ModelAndView boardDetail(@RequestParam("boardIdx") int boardIdx, HttpServletRequest request) throws Exception {
  public ModelAndView boardDetail(@RequestParam("boardIdx") int boardIdx) throws Exception {

////    HttpServletRequest 에서 제공하는 getSession() 메소드로 세션 정보를 가져옴
//    HttpSession session = request.getSession();
////    ModelAndView 객체 생성 시 View 를 지정하지 않음
//    ModelAndView mav = new ModelAndView();
//
////    세션 정보가 있는지 확인
//    if (session.getAttribute("userId") == null) {
////      세션 정보가 없을 경우 로그인 페이지로 리다이렉트
//      mav.setViewName("redirect:/board/login/login.do");
//    }
//    else {
////      세션 정보가 있을 경우 View 파일 설정
//      mav.setViewName("board/boardDetail");
////      BoardService 에서 제공하는 selectBoardDetail() 메소드를 사용하여 지정한 게시물의 정보를 가져옴
//      BoardDTO board = boardService.selectBoardDetail(boardIdx);
////      가져온 게시물 정보를 ModelAndView 객체에 저장
//      mav.addObject("board", board);
//    }

    ModelAndView mav = new ModelAndView();
    BoardDTO board = boardService.selectBoardDetail(boardIdx);
    mav.addObject("board", board);

    return mav;
  }

  @RequestMapping("/boardWrite.do")
//  public String boardWrite(HttpServletRequest request) throws Exception {
  public String boardWrite() throws Exception {
//    HttpSession session = request.getSession();
//
//    if (session.getAttribute("userId") == null) {
//      return "redirect:/board/login/login.do";
//    }
//    else {
//      return "board/boardWrite";
//    }
    return "board/boardWrite";
  }
}












