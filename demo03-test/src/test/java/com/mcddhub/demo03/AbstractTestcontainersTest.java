package com.mcddhub.demo03;

import org.junit.jupiter.api.Test;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * AbstractTestcontainersTest
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 21:32
 */
@Testcontainers
public class AbstractTestcontainersTest {
    @Container
    @ServiceConnection
    static MySQLContainer<?> mysqlContainer
            = new MySQLContainer<>(DockerImageName.parse("mysql:8.2.0"));

    @Test
    void canEstablishedConnection() {
        assertThat(mysqlContainer.isCreated()).isTrue();
        assertThat(mysqlContainer.isRunning()).isTrue();
    }
}

