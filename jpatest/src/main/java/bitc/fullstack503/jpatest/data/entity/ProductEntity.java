package bitc.fullstack503.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

//  상품 테이블

//  @Entity : JPA 에서 해당 클래스가 데이터베이스의 테이블이라는 것을 알려주는 어노테이션
//  테이블 생성 시 클래스 명이 테이블 명이 됨
//  사용자가 원하는 데이터베이스 테이블명을 사용하고자 할 경우 @Table 어노테이션과 name 속성을 사용함
@Entity
//  @Table : 지정한 엔티티와 실제 데이터베이스 테이블을 연동
//  name 속성을 사용하여 사용자가 원하는 이름의 테이블을 생성할 수 있음
@Table(name = "jpa_product")
//  @Getter : 롬복 라이브러리에서 제공하는 어노테이션으로 Getter 메소드를 자동으로 생성함
@Getter
//  @Setter : 롬복 라이브러리에서 제공하는 어노테이션으로 Setter 메소드를 자동으로 생성함
@Setter
//  @NoArgsConstructor : 롬복 라이브러리에서 제공하는 어노테이션으로 매개변수 없는 기본 생성자를 자동으로 생성해주는 어노테이션
@NoArgsConstructor
//  @AllArgsConstructor : 롬복 라이브러리에서 제공하는 어노테이션으로 모든 필드에 대한 매개변수를 가지고 있는 생성자를 자동으로 생성해주는 어노테이션
@AllArgsConstructor
//  callSuper : 부모 클래스의 필드를 해당 클래스에 포함하는 역할을 하는 속성, 롬복에서 제공
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductEntity extends BaseEntity {

//  @Id : 해당 필드가 데이터베이스의 기본키(PK) 컬럼임을 나타내는 어노테이션
  @Id
//  @GeneratedValue : 데이터가 추가될 경우 값을 자동으로 증가할지 여부를 지정하는 어노테이션 (mysql의 ai 옵션)
//  AUTO : 설정에서 선택한 데이터베이스에 따라 자동으로 선택
//  IDENTITY : 기본 키의 생성을 데이터베이스에 위임 (데이터베이스 설정을 따름, MySQL)
//  SEQUENCE : 데이터베이스 시퀀스를 사용하여 기본 키를 설정 (ORACLE 에서 사용)
//  TABLE : 키 생성 테이블을 사용
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long number;

//  @Column : 지정한 필드를 데이터베이스의 컬럼과 연동시키는 어노테이션
//  해당 어노테이션이 없어도 기본적으로 컬럼으로 자동인식 함(기본 값으로 설정)
//  컬럼이 가지고 있는 특성을 적용 시 사용
//  기본적으로 자바 클래스에서 카멜 명명법을 사용 시 데이터베이스에서 스네이크 명명법으로 적용

//  unique : 컬럼의 유니크 속성 여부 설정 (기본 false)
//  nullable : 컬럼의 null 허용 여부 설정 (기본 true)
//  updatable : 컬럼의 수정 가능 여부 설정
//  length : 컬럼에 저장될 최대 데이터 크기 설정
//  name : 실제 데이터베이스 테이블의 컬럼명을 설정 (사용자가 원하는 컬럼명으로 설정 시 사용)
//  precision : BigDecimal, BigInteger 타입 사용 시 소수점의 자리를 포함하여 전체 자리 수 설정
//  scale : BigDecimal, BigInteger 타입 사용 시 소수점의 자리 수 설정
  @Column(nullable = false, length = 45)
  private String name;

  @Column(nullable = false)
  private long price;

  @Column(nullable = false)
  private int stock;

//  데이터 입력 형식 설정, 시간대를 Asia/Seoul 로 설정하여 현재 시간을 입력
//  @Column(nullable = false)
//  private LocalDateTime createdAt = LocalDateTime.now();

//  @Column 어노테이션 미사용 시 기본값으로 적용하여 컬럼을 생성
//  private LocalDateTime updatedAt;

//  private boolean isActive;


//  JPA에서 다른 Entity와 관계 설정 시 추가할 필드를, 다른 Entity 클래스의 객체로 사용함

//  @OneToOne : 다른 Entity와 1:1 관계를 가진다는 것을 알려주는 어노테이션
//  @OneToMany : 다른 Entity와 1:N 관계를 가진다는 것을 알려주는 어노테이션
//  @ManyToOne : 다른 Entity와 N:1 관계를 가진다는 것을 알려주는 어노테이션

//  mappedBy : @OneToOne, @OneToMany 어노테이션 사용 시 기준이 되는 테이블에 사용

//  @ToString.Exclude : 두 개의 Entity 양방향 관계 설정 시 ToString을 사용하면 순환참조가 발생하기 때문에 순환 참조를 제거하기 위한 어노테이션
  @OneToOne(mappedBy = "product")
  @ToString.Exclude
  private ProductDetailEntity productDetail;

  @ManyToOne
  @JoinColumn(name = "provider_id") // 참조키 설정
  @ToString.Exclude
  private ProviderEntity provider;
}












