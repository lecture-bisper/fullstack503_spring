package bitc.fullstack503.jpatest.data.entity;

//  상품 상세 테이블

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "jpa_product_detail")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductDetailEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String description;

//  부모 클래스인 BaseEntity로 부터 상속받아 사용하는 필드
//  createdAt, updatedAt 이 존재함
//  @Column(nullable = false)
//  private LocalDateTime createdAt = LocalDateTime.now();
//
//  private LocalDateTime updatedAt;

//  @JoinColumn : 관계가 설정된 테이블에서 참조키를 설정하는 어노테이션
//  name : 참조키의 컬럼명을 설정하는 속성
  @OneToOne
  @JoinColumn(name = "product_number")
  private ProductEntity product;
}












