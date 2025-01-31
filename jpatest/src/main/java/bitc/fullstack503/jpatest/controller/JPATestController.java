package bitc.fullstack503.jpatest.controller;

import bitc.fullstack503.jpatest.data.entity.ProductEntity;
import bitc.fullstack503.jpatest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JPATestController {

  @Autowired
  private ProductService productService;

  @GetMapping("/")
  public String index() throws Exception {
    productService.finds();
    productService.exists();
    productService.count();
    productService.delete();
    productService.limit();
    productService.equals();
    productService.isNot();
    productService.isNull();
    productService.isNotNull();
    productService.and();
    productService.or();
    productService.between();
    productService.like();
    productService.orderBy();

    return "success";
  }

  @GetMapping("/query")
  public String query() throws Exception {

    productService.querySelectAll();
    productService.querySelectName();
    productService.querySelectNameAndPrice("칠성 사이다", 2200);
    productService.querySelectNameAndPrice(2200, "칠성 사이다 제로");

    return "@Query 사용";
  }
}












