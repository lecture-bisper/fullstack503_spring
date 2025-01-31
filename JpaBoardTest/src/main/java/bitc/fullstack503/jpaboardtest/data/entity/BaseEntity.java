package bitc.fullstack503.jpaboardtest.data.entity;

//  부모 엔티티 클래스, 테이블로 만들어지지는 않음,

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

  @CreatedBy
  @Column(nullable = false, length = 45)
  private String createdId;

  @CreatedDate
  @Column(nullable = false)
  private LocalDateTime createdDate = LocalDateTime.now();

  @LastModifiedDate
  @Column
  private LocalDateTime updatedDate;
}


// 문제 1) 사용자 정보를 저장할 MemberEntity 를 생성하고, MemberDetailEntity 와 1:1 관계를 가지도록 Entity 를 생성하세요
// MemberEntity : seq, createdId, pw, createdDate, updateDate
// MemberDetailEntity : createdId, name, email, address, gender, phone












