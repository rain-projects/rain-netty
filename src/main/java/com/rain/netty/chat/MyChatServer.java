package com.rain.netty.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * netty的聊天室服务器
 * @author Administrator
 * @version 1.0
 * @date 2018/10/24 14:48
 */
public class MyChatServer {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap = serverBootstrap.group(boosGroup, workerGroup)
                    .channel(NioServerSocketChannel.class).childHandler(new MyChatInitnizer());

            ChannelFuture sync = serverBootstrap.bind(8989).sync();

            sync.channel().closeFuture().sync();
        } finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
