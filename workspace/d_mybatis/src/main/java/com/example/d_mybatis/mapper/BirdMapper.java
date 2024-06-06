package com.example.d_mybatis.mapper;

import com.example.d_mybatis.domain.BirdVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BirdMapper {

    @Select("select sysdate from dual")
    String getTimeQuick();

    String getTime();

    BirdVO selectById(int id);

    List<BirdVO> selectAll();

    void insert(BirdVO vo);

    void updateById(BirdVO vo);

    void deleteById(int id);
}
