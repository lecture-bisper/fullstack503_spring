package bitc.fullstack503.jpaboardtest.data.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

//  댓글 테이블, 자식 Entity, 부모 Entity인 BaseEntity를 상속받아 사용

@Entity
@Table(name = "jpa_reply")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ReplyEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int replyIdx;

  @Column(length = 200, nullable = false)
  private String contents;

//  private String createdId;
//  private String createdDate;
//  private String updatedDate;

  //  참조키
  @ManyToOne
  @JoinColumn(name = "board_idx")
  @ToString.Exclude
  private BoardEntity board;
}












