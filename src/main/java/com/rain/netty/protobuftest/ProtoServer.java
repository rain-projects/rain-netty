package com.rain.netty.protobuftest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class ProtoServer {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

       try {
           ServerBootstrap serverBootstrap = new ServerBootstrap();
           ServerBootstrap group = serverBootstrap.group(bossGroup, workerGroup)
                   .channel(NioServerSocketChannel.class)
                   .childHandler(new LoggingHandler(LogLevel.DEBUG))
                   .childHandler(new ProtoServerInitiazer());

           ChannelFuture channelFuture = group.bind(8989).sync();

           channelFuture.channel().closeFuture().sync();

       }finally {

           bossGroup.shutdownGracefully();
           workerGroup.shutdownGracefully();

       }
    }
}
