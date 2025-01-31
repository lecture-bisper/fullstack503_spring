package bitc.fullstack503.jpatest.service;

import bitc.fullstack503.jpatest.data.entity.ProductEntity;
import bitc.fullstack503.jpatest.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public void finds() throws Exception {
    System.out.println("\n ----- finds() 쿼리 메소드 실행 ----- /n");

//    JpaRepository 에서 제공하는 기본 메소드를 사용
    Optional<ProductEntity> prod1 = productRepository.findById((long) 1);
    System.out.println(prod1.get().getName());
    System.out.println(prod1.get().getPrice());

    System.out.println("\n쿼리 메소드 findByNumber() 호출");
    Optional<ProductEntity> prod2 = productRepository.findByNumber((long) 1);
    Optional<ProductEntity> prod3 = productRepository.findProductEntityByNumber((long) 1);
    Optional<List<ProductEntity>> prod4 = productRepository.findAllByName("팹시콜라");
    ProductEntity prod5 = productRepository.queryByName("칠성 사이다");

    if (prod2.isPresent()) {
      ProductEntity prod = prod2.get();
      System.out.println("상품 번호 : " + prod.getNumber());
      System.out.println("상품 이름 : " + prod.getName());
      System.out.println("상품 가격 : " + prod.getPrice());
      System.out.println("재고 수량 : " + prod.getStock());
      System.out.println("등록 날짜 : " + prod.getCreatedAt());
    }
    else {
      System.out.println("데이터 없음");
    }

    System.out.println("\n ----- finds() 쿼리 메소드 실행 완료 -----\n");
  }

  @Override
  public void exists() throws Exception {
    System.out.println("\n ----- exists() 쿼리 메소드 실행 -----\n");

    boolean isProductNumber = productRepository.existsByNumber((long) 3);
    System.out.println("지정한 상품 번호 존재 여부 : " + isProductNumber);

    System.out.println("\n ----- exists() 쿼리 메소드 실행 완료 -----\n");
  }

  @Override
  public void count() throws Exception {
    System.out.println("\n ----- count() 쿼리 메소드 실행 ----- \n");

    int count = productRepository.countByName("팹시콜라 제로");
    System.out.println("지정한 상품의 수 : " + count);

    System.out.println("\n ----- count() 쿼리 메소드 실행 완료 ----- \n");
  }

  @Transactional
  @Override
  public void delete() throws Exception {
    System.out.println("\n ----- delete()쿼리 메소드 실행 ----- \n");

//    productRepository.deleteById((long) 1);
    int count = productRepository.removeByName("칠성 사이다");
    System.out.println("지정한 상품 삭제 수 : " + count);

    System.out.println("\n ----- delete()쿼리 메소드 실행 완료 ----- \n");
  }

  @Override
  public void limit() throws Exception {

  }

  @Override
  public void equals() throws Exception {

  }

  @Override
  public void isNot() throws Exception {

  }

  @Override
  public void isNull() throws Exception {

  }

  @Override
  public void isNotNull() throws Exception {

  }

  @Override
  public void and() throws Exception {
    System.out.println("\n ----- and() 쿼리 메소드 호출 ----- \n");

    ProductEntity prod1 = productRepository.findByNumberAndName((long)3, "팹시콜라");
    ProductEntity prod2 = productRepository.findByNumberAndName((long)10, "팹시콜라");

    if (prod1 != null) {
      System.out.println(prod1.getName());
    }
    else {
      System.out.println("prod1 에 데이터 없음");
    }

    if (prod2 != null) {
      System.out.println(prod2.getName());
    }
    else {
      System.out.println("prod2 에 데이터 없음");
    }

    System.out.println("\n ----- and() 쿼리 메소드 호출 완료 ----- \n");
  }

  @Override
  public void or() throws Exception {

    System.out.println("\n ----- or() 쿼리 메소드 호출 ----- \n");

    List<ProductEntity> prod1 = productRepository.findByNumberOrName((long) 2, "팹시콜라 제로");

    if (prod1 != null) {
      for (ProductEntity prod : prod1) {
        System.out.println(prod.getName());
      }
    }
    else {
      System.out.println("데이터 없음");
    }

    System.out.println("\n ----- or() 쿼리 메소드 호출 ----- \n");
  }

  @Override
  public void between() throws Exception {

  }

  @Override
  public void like() throws Exception {

  }

  @Override
  public void orderBy() throws Exception {

  }

  @Override
  public void querySelectAll() throws Exception {
    System.out.println("\n ----- @Query 사용, querySelectAll() 호출 -----\n");

    List<ProductEntity> prodList = productRepository.querySelectAll();

    for (ProductEntity prod : prodList) {
      System.out.println("상품 번호 : " + prod.getNumber() + ", 상품 이름 : " + prod.getName());
    }

    System.out.println("\n ----- @Query 사용, querySelectAll() 호출 완료 -----\n");
  }

  @Override
  public void querySelectName() throws Exception {
    System.out.println("\n ----- @Query 사용, querySelectName() 호출 -----\n");

    ProductEntity prod = productRepository.querySelectName();
    System.out.println("상품 번호 : " + prod.getNumber() + ", 상품 이름 : " + prod.getName());

    System.out.println("\n ----- @Query 사용, querySelectName() 호출 완료 -----\n");
  }

  @Override
  public void querySelectNameAndPrice(String name, long price) throws Exception {
    System.out.println("\n ----- @Query 사용, querySelectNameAndPrice() 호출 -----\n");

    ProductEntity prod = productRepository.querySelectNameAndPrice(name, price);
    System.out.println("상품 번호 : " + prod.getNumber() + ", 상품 이름 : " + prod.getName());

    System.out.println("\n ----- @Query 사용, querySelectNameAndPrice() 호출 완료 -----\n");
  }

  @Override
  public void querySelectNameAndPrice(long price, String name) throws Exception {
    System.out.println("\n ----- @Query 사용, querySelectNameAndPrice() 호출 -----\n");


    ProductEntity prod = productRepository.querySelectNameAndPrice(price, name);
    System.out.println("상품 번호 : " + prod.getNumber() + ", 상품 이름 : " + prod.getName());

    System.out.println("\n ----- @Query 사용, querySelectNameAndPrice() 호출 완료 -----\n");
  }


}












