package com.week02_netty.netty.gateway.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {
    private final List<String> proxyServer;
    private final ThreadPoolExecutor bizThreadPool;
    public HttpServerInitializer(List<String> proxyServer,ThreadPoolExecutor bizThreadPool) {
        this.proxyServer = proxyServer;
        this.bizThreadPool = bizThreadPool;
    }
    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline p = ch.pipeline();
        p.addLast(new HttpRequestDecoder());
        p.addLast(new HttpResponseEncoder());
        p.addLast(new HttpObjectAggregator(1024 * 1024));
        p.addLast(new HttpServerHandler(this.proxyServer,this.bizThreadPool));
    }
}
