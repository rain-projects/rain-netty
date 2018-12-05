package com.rain.netty.sockettest;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Administrator
 * @version 1.0
 * @date 2018/9/26 15:53
 */
public class SocketClientTest {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(bossGroup).channel(NioSocketChannel.class)
                    .handler(new SocketClientInitnazer());

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8989).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
        }
    }

}
