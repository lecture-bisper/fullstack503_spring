package bitc.fullstack503.jpatest.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//  다른 Entity 클래스의 부모가 되는 클래스
//  테이블로 생성되지 않음

//  Configuration 클래스 생성 후 @EnableJpaAuditing 어노테이션을 반드시 사용해야 함

@Getter
@Setter
//  @MappedSuperclass : JPA의 Entity 클래스가 상속을 받을 경우 자식 클래스에 매핑 정보를 전달하는 어노테이션
@MappedSuperclass
//  @EntityListeners : Entity 의 Auditing 정보를 주입하는 JPA Entity 리스너 클래스
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

//  @CreatedDate : 데이터 생성 날짜 및 시간을 자동으로 주입하는 어노테이션, JPA Audit 기능이 활성화 되어 있어야 함
  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime createdAt;

//  @LastModifiedDate : 데이터 수정 날짜 및 시간을 자동으로 주입하는 어노테이션, JPA Audit 기능이 활성화 되어 있어야 함
  @LastModifiedDate
  private LocalDateTime updatedAt;


//  @CreatedBy : JPA Audit 에서 제공하는 어노테이션으로 누가 데이터를 생성했는지를 자동으로 주입하는 어노테이션 
//  @CreatedBy
//  @Column(nullable = false)
//  private String createId;

//  @LastModifiedBy : JPA Audio 에서 제공하는 어노테이션으로 누가 데이터를 수정했는지를 자동으로 주입하는 어노테이션
//  @LastModifiedBy
//  @Column(nullable = true)
//  private String updateId;
}












