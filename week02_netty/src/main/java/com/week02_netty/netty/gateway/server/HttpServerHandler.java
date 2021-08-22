package com.week02_netty.netty.gateway.server;

import com.week02_netty.netty.gateway.filter.HeaderHttpRequestFilter;
import com.week02_netty.netty.gateway.filter.HttpRequestFilter;
import com.week02_netty.netty.gateway.outbound.httpclient4.HttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class HttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    private final HttpOutboundHandler handler;
    private final HttpRequestFilter filter = new HeaderHttpRequestFilter();

    public HttpServerHandler(List<String> proxyServer, ThreadPoolExecutor threadPoolExecutor) {
        this.handler = new HttpOutboundHandler(proxyServer,threadPoolExecutor);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, HttpObject msg) {
        if (msg instanceof HttpRequest) {
            /**
             * 从客户端收到的消息msg进行处理
             * 1.路由
             * 2.过滤器
             * 3.发送请求给第三方服务 -> 返回
             */
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            handler.handle(fullRequest, ctx, filter);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
