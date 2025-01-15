package bitc.fullstack503.board1.controller;

import bitc.fullstack503.board1.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

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

  @RequestMapping("/thymeleaf/study03")
  public ModelAndView study03() {
    ModelAndView mv = new ModelAndView("thymeleaf/study03");

//    ModelAndView 클래스 타입의 객체에 문자열 데이터 추가
    mv.addObject("str1", "첫번째");
    mv.addObject("str2", "두번째");
//    ModelAndView 클래스 타입의 객체에 null 을 추가
    mv.addObject("str3", null);

//    Model에 정수 데이터 추가
    mv.addObject("num1", 100);
    mv.addObject("num2", 200);
    mv.addObject("num3", 11);

    return mv;
  }

  @RequestMapping("/thymeleaf/study04")
  public ModelAndView study04() {
    ModelAndView mv = new ModelAndView("thymeleaf/study04");

//    Model에 정수 데이터 저장
    mv.addObject("num", 11);

//    Model에 null 을 저장
    mv.addObject("nullData", null);

//    Model에 문자열 데이터 저장
    mv.addObject("grade", "adaskljh");

    String[] strArray = {"첫번째", "두번째", "세번째", "네번째", "다섯번째"};
    List<String> strList = new ArrayList<String>();
    strList.add("첫번째");
    strList.add("두번째");
    strList.add("세번째");
    strList.add("네번째");
    strList.add("다섯번째");

//    Model에 array 데이터와 list 데이터를 추가
    mv.addObject("itemArray", strArray);
    mv.addObject("itemList", strList);

//    MemberDTO 클래스 타입의 객체 생성
    MemberDTO member1 = new MemberDTO();
    member1.setId("iu");
    member1.setName("아이유");
    member1.setPass("1234");
    member1.setRegidate("2025-01-15 12:06:00");

    MemberDTO member2 = new MemberDTO();
    member2.setId("inna");
    member2.setName("유인나");
    member2.setPass("1234");
    member2.setRegidate("2025-01-15 12:07:00");

    MemberDTO member3 = new MemberDTO();
    member3.setId("je");
    member3.setName("유재석");
    member3.setPass("1234");
    member3.setRegidate("2025-01-15 12:08:00");

//    List 에 MemberDTO 객체 저장
    List<MemberDTO> memberList = new ArrayList<>();
    memberList.add(member1);
    memberList.add(member2);
    memberList.add(member3);
    
//    Model 에 ArrayList 데이터 저장
    mv.addObject("memberList", memberList);

    return mv;
  }

//  반환타입을 String으로 설정하여 실제로 반환하는 데이터는 View 파일의 경로를 반환
//  매개변수로 Model 인터페이스를 받아서 View 파일에 전달할 데이터를 저장
//  ModelAndView 를 사용하는 것과 동일함
  @RequestMapping("/thymeleaf/study05")
  public String study05(Model model) {

//    addAttribute() : ModelAndView에 데이터를 저장하는 addObject()와 동일한 역할하는 메소드
    model.addAttribute("checkedVal", true);
    model.addAttribute("multipleVal", true);
    model.addAttribute("selectedVal", true);
    model.addAttribute("disabledVal", false);
    model.addAttribute("readonlyVal", false);

    return "thymeleaf/study05";
  }

  @RequestMapping("/thymeleaf/study06")
  public String study06() {
    return "thymeleaf/study06";
  }
}












