package bitc.fullstack503.jpaboardtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaBoardController {
  
  @GetMapping("/")
  public String index() {
    return "index 페이지";
  }
}












