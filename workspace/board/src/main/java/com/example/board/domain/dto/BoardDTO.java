package com.example.board.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// 게시글을 추가할 때, 화면에서 데이터를 받아온다.
// 그 받아온 데이터를 DTO 로 받는다.
@Component
@Data
public class BoardDTO {

    private Long boardId;
    private String boardTitle;
    private String providerId;
    private String boardContent;
    private int boardViews;
    private LocalDateTime boardRegisterDate;
    private LocalDateTime boardUpdateDate;

}
