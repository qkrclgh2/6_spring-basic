package com.example.c_mybatis.dataSource;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
@Slf4j
public class ConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource() {

        try {
            Connection connection = dataSource.getConnection();
            log.info("datasource connection: " + connection.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
