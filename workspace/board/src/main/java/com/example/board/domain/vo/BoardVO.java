package com.example.board.domain.vo;

import com.example.board.domain.dto.BoardDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Getter
@ToString
@NoArgsConstructor
public class BoardVO {

    private Long boardId;
    private String boardTitle;
    private String providerId;
    private String boardContent;
    private int boardViews;
    private LocalDateTime boardRegisterDate;
    private LocalDateTime boardUpdateDate;

    @Builder
    public BoardVO(Long boardId, String boardTitle, String providerId, String boardContent, int boardViews, LocalDateTime boardRegisterDate, LocalDateTime boardUpdateDate) {
        this.boardId = boardId;
        this.boardTitle = boardTitle;
        this.providerId = providerId;
        this.boardContent = boardContent;
        this.boardViews = boardViews;
        this.boardRegisterDate = boardRegisterDate;
        this.boardUpdateDate = boardUpdateDate;
    }

    public static BoardVO toEntity(BoardDTO boardDTO) {
        return BoardVO.builder().boardId(boardDTO.getBoardId())
                .boardTitle(boardDTO.getBoardTitle())
                .providerId(boardDTO.getProviderId())
                .boardContent(boardDTO.getBoardContent())
                .boardViews(boardDTO.getBoardViews())
                .boardRegisterDate(boardDTO.getBoardRegisterDate())
                .boardUpdateDate(boardDTO.getBoardUpdateDate())
                .build();
    }
}
