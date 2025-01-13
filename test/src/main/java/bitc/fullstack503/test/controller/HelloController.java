package bitc.fullstack503.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 어노테이션 : 컴파일러에게 특정 기능을 수행하도록 지시하는 문장
// 컴파일러에게 특정 기능을 확인하도록 하는 명령

// @RestController : 해당 클래스가 클라이언트의 request 요청을 받는 클래스라는 것을 의미
// 주로 @Controller, @RestController 2가지가 사용 됨
@RestController
public class HelloController {

//  @RequestMapping : 클라이언트가 서버에 접속하기 위한 URL을 지정한 클래스 및 메소드와 연동하는 어노테이션
//  연결 방식에 따라서 @RequestMapping, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 이 존재함
  @RequestMapping("/hello")
  public String hello() {
    return "Hello World";
  }

  @RequestMapping("/test")
  public String test() {
    return "test 페이지";
  }
}












