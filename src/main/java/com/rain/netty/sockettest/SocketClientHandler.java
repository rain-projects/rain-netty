package com.rain.netty.sockettest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

/**
 * @author Administrator
 * @version 1.0
 * @date 2018/9/26 16:00
 */
public class SocketClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        System.out.println("服务器的地址" + ctx.channel().remoteAddress() + "发送的消息:" + msg);
        ctx.writeAndFlush("我是客户端;正在推送消息" + LocalDateTime.now());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ctx.writeAndFlush("链接建立!!!");
    }
}
