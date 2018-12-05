package com.rain.netty.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyChatClient {

    public static void main(String[] args) throws Exception {
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(bossGroup).channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitnizer());

            ChannelFuture channelFuture = bootstrap.connect("localhost", 8989).sync();
            Channel channel = channelFuture.channel();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                channel.writeAndFlush(bufferedReader.readLine() + "\r\n");
            }
        } finally {
            bossGroup.shutdownGracefully();
        }
    }

}