package com.rain.netty.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 * @version 1.0
 * @date 2018/11/13 11:25
 */
public class WebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    private static Map<String, String> channelNamesMap = new ConcurrentHashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        Channel channel1 = ctx.channel();

        for (Channel channel : channels) {

            if (channel == channel1) {
                channel1.writeAndFlush(new TextWebSocketFrame("我说 :" + msg.text()));
            }else{

                channel.writeAndFlush(new TextWebSocketFrame("客户端 " + channel1.remoteAddress() + "说:" + msg.text()));
            }

        }

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        System.out.println("新连接建立: id = " + ctx.channel().id().asLongText());
        channels.add(ctx.channel());

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

        System.out.println("链接关闭: id = " + ctx.channel().id().asLongText());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        System.out.println("出现异常");
        cause.printStackTrace();
        ctx.close();
    }
}
