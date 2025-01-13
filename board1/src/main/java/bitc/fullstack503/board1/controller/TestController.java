package bitc.fullstack503.board1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// controller 패키지 : 클라이언트의 요청에 응답하기 위한 컨트롤러 클래스가 위치하는 패키지
// service 패키지 : 실제 내부 연산을 진행하는 클래스가 위치하는 패키지
// dto 패키지 : 데이터베이스 테이블과 연동되는 클래스가 위치하는 패키지
// mapper 패키지 : 데이터베이스와 연결하여 쿼리문을 전달하기 위한 인터페이스가 위치하는 패키지
// configuration 패키지 : 각종 설정 정보를 입력하는 클래스가 위치하는 패키지

// resources 폴더 : 스프링부트에서 사용하는 리소스가 위치하는 폴더
// static 폴더 : 정적 리소스가 위치하는 폴더 (css, js, images, movie 등)
// templates 폴더 : View (html) 파일이 위치하는 폴더

// application.properties : 현재 프로젝트 설정 정보를 입력하는 설정 파일

@Controller
public class TestController {

  @RequestMapping("/")
  public String index() {
    return "index";
  }
}












