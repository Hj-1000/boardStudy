package com.example.board.service;

import com.example.board.DTO.BoardDTO;
import com.example.board.entity.BoardEntity;
import com.example.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional  // 데이터베이스에 작업할 레코들을을 모아서 한번에 처리
@RequiredArgsConstructor    // 자동 주입, 클래스 생성자를 통해 생성 후 사용, Autowired 대체
@Log4j2
public class BoardService {
    private final BoardRepository boardRepository;  // 사용할 SQL문
    private final ModelMapper modelMapper; // AppConfig에 선언함

    public void insert(BoardDTO boardDTO){ // 삽입, 입력폼에서 입력받은 내용을 데이터베이스 저장
        //DTO로 Entity변환
        //map은 변수, 값으로 구성된 배열
        //boardDTO 변수들을 BoardEntity에 변수에 맞게 변환
        BoardEntity boardEntity =
                modelMapper.map(boardDTO, BoardEntity.class);

        boardRepository.save(boardEntity);
    };
    public void update(BoardDTO boardDTO){ // 수정, 수정폼에서 수정한 내용을 데이터베이스 저장

        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(boardDTO.getId());
        if (optionalBoardEntity.isPresent()){
            BoardEntity boardEntity =
                    modelMapper.map(boardDTO, BoardEntity.class);

            boardRepository.save(boardEntity);
        }

    };
    public void delete(Integer id){ // 삭제, 삭제할 게시글번호로 해당 자료를 데이터베이스에서 삭제

        boardRepository.deleteById(id);
    };
    public List<BoardDTO> list(){ // 전체목록, 데이터베이스에서 모든 데이터를 화면에 출력

        List<BoardEntity> boardEntities = boardRepository.findAll();

        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities, BoardDTO[].class));

        return boardDTOS;
    };
    public BoardDTO read(Integer id){ // 개별정보, 게시글번호의 데이터를 화면에 출력

        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        BoardDTO boardDTO = modelMapper.map(optionalBoardEntity, BoardDTO.class);
        return boardDTO;
    };
}
