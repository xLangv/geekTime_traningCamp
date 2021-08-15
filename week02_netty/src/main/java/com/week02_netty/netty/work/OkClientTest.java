package com.week02_netty.netty.work;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OkClientTest {
    public static void main(String[] args) {
        log.info("okHttpClient res  {}", OkHttpUtil.get("http://localhost:8801/"));
    }
}
