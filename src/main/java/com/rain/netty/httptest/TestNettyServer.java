package com.rain.netty.httptest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * 基于netty的http服务器
 * @author Administrator
 * @version 1.0
 * @date 2018/9/14 16:25
 */
public class TestNettyServer {

    public static void main(String[] args) {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();


        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap = serverBootstrap.group(bossGroup, workerGroup);
            serverBootstrap = serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap = serverBootstrap.childHandler(new TestChildHandler());
            ChannelFuture sync = serverBootstrap.bind(8989).sync();
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }

}
