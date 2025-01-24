package bitc.fullstack503.board4.controller;

import bitc.fullstack503.board4.entity.JpaBoardEntity;
import bitc.fullstack503.board4.service.JpaBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// @Controller 를 사용하여 Spring 프레임워크에 해당 클래스가 controller 클래스임을 알려줌
//  기본 주소를 /jpa 로 설정
@Controller
@RequestMapping("/jpa")
public class BoardController {

//  JpaBoardService 를 @Autowired 사용하여 스프링 프레임워크에서 관리하도록 함
  @Autowired
  private JpaBoardService jpaBoardService;

  @RequestMapping("/")
  public String index() {
    return "index";
  }

//  게시물 목록, 기존에 했던 게시판 프로그램과 동일함
  @GetMapping("/board")
  public ModelAndView selectBoardList() throws Exception {
//    View 파일 설정
    ModelAndView mv = new ModelAndView("board/jpaBoardList");

//    서비스 객체를 사용하여 데이터 목록 가져옴
    List<JpaBoardEntity> boardList = jpaBoardService.selectBoardList();
//    ModelAndView 객체에 데이터 추가
    mv.addObject("boardList", boardList);

    return mv;
  }
  
//  게시물 상세 보기
  @GetMapping("/board/{boardIdx}")
  public ModelAndView selectBoardDetail(@PathVariable("boardIdx") int boardIdx) {
    ModelAndView mv = new ModelAndView("board/jpaBoardDetail");

    JpaBoardEntity board = jpaBoardService.selectBoardDetail(boardIdx);
    mv.addObject("board", board);

    return mv;
  }
  
//  게시물 등록(View)
  @GetMapping("/board/write")
  public String insertBoard() {
    return "board/jpaBoardWrite";
  }

//  게시물 등록(Process)
  @PostMapping("/board/write")
  public String insertBoard(JpaBoardEntity board) {
    jpaBoardService.saveBoard(board);

    return "redirect:/jpa/board";
  }

//  게시물 수정
  @PutMapping("/board/{boardIdx}")
  public String updateBoard(@PathVariable("boardIdx") int boardIdx, JpaBoardEntity board) {
    jpaBoardService.saveBoard(board);

    return "redirect:/jpa/board";
  }
  
//  게시물 삭제
  @DeleteMapping("/board/{boardIdx}")
  public String deleteBoard(@PathVariable("boardIdx") int boardIdx) {
    jpaBoardService.deleteBoard(boardIdx);

    return "redirect:/jpa/board";
  }
}












