package bitc.fullstack503.outsidedir.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//  application.properties 파일에 입력된 설정 내용을 가져와서 사용
  @Value("${resources.img.location}")
  private String imgLocation;

  @Value("${resources.img-cat.location}")
  private String catLocation;

  @Value("${resources.img-dog.location}")
  private String dogLocation;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    외부 폴더는 원하는 만큼 계속 추가 가능함
//    addResourceHandler(경로) : 스프링 프레임워크 외부에 있는 폴더를 스프링 프레임워크 안에 있는 폴더인 것으로 인식 시킴, 매개변수로 내부에서 사용할 경로(패턴 방식)를 입력
//    addResourceLocations(경로) : 실제 디스크의 외부 폴더 경로를 입력
//    mac, linux 는 'file://경로명', windows 는 'file:///경로명' 형태로 입력
//    외부 경로의 마지막에 '/' 반드시 입력

//    registry
//        .addResourceHandler("/imgs/**")
//        .addResourceLocations("file:///C:/fullstack503/img/");
//    registry.addResourceHandler("/movie/**")
//        .addResourceLocations("file:///C:/fullstack503/movie/");

    String path1 = "file:///" + imgLocation;
    String path2 = "file:///" + catLocation;
    String path3 = "file:///" + dogLocation;

//    지정한 외부 폴더 1개를 하나의 스프링의 내부 폴더로 등록
    registry.addResourceHandler("/imgs/**")
        .addResourceLocations(path1);

//    지정한 외부 폴더 2개를 하나의 스프링 내부 폴더로 등록
    registry.addResourceHandler("/animals/**")
        .addResourceLocations(path2, path3);
  }
}












