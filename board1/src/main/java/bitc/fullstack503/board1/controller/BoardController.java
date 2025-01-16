package bitc.fullstack503.board1.controller;

import bitc.fullstack503.board1.dto.BoardDTO;
import bitc.fullstack503.board1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

// 실제 클라이언트의 요청을 Controller 처리하는 클래스
// 기능에 따라서 여러개의 Controller 클래스 파일을 생성해서 사용

//  @Controller : 해당 클래스가 Spring WEB MVC 의 Controller 파일임을 스프링 프레임워크에 알려주는 역할을 하는 어노테이션
// JSP에서 Servlet 파일과 동일한 역할을 함
// JSP Servlet에서는 URL 하나에 Servlet 파일 하나를 연동하는 방식으로 동작하지만 Spring MVC 의 Controller 는 하나의 Controller 파일에 @RequestMapping 어노테이션을 사용하여 메소드에 URL을 연동하는 방식으로 하나의 Controller 파일에서 여러개의 URL을 연동하여 사용할 수 있음

//  @RestController : @Controller 어노테이션과 동일한 역할을 하는 어노테이션, 클라이언트로 전달하는 것이 View 파일이 아닌 데이터를 직접 전달할 경우 사용하는 어노테이션

@Controller
public class BoardController {

//  @Autowired : 지정한 클래스 및 인터페이스를 사용하여 객체를 생성할 때 사용자가 직접 생성하는 것이 아닌 스프링 프레임워크가 객체를 생성하고 관리하도록 하는 어노테이션
  @Autowired
  private BoardService boardService;

//  @RequestMapping : 클라이언트에서 서버로 접속하기 위한 URL과 지정한 클래스 및 메소드를 연동하기 위한 어노테이션, 클라이언트와 통신하는 방식을 설정할 수 있음
//  하나의 메소드에 접속할 URL을 여러개로 사용할 경우 {URL1, URL2, ... } 방식으로 입력
//  value : 클라이언트가 접속할 URL을 입력, URL만 입력 시 value 생략 가능
//  method : 클라이언트와 통신 방식을 지정 (GET, POST, PUT, DELETE)
  @RequestMapping(value = {"/board/openBoardList.do", "/board", "/board/"}, method = RequestMethod.GET)
  public ModelAndView openBoardList() throws Exception {
//    ModelAndView : 클라이언트에서 화면에 출력되는 View 와 데이터가 함께 포함된 클래스
//    ModelAndView 클래스의 생성자에 View 파일을 경로와 함께 지정
    ModelAndView mv = new ModelAndView("board/openBoardList");

//    BoardService 에서 제공하는 selectBoardList() 메소드를 사용하여 List<BoardDTO> 타입의 데이터를 가져옴
    List<BoardDTO> boardList = boardService.selectBoardList();
    
//    ModelAndView 클래스 타입의 객체에 'boardList' 라는 이름으로 데이터를 추가
//    JSP에서 request 영역에 setAttribute() 로 데이터를 저장하는 것과 같음
    mv.addObject("boardList", boardList);

//    클라이언트에게 View 템플릿과 데이터를 함께 전달
    return mv;
  }

//  단순 View(글쓰기 페이지)를 출력하는 메소드
  @RequestMapping("/board/boardWrite.do")
  public String boardWrite() throws Exception {
    return "board/boardWrite";
  }

//  클라이언트에서 전달받은 데이터를 데이터베이스에 저장 처리
//  매개변수에 BoardDTO 클래스 타입의 객체를 받음
//  클라이언트가 전달한 데이터의 이름을 BoardDTO 클래스 타입의 필드와 1:1 로 매칭해서 BoardDTO 클래스 타입의 객체로 만듬
//  boardWrite.html 의 input 태그의 name 속성명이 BoardDTO 클래스 타입의 필드명과 일치해야 함
  @RequestMapping("/board/insertBoard.do")
  public String insertBoard(BoardDTO board) throws Exception {
//  public String insertBoard(
//      @RequestParam("title") String title,
//      @RequestParam("createId") String createId,
//      @RequestParam("contents") String contents
//  ) throws Exception {
//    서비스 객체에서 제공하는 insertBoard() 메소드를 사용하여 데이터베이스에 데이터 저장
    boardService.insertBoard(board);

//    JSP의 response.sendRedirect() 와 같은 역할
//    @RequestMapping("/board/openBoardList.do") 의 위치로 이동
    return "redirect:/board/openBoardList.do";
  }


//  글 상세보기
//  @RequestParam : 클라이언트에서 전달한 데이터의 변수명을 알려주는 어노테이션, JSP의 request.getParameter() 메소드와 같은 기능
//  @RequestParam("name 속성값") 형태로 사용 시 클라이언트에서 설정한 input 태그의 name 속성값과 동일한 값으로 설정해야 함
  @RequestMapping("/board/boardDetail.do")
  public ModelAndView boardDetail(@RequestParam("boardIdx") int boardIdx) throws Exception {
    ModelAndView mv = new ModelAndView("board/boardDetail");

//    BoardService 객체가 제공하는 selectBoardDetail() 메소드를 사용하여 DB에서 데이터를 조회하여 가져옴
    BoardDTO board = boardService.selectBoardDetail(boardIdx);
//    ModelAndView 객체에 데이터를 저장
    mv.addObject("board", board);

    return mv;
  }
  
//  글 삭제, UI 없이 Process 부분만 존재함
  @RequestMapping("/board/deleteBoard.do")
  public String deleteBoard(@RequestParam("boardIdx") int boardIdx) throws Exception {
//    BoardService 객체에서 제공하는 deleteBoard() 메소드를 사용하여 DB에서 지정한 데이터를 삭제함
    boardService.deleteBoard(boardIdx);

    return "redirect:/board/openBoardList.do";
  }

//  글 수정, UI 없이 process 부분만 존재함
  @RequestMapping("/board/updateBoard.do")
  public String updateBoard(BoardDTO board) throws Exception {
//    BoardService 객체에서 제공하는 updateBoard() 메소드를 사용하여 DB에서 지정한 데이터를 클라이언에서 전달받은 데이터로 수정
    boardService.updateBoard(board);

    return "redirect:/board/openBoardList.do";
  }
}











