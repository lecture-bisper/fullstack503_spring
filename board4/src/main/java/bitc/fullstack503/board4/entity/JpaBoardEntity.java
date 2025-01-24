package bitc.fullstack503.board4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// Entity : 데이터베이스의 테이블의 구성을 만드는 클래스
//  MyBatis에서 사용하는 DTO와 비슷한 클래스

@Entity
@Table(name = "jpa_board")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JpaBoardEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int boardIdx;

  @Column(name = "title", length = 255, nullable = false)
  private String title;

  @Column(nullable = false, length = 500)
  private String contents;

  @Column(nullable = false, length = 45)
  private String createId;

  @Column(nullable = false)
  private LocalDateTime createDate = LocalDateTime.now();

  private String updateId;

  private LocalDateTime updateDate;

  @Column(nullable = false)
  private int hitCnt;
}












