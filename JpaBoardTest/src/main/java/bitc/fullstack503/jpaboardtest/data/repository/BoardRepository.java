package bitc.fullstack503.jpaboardtest.data.repository;

import bitc.fullstack503.jpaboardtest.data.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
}












