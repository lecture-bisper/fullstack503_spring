package bitc.fullstack503.ajaxtest.controller;

import bitc.fullstack503.ajaxtest.dto.BreadStoreDTO;
import bitc.fullstack503.ajaxtest.service.BreadStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AjaxController {

  @RequestMapping("/")
  public String index() {
    return "index";
  }

//  ajax 미사용 시 사용자 입력을 받기 위한 View
  @RequestMapping("/ajax/nonAjaxCalcView")
  public String nonAjaxCalcView() {
    return "ajax/nonAjaxCalcView";
  }

//  ajax 미사용 시 실제 연산이 발생
  @RequestMapping("/ajax/nonAjaxCalcResult")
  public ModelAndView nonAjaxCalcResult(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
    ModelAndView mv = new ModelAndView("ajax/nonAjaxCalcResult");

    int result = num1 + num2;
    mv.addObject("result", result);
    mv.addObject("num1", num1);
    mv.addObject("num2", num2);

    return mv;
  }

  @RequestMapping("/ajax/ajaxCalcView")
  public String ajaxCalcView() {
    return "ajax/ajaxCalcView";
  }

  @ResponseBody
  @RequestMapping("/ajax/ajaxCalcResult")
  public Object ajaxCalcResult(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {

    int result = num1 + num2;

    Map<String, String> mapResult = new HashMap<>();
    mapResult.put("result", "success");
    mapResult.put("value", String.valueOf(result));

    return mapResult;
  }

  @Autowired
  private BreadStoreService breadStoreService;

  @GetMapping("/ajax/selectBox")
  public String selectBox() {
    return "ajax/selectBox";
  }

//  @ResponseBody : 응답으로 클라이언트에게 전달할 데이터를 html 템플릿이 아닌 데이터 자체를 전달하도록 하는 어노테이션, ajax 통신 시 필수
//  @Controller 어노테이션을 사용했을 경우 지정한 메소드에 설정
//  만약 @RestController 어노테이션을 사용했을 경우 @ResponseBody 가 이미 포함되어 있으므로 @ResponseBody 는 생략

//  스프링 프레임워크에서는 ajax 통신 시 자동으로 데이터타입을 json으로 변환해서 전달
//  반환 타입을 Object 라고 입력해도 상관없음
//  정식 방식은 json 라이브러리를 사용하여 json 문자열로 변환하여 전달
  @ResponseBody
  @PostMapping("/ajax/selectBox")
  public Object selectBox1(@RequestParam("areaName") String areaName) {
//    서비스를 사용하여 내부 연산을 진행하고 그 결과만 받아옴
    List<BreadStoreDTO> breadStoreList = breadStoreService.getBreadStores(areaName);

//    서비스에서 받아온 결과를 데이터만 클라이언트에게 전달, ajax 통신 시 ajax 의 success 속성에 설정되어 있는 콜백함수의 매개변수로 데이터가 전달됨


//    가져온 데이터를 검증하고 클라이언트로 전달할 데이터 객체를 생성
//    Map<String, Object> result = new HashMap<>();
//
//    if (breadStoreList.size() > 0) {
//      result.put("result", "success");
//      result.put("data", breadStoreList);
//    }
//    else {
//      result.put("result", "error");
//    }

    return breadStoreList;
  }
}












