package bitc.fullstack503.board2.configuration;

import bitc.fullstack503.board2.interceptor.LoginCheck;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//  @Configuration : 현재 클래스가 설정 관련 클래스임을 스프링 프레임워크에 알려주는 어노테이션
//  WebMvcConfigurer : 스프링 프레임워크의 웹 설정 정보를 가지고 있는 인터페이스
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

//  사용자가 생성한 인터셉터 클래스를 추가
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
//    addInterceptor() : 사용자가 생성한 인터셉터 클래스 객체를 스프링 프레임워크에 등록
//    addPathPatterns() : 인터셉터가 동작할 주소 패턴 등록
//    excludePathPatterns() : 인터셉터 동작에서 제외할 주소 패턴 등록
    registry.addInterceptor(new LoginCheck())
        .addPathPatterns("/board/**/*")
        .excludePathPatterns("/board/boardList.do")
        .excludePathPatterns("/board/login/login.do")
        .excludePathPatterns("/board/login/loginProcess.do");
  }
}












