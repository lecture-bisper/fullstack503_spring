package bitc.fullstack503.board2.controller;

import bitc.fullstack503.board2.dto.UserDTO;
import bitc.fullstack503.board2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

// 로그인 및 회원 가입을 위한 컨트롤러 클래스
@Controller
// 기본 주소 설정
@RequestMapping("/board/login")
public class LoginController {

  @Autowired
  private UserService userService;

//  로그인 페이지 (단순 View)
  @RequestMapping("/login.do")
  public String login() {
    return "login/login";
  }

//  로그인 처리,, 매개변수로 사용자ID/비밀번호를 받음
//  로그인 처리 시 세션 정보가 필요하기 때문에 HttpServletRequest 를 매개변수로 받아옴
  @RequestMapping("/loginProcess.do")
  public String loginProcess(@RequestParam("userId") String userId, @RequestParam("userPw") String userPw, HttpServletRequest request) throws Exception {

//    userService에서 제공하는 isUserInfo() 메소드를 사용하여 사용자가 입력한 id/pw를 사용하는 사용자 정보가 존재하는지 확인
    boolean result = userService.isUserInfo(userId, userPw);
    
    if (result == true) {
//      해당 id/pw를 사용하는 사용자가 있으면 해당 사용자의 정보를 userService 에서 제공하는 getuserInfo() 메소드를 사용하여 가져옴
      UserDTO user = userService.getUserInfo(userId);

//      HttpServletRequest에서 제공하는 getSession() 메소드를 사용하여 세션 객체를 가져옴
      HttpSession session = request.getSession();
//      세션에 데이터 추가
      session.setAttribute("userId", user.getUserId());
      session.setAttribute("userName", user.getUserName());
      session.setAttribute("userEmail", user.getUserEmail());
//      세션 유지 시간 설정
      session.setMaxInactiveInterval(60 * 60 * 1);

//      리다이렉트로 페이지 이동
      return "redirect:/board/boardList.do";
    }
    else {
//      해당 id/pw를 사용하는 사용자가 없을 경우 로그인 페이지로 이동
      return "redirect:/board/login/login.do?errMsg=" + URLEncoder.encode("로그인 정보가 다릅니다.", "UTF-8");
    }
  }

//  로그아웃 처리, 세션에 저장된 모든 내용을 삭제하면 로그아웃
//  세션 정보를 가져와야 하기 때문에 HttpServletRequest 를 매개변수로 받아옴
  @RequestMapping("/logout.do")
  public String logout(HttpServletRequest request) {

//    HttpServletRequest 에서 제공하는 getSession() 메소드를 사용하여 세션 정보를 가져옴
    HttpSession session = request.getSession();

//    세션에 저장된 내용을 삭제
    session.removeAttribute("userId");
    session.removeAttribute("userName");
    session.removeAttribute("userEmail");

//    세션에 저장된 모든 정보를 삭제
    session.invalidate();

//    리다이렉트로 페이지 이동
    return "redirect:/board/boardList.do";
  }
}












