package com.example.d_mybatis.mapper;

import com.example.d_mybatis.domain.BirdVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class BirdMapperTest {

    @Autowired
    private BirdMapper birdMapper;

    @Test
    void selectByIdTest(){
        log.info(birdMapper.selectById(1).toString());
    }

    @Test
    void getTimeQuickTest(){
        log.info(birdMapper.getTimeQuick());
    }

    @Test
    void selectAllTest(){
//        log.info(birdMapper.selectAll().toString());
        birdMapper.selectAll().stream().map(BirdVO::toString).forEach(log::info);
        birdMapper.selectAll().forEach(birdVO -> {log.info(birdVO.toString());});
        birdMapper.selectAll().forEach(System.out::println);
    }

    @Test
    void insertTest(){
//        BirdVO birdVO = new BirdVO();
//        birdVO.setAge(10);
//        birdVO.setName("독수리");
//        birdVO.setGender("여");

//        빌더 패턴으로 객체를 만드는 방법.

        BirdVO birdVO = BirdVO.builder()
                .age(5)
                .name("매")
                .gender("남")
                .build();

        birdMapper.insert(birdVO);
    }

    @Test
    void updateByIdTest(){
        int pk = 1;
        int updatedAge = 10;

        BirdVO vo =
                BirdVO.builder()
                        .id(1)
                        .age(10)
                        .build();

        BirdVO updateVO = birdMapper.selectById(1);
        updateVO.setAge(updatedAge);
        birdMapper.updateById(updateVO);
    }

    @Test
    void deleteByIdTest(){

        birdMapper.deleteById(1);
    }
}