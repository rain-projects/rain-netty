package com.rain.netty.protobuftest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtoServerHandler extends SimpleChannelInboundHandler<ProtoDataInfo.User> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ProtoDataInfo.User msg) throws Exception {


        System.out.println(msg.getAddress());
        System.out.println(msg.getName());
        System.out.println(msg.getAge());

    }
}
