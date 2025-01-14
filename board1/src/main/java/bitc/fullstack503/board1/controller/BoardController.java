package bitc.fullstack503.board1.controller;

import bitc.fullstack503.board1.dto.BoardDTO;
import bitc.fullstack503.board1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

  @Autowired
  private BoardService boardService;

  @RequestMapping("/board/openBoardList.do")
  public ModelAndView openBoardList() throws Exception {
    ModelAndView mv = new ModelAndView("board/openBoardList");

    List<BoardDTO> boardList = boardService.selectBoardList();
    mv.addObject("boardList", boardList);

    return mv;
  }

  @RequestMapping("/board/boardDetail.do")
  public void boardDetail(@RequestParam("boardIdx") int boardIdx) throws Exception {
    System.out.println("클라이언트에서 전달받은 데이터 : " + boardIdx);
  }
}











