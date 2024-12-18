package com.example.board.DTO;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString // 테이블 join을 사용할 때는 2개 Entity 중에 하나에는 toString이 없어야 함
@Builder
public class BoardDTO {
    //Entity에 있는 변수들(사용할 것만)복사
    //공통 삽입, 수정, 목록, 상세보기
    private Integer id;
    private String subject;
    private String content;
    private String author;
    private LocalDateTime regdate;
    private LocalDateTime modDate;
}
