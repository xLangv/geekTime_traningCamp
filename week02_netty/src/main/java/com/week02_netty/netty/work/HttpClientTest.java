package com.week02_netty.netty.work;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 第2周作业 httpClient
 */
@Slf4j
public class HttpClientTest {
    public static void main(String[] args) {
        try {
            Map<String, String> headers = new HashMap<>();
            log.debug("httpClient res:{}", HttpClientPoolUtil.doGet("http://localhost:8801",headers));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
