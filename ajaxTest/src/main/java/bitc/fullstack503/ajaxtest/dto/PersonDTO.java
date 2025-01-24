package bitc.fullstack503.ajaxtest.dto;

import lombok.Data;

@Data
public class PersonDTO {

  private int pNum;
  private String pName;

  public PersonDTO() {}

  public PersonDTO(int pNum, String pName) {
    this.pNum = pNum;
    this.pName = pName;
  }

  @Override
  public String toString() {
    return "PersonDTO [pNum = " + pNum + ", pName = " + pName + "]";
  }
}












