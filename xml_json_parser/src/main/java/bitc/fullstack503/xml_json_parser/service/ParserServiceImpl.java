package bitc.fullstack503.xml_json_parser.service;

import bitc.fullstack503.xml_json_parser.dto.kobis.DailyBoxOfficeListDTO;
import bitc.fullstack503.xml_json_parser.dto.kobis.KobisDailyBoxOfficeDTO;
import bitc.fullstack503.xml_json_parser.dto.pharmacy.*;
import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParserServiceImpl implements ParserService {

  @Override
  public List<ItemDTO> getPharmacyItemListFile(String fileName) throws Exception {
//    jaxb : 자바에서 xml 데이터 파싱을 도와주는 라이브러리
//    jaxb 가 자바 9버전부터 기본 라이브러리에서 제외됨

//    Marshal(마샬) : 자바 클래스 타입의 객체를 xml 데이터로 변환
//    UnMarshal(언마샬) : xml 데이터를 자바 클래스 타입의 객체로 변환

//    JAXB 라이브러리 사용 선언
//    미리 생성해 둔 ResponseDTO 클래스 타입으로 xml 데이터를 파싱하도록 설정
    JAXBContext jc = JAXBContext.newInstance(ResponseDTO.class);
//    JAXB 라이브러리를 사용하여 xml 데이터를 자바 클래스 타입의 객체로 변환하는 언마샬 객체 생성
    Unmarshaller um = jc.createUnmarshaller();

//    xml 데이터를 기반으로 ResponseDTO 클래스 타입의 객체를 생성하므로 xml 데이터를 파싱하여 가져온 데이터를 ResponseDTO 클래스 타입의 객체에 타입 변환하여 저장함
//    unmarshal() : 연마샬을 수행하는 메소드, 매개변수로 파일이나 URL을 받음
    ResponseDTO fullData = (ResponseDTO) um.unmarshal(new File(fileName));
//    HeaderDTO header = fullData.getHeader();
//    BodyDTO body = fullData.getBody();
//    ItemsDTO items = body.getItems();
//    List<ItemDTO> itemList = items.getItemList();
    List<ItemDTO> itemList = fullData.getBody().getItems().getItemList();

    return itemList;
  }

  @Override
  public List<ItemDTO> getPharmacyItemListUrl(String serviceUrl) throws Exception {

//    파싱된 데이터 결과가 저장될 List
    List<ItemDTO> itemList = new ArrayList<>();

//    서비스 URL을 저장할 객체
    URL url = null;
//    HttpURLConnection : 자바에서 웹 브라우저 없이 http 서비스에 접속하기 위한 클래스
    HttpURLConnection urlConn = null;

    try {
//      매개변수로 받은 url로 객체 생성
      url = new URL(serviceUrl);
//      지정한 웹 서비스에 접속
      urlConn = (HttpURLConnection) url.openConnection();
//      접속 방식 설정
      urlConn.setRequestMethod("GET");

//      xml 데이터 파싱을 위해서 JAXB 라이브러리 사용
      JAXBContext jc = JAXBContext.newInstance(ResponseDTO.class);
//      xml 데이터를 자바 클래스 타입의 객체로 변환하는 언마샬 객체 생성
      Unmarshaller um = jc.createUnmarshaller();

//      xml 데이터를 자바 클래스 타입으로 변환하는 unmarshal() 메소드 호출 시 매개변수로 접속 URL을 전달함
//      미리 생성한 ResponseDTO 클래스 타입의 객체로 반환
      ResponseDTO fullData = (ResponseDTO) um.unmarshal(url);
//      필요한 데이터만 출력
      itemList = fullData.getBody().getItems().getItemList();
    }
    catch (JAXBException e) {
      e.printStackTrace();
    }
    catch (Exception e) {
      e.printStackTrace();
    }

    return itemList;
  }

  @Override
  public List<DailyBoxOfficeListDTO> getKobisDailyBoxOfficeList(String serviceUrl) throws Exception {

//    출력할 데이터를 저장할 LIST
    List<DailyBoxOfficeListDTO> dailyBoxOfficeList = new ArrayList<>();

    URL url = null;
    HttpURLConnection urlConn = null;
//    웹 서비스에서 전달받은 데이터를 저장할 변수
    BufferedReader reader = null;

    try {
      url = new URL(serviceUrl);
      urlConn = (HttpURLConnection) url.openConnection();
      urlConn.setRequestMethod("GET");

//      JAXB 라이브러리는 클래스 내부에 네트워크 데이터 처리를 위한 부분이 이미 존재함
//      json 파일 라이브러리에는 네트워크 데이터 처리 부분이 없기 때문에 InputStreamReader 를 통해서 네트워크에서 데이터를 가져오는 부분과 가져온 데이터를 처리하는 부분을 사용자가 구현해야 함

//      InputStreamReader 를 사용하여 지정한 URL 의 웹 서비스에서 데이터를 가져옴
//      가져온 데이터를 BufferedReader 객체에 저장
      reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

//      StringBuilder : String 타입의 문자열을 생성하는 클래스
//      일반 String 클래스는 문자열 연결 연산자를 사용하여 여러개의 문자열을 하나로 합할 경우 매번 새로운 메모리 공간을 생성하여 문자열을 합함
//      효율적인 메모리 사용이 불가능함
//      StringBuilder 는 문자열을 연결할 때 하나의 문자열 뒤에 계속 붙여넣는 형태로 동작함
      StringBuilder sb = new StringBuilder();
//      네트워크를 통해서 가져온 데이터를 임시 저장할 변수
      String line;

//      BufferedReader 에 저장된 데이터를 한 줄 읽어오기
//      반복문을 사용하여 더이상 읽을 데이터가 없을 때까지 계속 읽어옴
      while ((line = reader.readLine()) != null) {
//        BufferedReader 에서 읽어온 데이터를 StringBuilder 에 계속 추가함
        sb.append(line);
      }

//      json 을 쉽게 사용하기 위한 Gson 객체 생성
      Gson gson = new Gson();
//      fromJson() : json 문자열을 자바 클래스 타입으로 변환
//      완성된 StringBuilder 의 문자열을 사용하여 KobisDailyBoxOfficeDTO 클래스 타입의 객체로 변환
      KobisDailyBoxOfficeDTO boxOffice = gson.fromJson(sb.toString(), KobisDailyBoxOfficeDTO.class);
//      필요한 데이터만 출력
      dailyBoxOfficeList = boxOffice.getBoxOfficeResult().getDailyBoxOfficeList();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
//      외부 리소스를 사용한 부분을 닫기
      if (reader != null) { reader.close(); }
      if (urlConn != null) { urlConn.disconnect(); }
    }

    return dailyBoxOfficeList;
  }
}












