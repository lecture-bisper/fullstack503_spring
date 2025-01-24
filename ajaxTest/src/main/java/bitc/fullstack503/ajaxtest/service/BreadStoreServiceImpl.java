package bitc.fullstack503.ajaxtest.service;

import bitc.fullstack503.ajaxtest.dto.BreadStoreDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BreadStoreServiceImpl implements BreadStoreService {
  @Override
  public List<BreadStoreDTO> getBreadStores(String areaName) {
    List<BreadStoreDTO> breadStoreList = new ArrayList<BreadStoreDTO>();

    switch (areaName) {
      case "서울":
        BreadStoreDTO se1 = new BreadStoreDTO();
        BreadStoreDTO se2 = new BreadStoreDTO();
        BreadStoreDTO se3 = new BreadStoreDTO();
        BreadStoreDTO se4 = new BreadStoreDTO();

        se1.setStoreName("김영모 과자점");
        se1.setBreadName("프렌치 바게트");

        se2.setStoreName("리치몬드 과자점");
        se2.setBreadName("크로와상");

        se3.setStoreName("태극당");
        se3.setBreadName("단팥빵");

        se4.setStoreName("나폴레옹 과자점");
        se4.setBreadName("크림이 가득한 나폴레옹 케이크");

        breadStoreList.add(se1);
        breadStoreList.add(se2);
        breadStoreList.add(se3);
        breadStoreList.add(se4);
        break;

      case "대전":
        BreadStoreDTO dj1 = new BreadStoreDTO();
        BreadStoreDTO dj2 = new BreadStoreDTO();
        BreadStoreDTO dj3 = new BreadStoreDTO();
        BreadStoreDTO dj4 = new BreadStoreDTO();

        dj1.setStoreName("성심당");
        dj1.setBreadName("튀김소보로");

        dj2.setStoreName("베이커리 하모니");
        dj2.setBreadName("하드계열빵");

        dj3.setStoreName("화이트리에");
        dj3.setBreadName("식빵");

        dj4.setStoreName("더 베이커");
        dj4.setBreadName("감자치즈빵");

        breadStoreList.add(dj1);
        breadStoreList.add(dj2);
        breadStoreList.add(dj3);
        breadStoreList.add(dj4);
        break;

      case "부산":
        BreadStoreDTO bs1 = new BreadStoreDTO();
        BreadStoreDTO bs2 = new BreadStoreDTO();
        BreadStoreDTO bs3 = new BreadStoreDTO();
        BreadStoreDTO bs4 = new BreadStoreDTO();

        bs1.setStoreName("옵스 (OPS)");
        bs1.setBreadName("단팥빵");

        bs2.setStoreName("베이크백");
        bs2.setBreadName("크림치즈빵");

        bs3.setStoreName("허대빵");
        bs3.setBreadName("두부초콜릿 패스트리");

        bs4.setStoreName("초량온당");
        bs4.setBreadName("소금빵");

        breadStoreList.add(bs1);
        breadStoreList.add(bs2);
        breadStoreList.add(bs3);
        breadStoreList.add(bs4);
        break;
    }

    return breadStoreList;
  }
}












