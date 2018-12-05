package com.rain.netty.protobuftest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtoClientHandler extends SimpleChannelInboundHandler<ProtoDataInfo.User> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ProtoDataInfo.User msg) throws Exception {


    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ProtoDataInfo.User build = ProtoDataInfo.User.newBuilder().setName("张三").setAge(32).setAddress("广东省深圳市").build();
        ctx.channel().writeAndFlush(build);

    }
}
