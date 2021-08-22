package com.week02_netty.netty.gateway.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 混一下作业
 * 后续完善
 * 还是HTTPClient作为客户端
 */
public class NettyServer {

    static final int PORT = Integer.parseInt(System.getProperty("port", "8080"));
    private final static List<String> proxyServers = Arrays.asList("http://localhost:8801", "http://localhost:8802");

    public static void main(String[] args) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        final ThreadPoolExecutor bizThreadPool = new ThreadPoolExecutor(1, 200, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(2000), new ThreadFactory() {
            public Thread newThread(Runnable r) {
                return new Thread(r, "http-proxyService" + r.hashCode());
            }
        }, new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                throw new RuntimeException("http-proxyService EXHAUSTED!");
            }
        });
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new HttpServerInitializer(proxyServers, bizThreadPool));
            Channel ch = b.bind(PORT).sync().channel();
            System.out.println("Open your web browser and navigate to http://127.0.0.1:" + PORT + '/');
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
