package bitc.fullstack503.board1.controller;

import bitc.fullstack503.board1.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {

  @RequestMapping({"/thymeleaf", "/thymeleaf/"})
  public String thymeleaf() {
//    해당 클래스에 @Controller 어노테이션을 사용하고, 멤버 메소드에 @RequestMapping 어노테이션을 통해서 클라이언트가 접속할 URI를 설정하였을 경우, 지정한 메소드의 반환 타입이 String 타입이면, View 파일의 경로를 의미함
//    클라이언트에게 지정한 View 파일을 전달함
    return "thymeleaf/index";
  }

//  @RequestMapping : 클라이언트가 서버로 접속할 경우 사용하는 URI과 서버의 메소드와 연동시켜주는 어노테이션
  @RequestMapping("/thymeleaf/study01")
  public ModelAndView study01() {
//    ModelAndView : 스프링 프레임워크에서 제공하는 클래스로 데이터와 뷰 파일이 함께 포함된 클래스
//    해당 클래스의 객체를 반환하면 지정한 view 파일(html 파일)을 데이터와 함께 클라이언트에게 전달함
    ModelAndView mv = new ModelAndView("thymeleaf/study01");

//    view 파일에 데이터 전달하기
//    addObject(이름, 데이터) : ModelAndView 클래스 타입의 객체에 데이터를 추가하는 명령
//    jsp의 request.setAttribute() 와 동일한 기능
    mv.addObject("value01", "안녕하세요");
    mv.addObject("value02", 100);
    mv.addObject("value03", 200);
    mv.addObject("utext", "문자열과 <strong>html 태그</strong>가 혼합된 문자열");
    mv.addObject("idx", 5);

    return mv;
  }

  @RequestMapping("thymeleaf/study02")
  public ModelAndView study02() {
    ModelAndView mv = new ModelAndView("thymeleaf/study02");

    MemberDTO member = new MemberDTO();
    member.setId("ui");
    member.setName("아이유");
    member.setPass("1234");
    member.setRegidate("2024.6.76");

    mv.addObject("member", member);

    mv.addObject("str1", "첫번째");
    mv.addObject("str2", "두번째");
    mv.addObject("str3", null);

    return mv;
  }
}












