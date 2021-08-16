package com.week02_netty.netty.work;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpClientTest {
    public static void main(String[] args) {
        try {
            log.debug("httpClient res:{}", HttpClientPoolUtil.doGet("http://localhost:8801/"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
