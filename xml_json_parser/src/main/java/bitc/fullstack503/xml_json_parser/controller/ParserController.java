package bitc.fullstack503.xml_json_parser.controller;

import bitc.fullstack503.xml_json_parser.dto.kobis.DailyBoxOfficeListDTO;
import bitc.fullstack503.xml_json_parser.dto.pharmacy.*;
import bitc.fullstack503.xml_json_parser.service.ParserService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/parser")
public class ParserController {

//  application.properties 파일에 입력된 내용 가져오기
  @Value("${fullstack503.pharmacy.service.fullData.url}")
  private String pharmacyFullDataUrl;

  @Value("${fullstack503.pharmacy.service.userKey}")
  private String pharmacyUserKey;

  @Value("${fullstack503.kobis.service.dailyBoxOffice.url}")
  private String kobisDailyBoxOfficeUrl;

  @Value("${fullstack503.kobis.service.userKey}")
  private String kobisUserKey;

  @Autowired
  private ParserService parserService;

  @RequestMapping({"", "/"})
  public String index() {
    return "index";
  }

  @GetMapping("/pharmacy/fullDataFile")
  public ModelAndView fullDataFile() throws Exception {
    ModelAndView mav = new ModelAndView("pharmacy/fullDataFile");

    List<ItemDTO> itemList = parserService.getPharmacyItemListFile("c:\\fullstack503\\pharmacy.xml");
    mav.addObject("itemList", itemList);

    return mav;
  }

  @GetMapping("/pharmacy/fullDataUrl")
  public ModelAndView fullDataUrl(@RequestParam("pageNo") String pageNo, @RequestParam("numOfRows") String numOfRows) throws Exception {

    ModelAndView mav = new ModelAndView("pharmacy/fullDataUrl");

    String serviceKey = "?serviceKey=";
    String opt1 = "&pageNo=";
    String opt2 = "&numOfRows=";

    String url = pharmacyFullDataUrl + serviceKey + pharmacyUserKey + opt1 + pageNo + opt2 + numOfRows;

    List<ItemDTO> itemList = parserService.getPharmacyItemListUrl(url);
    mav.addObject("itemList", itemList);

    return mav;
  }

  @GetMapping("/kobis/dailyBoxOffice")
  public String kobisDailyBoxOffice() throws Exception {
    return "kobis/dailyBoxOffice";
  }

  @GetMapping("/kobis/dailyBoxOfficeJson")
  public ModelAndView dailyBoxOffice(@RequestParam("targetDt") String targetDt) throws Exception {
    ModelAndView mav = new ModelAndView("kobis/dailyBoxOfficeJson");

    String serviceKey = "?key=";
    String opt1 = "&targetDt=";

    String url = kobisDailyBoxOfficeUrl + serviceKey + kobisUserKey + opt1 + targetDt;

    List<DailyBoxOfficeListDTO> boxOfficeList = parserService.getKobisDailyBoxOfficeList(url);
    mav.addObject("boxOfficeList", boxOfficeList);

    return mav;
  }
}












