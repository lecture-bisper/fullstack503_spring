package bitc.fullstack503.jpaboardtest.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

//  게시판 테이블, 자식 Entity 클래스, 부모 클래스인 BaseEntity 상속받아 사용

@Entity
@Table(name = "jpa_bbs")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BoardEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int boardIdx;

  @Column(length = 100, nullable = false)
  private String title;

  @Column(length = 500, nullable = false)
  private String contents;

//  private String createdId;
//  private String createdDate;
//  private String updatedDate;

//  @ColumnDefault("0") : 컬럼 생성 시 초기값 설정, 데이터베이스 테이블에서 default 를 설정한 것과 동일한 효과
  @Column(nullable = false)
  @ColumnDefault("0")
  private int hitCnt = 0; // 컬럼 생성 시 초기값은 없으나 해당 테이블에 데이터가 추가될 때 값을 0 으로 설정
//  둘 다 설정했을 경우 @ColumnDefault() 로 설정한 값이 초기값으로 설정되고 실제 데이터가 추가될 때 hitCnt = 0 으로 설정한 값이 데이터베이스에 입력 됨

  @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<ReplyEntity> replyList = new ArrayList<>();
}












