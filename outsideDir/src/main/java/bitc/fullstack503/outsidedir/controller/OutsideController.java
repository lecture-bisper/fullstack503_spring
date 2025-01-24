package bitc.fullstack503.outsidedir.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@EnableScheduling
@Controller
public class OutsideController {

  @GetMapping("/")
  public String index() {
    return "index";
  }

  @GetMapping("/outside/imgLoad")
  public String imgLoad() {
    return "outside/imgLoad";
  }
}












