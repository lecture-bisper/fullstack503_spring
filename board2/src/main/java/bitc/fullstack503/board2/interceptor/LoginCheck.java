package bitc.fullstack503.board2.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

//  Interceptor 을 사용하기 위해서 HandlerInterceptor 인터페이스를 상속받아 구현함
//  preHandle() : 요청한 컨트롤러가 동작하기 이전에 먼저 수행됨
//  postHandle() : 요청한 컨트롤러 동작 후 View 페이지가 동작하기 이전에 수행됨
//  afterCompletion() : 요청한 모든 동작이 완료된 후 수행됨
public class LoginCheck implements HandlerInterceptor {

  
  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

//    HttpServletRequest 에서 제공하는 getSession() 메소드를 사용하여 세션 정보 가져옴
    HttpSession session = req.getSession();

    System.out.println("\n ===================== Interceptor 동작 ===================\n");

//    세션 정보가 있는지 확인
    if (session.getAttribute("userId") == null) {
//      세션 정보가 없을 경우
      System.out.println("\n---------- interceptor ----------\n");
      System.out.println("비 로그인 상태");
      System.out.println("User ID : 없음");

//      로그인 페이지로 리다이렉트
      res.sendRedirect("/board/login/login.do");
//      필터 통과 실패
      return false;
    }
    else {
//      세션 정보가 있을 경우
      System.out.println("\n---------- interceptor ----------\n");
      System.out.println("로그인 상태");
      System.out.println("User ID : " + (String) session.getAttribute("userId"));

//      세션 사용 시간 설정 다시 해줌
      session.setMaxInactiveInterval(60 * 60 * 1);

//      필터 통과 성공
      return true;
    }
  }
}












