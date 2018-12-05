package com.rain.netty.httptest;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author Administrator
 * @version 1.0
 * @date 2018/9/20 18:40
 */
public class TestChildHandler extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("httpServerCodec",new HttpServerCodec());
        pipeline.addLast("testServerHandler", new TestServerHandler());

    }
}
