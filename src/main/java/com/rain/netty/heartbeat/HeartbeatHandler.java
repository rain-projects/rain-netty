package com.rain.netty.heartbeat;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author Administrator
 * @version 1.0
 * @date 2018/11/9 14:41
 */
public class HeartbeatHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if (evt instanceof IdleStateEvent) {

            IdleStateEvent id = (IdleStateEvent) evt;
            IdleState state = id.state();
            String stateStr = "";
            switch (state) {

                case READER_IDLE:
                    stateStr = "读空闲!!";
                    break;

                case WRITER_IDLE:
                    stateStr = "写空闲!!";
                    break;

                case ALL_IDLE:
                    stateStr = "度写空闲!!";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "超时事件:" + stateStr);
            ctx.channel().close();
        }

    }
}
