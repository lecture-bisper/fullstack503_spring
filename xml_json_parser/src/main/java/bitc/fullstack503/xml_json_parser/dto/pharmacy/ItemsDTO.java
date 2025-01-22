package bitc.fullstack503.xml_json_parser.dto.pharmacy;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "items")
public class ItemsDTO {

  private List<ItemDTO> itemList;

  @XmlElement(name = "item")
  public List<ItemDTO> getItemList() {
    return itemList;
  }

  public void setItemList(List<ItemDTO> itemList) {
    this.itemList = itemList;
  }
}












