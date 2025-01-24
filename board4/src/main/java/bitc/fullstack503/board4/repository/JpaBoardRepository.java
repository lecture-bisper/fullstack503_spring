package bitc.fullstack503.board4.repository;

import bitc.fullstack503.board4.entity.JpaBoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//  Repository : JPA 에서 데이터베이스에 명령을 전달하는 인터페이스
//  mybatis에서 mapper 인터페이스 + xml 파일 동일한 역할을 함

//  Repository -> CrudRepository -> PagingAndSortingRepository -> JpaRepository 의 상속관계를 가지고 있음
//  사용자는 JpaRepository 를 상속 받아 사용
//  JpaRepository 상속 시 컬렉션 타입으로 첫번째 매개변수에 사용할 Entity 클래스명, 두번재 매개변수로 해당 Entity 클래스의 기본키(@Id)로 필드의 데이터 타입을 입력

//  JpaRepository 에서 기본 명령어를 제공
//  count() : sql의 count() 명령과 동일한 기능
//  save() : sql의 insert, update 명령과 동일한 기능
//  saveAll() : 여러개의 데이터를 동시에 save() 하는 기능
//  findById() : sql의 select 명령과 동일한 기능, 기본키(@Id)를 통해서 검색
//  findAll() : sql의 select 명령과 동일한 기능, 모든 데이터 가져오기
//  deleteById() : sql의 delete 명령과 동일한 기능, 기본키(@Id)를 통해서 삭제
//  deleteAll() : sql의 delete 명령과 동일한 기능, 모든 데이터 삭제

public interface JpaBoardRepository extends JpaRepository<JpaBoardEntity, Integer> {

//  쿼리메소드 : JpaRepository에서 제공하는 기본 메소드를 가지고 원하는 모든 기능을 사용할 수 없기 때문에 특정 키워드를 사용하여 사용자 정의 메소드를 생성하는 방식의 메소드
  List<JpaBoardEntity> findAllByOrderByBoardIdxDesc();

//  @Query : JpaRepository 에서 제공하는 기본 명령어 및 쿼리 메소드로 만들기 힘든 복잡한 쿼리문의 경우 JPQL 문법을 사용하여 SQL 쿼리문을 직접 생성하여 사용할 수 있도록 하는 어노테이션
}












