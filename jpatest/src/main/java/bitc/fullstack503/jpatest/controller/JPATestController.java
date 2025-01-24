package bitc.fullstack503.jpatest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JPATestController {

  @GetMapping("/")
  public String index() {
    return "success";
  }
}












