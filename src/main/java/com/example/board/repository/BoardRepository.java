package com.example.board.repository;

import com.example.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JPARepository<테이블명, id 필드의 데이터타입>
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    // 기본 CRUD를 제공
    // find 필드명 AND(OR)필드명
    // SQL 문을 필드명으로 조합해서 사용
}
