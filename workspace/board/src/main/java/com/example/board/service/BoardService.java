package com.example.board.service;

import com.example.board.domain.dto.BoardListDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    
    List<BoardListDTO> getBoardList(int page, int pageSize);

    int getBoardListCount();

}
