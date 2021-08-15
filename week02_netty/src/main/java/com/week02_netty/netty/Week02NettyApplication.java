package com.week02_netty.netty;

import com.week02_netty.netty.work.HttpClientPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Slf4j
public class Week02NettyApplication implements CommandLineRunner {

    @Value("${url}")
    private String url;

    public static void main(String[] args) {
        SpringApplication.run(Week02NettyApplication.class, args);
    }

    @Override
    public void run(String... args) {
        try {
            log.info("httpClient res:{}", HttpClientPoolUtil.doGet(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
