package bitc.fullstack503.jpatest.data.entity;

//  제조회사 테이블

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_provider")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProviderEntity extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String companyName;

//  영속성 전이 : JPA 로 관계 설정이 되어 있는 데이터베이스 사용 시 메인이 되는 Entity의 데이터가 변경될 경우 서브 Entity 의 데이터도 함께 수정되는 것
  
//  cascade : 영속성 전이 설정을 위한 속성
//    - ALL : 모든 영속 상태 변경에 대해서 영속성 전이를 적용
//    - PERSIST : Entity 가 영속화할 때 연관된 Entity도 함께 영속화
//    - MERGE : Entity 를 영속성 컨텍스트에 병합할 때 연관된 Entity 도 병합
//    - REMOVE : Entity 를 제거할 때 연관된 Entity 도 함께 제거
//    - REFRESH : Entity 를 새로고침할 때 연관된 Entity 도 새로 고침
//    - DETACH : Entity 를 연속성 컨텍스트에서 제외하면 연관된 Entity 도 제외
  
//  기준이 되는 Entity 설정
  @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<ProductEntity> productList = new ArrayList<>();
}












