package com.mcddhub.demo02;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.extra.spring.SpringUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;

import java.net.InetAddress;


/**
 * Demo02Application
 *
 * @version 1.0.0
 * @author: caobaoqi1029
 * @date: 2024/9/6 16:29
 */
@Slf4j
@Import(SpringUtil.class)
@SpringBootApplication
@MapperScan("com.mcddhub.demo02.repository")
public class Demo02Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo02Application.class, args);
    }

    @SneakyThrows
    @SuppressWarnings("HttpUrlsUsage")
    @EventListener(ApplicationReadyEvent.class)
    public void ready() {
        InetAddress localHost = InetAddress.getLocalHost();
        String address = CharSequenceUtil.format("http://{}:{}", localHost.getHostAddress(), SpringUtil.getProperty("server.port"));
        String runSuccessWarn = "\n====================================================================================\n" +
                "=                        Demo02 Run Success                                        =\n" +
                "=                        address:" + address + "                            =\n" +
                "====================================================================================\n";
        log.info(runSuccessWarn);
    }
}