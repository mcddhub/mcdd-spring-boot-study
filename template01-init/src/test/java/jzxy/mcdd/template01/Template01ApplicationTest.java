package jzxy.mcdd.template01;

import cn.hutool.extra.spring.SpringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Template01ApplicationTest {

    @Autowired
    ApplicationContext context;

    @Test
    void contextLoads() {
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Test
    void testHutoolSpringUtil() {
        SpringUtil springUtil = context.getBean(SpringUtil.class);
        assertNotNull(springUtil, "springUtil is null");
    }
}