package bitc.fullstack503.ajaxtest.controller;

import bitc.fullstack503.ajaxtest.dto.PersonDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GsonController {

  private void basicUse() {
//    Gson 객체 생성
    Gson gson = new Gson();

//    자바에서 Json 객체 생성
    JsonObject jsonObj = new JsonObject();
//    addProperty(key, value) : 생성된 json 객체에 데이터를 추가하는 메소드
//    json 이 자바스크립트의 object 타입과 비슷한 형태이므로 key와 value 가 1:1 연동 됨
//    자바의 HashMap과 비슷함
    jsonObj.addProperty("name", "아이유");
    jsonObj.addProperty("id", 1);

//    toJson(json객체) : Json 객체를 json 문자열로 변환 시 사용하는 메소드
//    gson의 toJson() 메소드를 사용하여 json 객체를 json 문자열로 변환
    String jsonStr = gson.toJson(jsonObj);

    System.out.println("jsonStr : " + jsonStr);
  }

//  자바 object => json 문자열
  private void javaObjc2Json() {
//    자바 클래스로 객체 생성
    PersonDTO p = new PersonDTO(1, "아이유");

    Gson gson = new Gson();
//    gson의 toJson() 메소드를 사용하여 자바 객체를 json 문자열로 변환
    String jsonStr = gson.toJson(p);

    System.out.println("jsonStr : " + jsonStr);
  }

//  json 문자열 => 자바 Object
  private void json2JavaObj() {
//    json 문자열을 자바의 String 타입으로 구현
    String jsonStr = "{\"pNum\" : 1, \"pName\" : \"아이유\"}";

    Gson gson = new Gson();
//    gson의 fromJson() 메소드를 사용하여 json 문자열을 지정한 자바 클래스 타입의 객체로 변환
//    첫번째 매개변수 : json 문자열을 설정
//    두번째 매개변수 : 자바 클래스로 변환할 자바 클래스 타입을 설정
    PersonDTO p = gson.fromJson(jsonStr, PersonDTO.class);

    System.out.print("p : ");
    System.out.print(p);
    System.out.println();
    System.out.println(p.getPNum());
    System.out.println(p.getPName());
  }

//  HashMap => Json 문자열
  private void map2Json() {
//    Map 타입 객체 생성
    Map<String, String> map = new HashMap<>();
    map.put("pNum", "1");
    map.put("pName", "아이유");

    Gson gson = new Gson();
//    gson 에서 제공하는 toJson() 메소드로 json 문자열로 변환
    String jsonStr = gson.toJson(map);

    System.out.println("jsonStr : " + jsonStr);
  }

//  json 문자열 => HashMap 
  private void json2Map() {
    String jsonStr = "{\"pNum\": 1, \"pName\": \"아이유\"}";

    Gson gson = new Gson();
//    gson 에서 제공하는 fromJson() 메소드를 사용하여 json 문자열을 Map 타입으로 변환
    Map<String, Object> map = gson.fromJson(jsonStr, Map.class);

    System.out.println("pNum : " + map.get("pNum"));
    System.out.println("pName : " + map.get("pName"));
  }

  @GetMapping("/gson")
  public String gson() {
//    Gson : json 데이터를 파싱하고 생성하기 위해 구글이 개발한 라이브러리
//    java 객체를 json 문자열로 변환하고, json 문자열을 java 객체로 변환할 때 사용

//    Gson 객체 생성
//    1. new 키워드 사용 (일반적인 객체 생성 방식)
//    Gson gson = new Gson();

//    2. Builder 패턴 사용
//    Gson gson = new GsonBuilder().create();

    basicUse();
    javaObjc2Json();
    json2JavaObj();
    map2Json();
    json2Map();

    return "Gson 테스트 하기";
  }


}












