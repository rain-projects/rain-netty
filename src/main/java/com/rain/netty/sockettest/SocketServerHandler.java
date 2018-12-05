package com.rain.netty.sockettest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @author Administrator
 * @version 1.0
 * @date 2018/9/26 15:50
 */
public class SocketServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        System.out.println("客户端地址:" + ctx.channel().remoteAddress() + "发送的消息:" + msg);
        ctx.writeAndFlush("我是服务器:" + UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
