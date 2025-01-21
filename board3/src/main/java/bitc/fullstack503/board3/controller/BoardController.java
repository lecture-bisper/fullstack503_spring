package bitc.fullstack503.board3.controller;

import bitc.fullstack503.board3.dto.BoardDTO;
import bitc.fullstack503.board3.service.BoardService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//  RESTful 이란 : URL을 리소스의 이름으로 구분하여 해당 리소스의 정보를 주고 받는 방식
//  HTTP URI 를 통해서 리소스를 명시하고, HTTP Method(GET, POST, PUT, DELETE)를 통해 리소스에 대한 CRUD 명령을 적용하는 방식

//  URI : Uniform Resource Identifier 의 줄임말, 자원 식별자
//  URL : Uniform Resource Locator 의 줄임말, 자원의 위치
//  현재는 거의 같은 의미로 사용됨

//  RESTful 방식은 데이터를 전송하는 방법을 지정하여 사용
//  HttpMethod를 사용하여 GET(조회, select), POST(입력, insert), PUT(수정, update), DELETE(삭제, delete) 로 구분해서 사용함

//  전체 URL 설정 방법
//  서버URL:포트번호/기본주소/추가주소/게시물번호

//  게시물 목록 : /board/boardList.do          =>  /board            GET
//  게시물 작성 화면 : /board/boardWrite.do    =>  /board/write      GET
//  게시물 작성 처리 : /board/boardInsert.do   =>  /board/write      POST
//  게시물 상세 화면 : /board/boardDetail.do   =>  /board/게시물번호  GET
//  게시물 수정 : /board/boardUpdate.do        =>  /board/게시물번호  PUT
//  게시물 삭제 : /board/boardDelete.do        =>  /board/게시물번호  DELETE

//  @RequestMapping 어노테이션 사용 시 URI를 value 속성을 사용하여 설정, method 속성을 사용하여 GET, POST, PUT, DELETE 를 설정
//  @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 어노테이션을 제공하고 있음

//  주의사항

//  Spring Framework 의 기본 설정은 GET, POST 방식만 인식함
//  어플리케이션 설정 파일인 application.properties 파일에 spring.mvc.hiddenmethod.filter.enabled=true 가 추가되어야 GET, POST, PUT, DELETE 를 다 사용할 수 있음

//  HTML 에서는 기본적으로 GET, POST 방식만 인식하기 때문에 Spring Framework에서 PUT, DELETE 방식을 인식하기 위해서 input 태그에 type=hidden 으로 설정하고, name 속성에 name=_method 로 설정하여 데이터 전송 방식을 지정해야 함

@Controller
public class BoardController {

  @Autowired
  private BoardService boardService;

  @RequestMapping({"/", ""})
  public String index() {
    return "index";
  }

//  게시물 목록
//  기존의 @RequestMapping 사용방법에서 URI 를 입력했던 부분을 value 속성으로 변경
//  해당 URI와 통신하는 방식을 method 속성을 통해서 지정할 수 있음
  @RequestMapping(value = "/board", method = RequestMethod.GET)
  public ModelAndView selectBoardList() throws Exception {
    ModelAndView mav = new ModelAndView("board/boardList");

    List<BoardDTO> boardList = boardService.selectBoardList();
    mav.addObject("boardList", boardList);

    return mav;
  }

//  @PathVariable : @RequestParam 과 동일한 역할을 하는 어노테이션, REST 방식 사용 시 URI 에 {} 로 지정해 놓은 리소스 값을 받아오는 어노테이션
//  게시물 상세
  @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.GET)
  public ModelAndView selectBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
    ModelAndView mav = new ModelAndView("board/boardDetail");

    BoardDTO board = boardService.selectBoardDetail(boardIdx);
    mav.addObject("board", board);

    return mav;
  }

//  @GetMapping : 클라이언트에서 데이터 전송 방식을 GET 으로 설정한 URL만 접속
//  @RequestMapping(method = RequestMethod.GET) 과 동일한 방식
//  게시물 등록 화면
  @GetMapping("/board/write")
  public String insertBoard() {
    return "board/boardWrite";
  }

//  클라이언트가 접근하는 URL이 동일하더라도 method 타입이 다르면 서로 다른 URL로 인식하기 때문에 동일한 URL을 사용할 수 있음

//  @PostMapping : 클라이언트에서 데이터 전송 방식을 POST 로 설정한 URL만 접속
//  @RequestMapping(method = RequestMethod.POST) 과 동일한 방식
//  게시물 등록 처리
  @PostMapping("/board/write")
  public String insertBoard(BoardDTO board) throws Exception {
    boardService.insertBoard(board);

    return "redirect:/board";
  }

//  @PutMapping : 클라이언트에서 데이터 전송 방식을 PUT 로 설정한 URL만 접속
//  @RequestMapping(method = RequestMethod.PUT) 과 동일한 방식
//  게시물 수정
  @PutMapping("/board/{boardIdx}")
  public String updateBoard(BoardDTO board) throws Exception {
    boardService.updateBoard(board);

    return "redirect:/board";
  }

//  @DeleteMapping : 클라이언트에서 데이터 전송 방식을 DELETE 로 설정한 URL만 접속
//  @RequestMapping(method = RequestMethod.DELETE) 과 동일한 방식
//  게시물 삭제
  @DeleteMapping("/board/{boardIdx}")
  public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
    boardService.deleteBoard(boardIdx);

    return "redirect:/board";
  }
}












