package bitc.fullstack503.xml_json_parser.dto.pharmacy;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

//  @XmlRootElement : xml 데이터에서 부모가 되는 태그를 뜻하는 어노테이션
//  @XmlElement : xml 데이터에서 실제 데이터가 들어있는 태그를 뜻하는 어노테이션
//  @XmlAttribute : xml 데이터에서 지정한 태그의 속성을 뜻하는 어노테이션
//  name : 사용자가 생성한 클래스와 실제 xml 태그의 이름이 다르기 때문에 해당 태그와 데이터를 연동하기 위해서 사용하는 속성, 자바 클래스의 필드명과 xml 태그명이 같을 경우 생략 가능

@XmlRootElement(name = "response")
public class ResponseDTO {

  private HeaderDTO header;
  private BodyDTO body;

  @XmlElement(name = "header")
  public HeaderDTO getHeader() {
    return header;
  }

  public void setHeader(HeaderDTO header) {
    this.header = header;
  }

  @XmlElement(name = "body")
  public BodyDTO getBody() {
    return body;
  }

  public void setBody(BodyDTO body) {
    this.body = body;
  }
}












