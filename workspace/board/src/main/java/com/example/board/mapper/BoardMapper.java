package com.example.board.mapper;

import com.example.board.domain.dto.BoardListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardListDTO> selectAll(int startRow, int endRow);

    int countBoard();

}
