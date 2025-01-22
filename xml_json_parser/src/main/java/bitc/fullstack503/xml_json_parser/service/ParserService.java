package bitc.fullstack503.xml_json_parser.service;

import bitc.fullstack503.xml_json_parser.dto.kobis.DailyBoxOfficeListDTO;
import bitc.fullstack503.xml_json_parser.dto.pharmacy.ItemDTO;

import java.util.List;

public interface ParserService {

  List<ItemDTO> getPharmacyItemListFile(String fileName) throws Exception;

  List<ItemDTO> getPharmacyItemListUrl(String serviceUrl) throws Exception;

  List<DailyBoxOfficeListDTO> getKobisDailyBoxOfficeList(String serviceUrl) throws Exception;
}












