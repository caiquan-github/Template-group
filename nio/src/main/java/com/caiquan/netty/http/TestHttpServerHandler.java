package com.caiquan.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

/**
 * SimpleChannelInboundHandler 是ChannelInboundHandler子类
 * HttpObject 表示客户端和服务器端相互通讯的数据被封装成 HttpObject类型
 *
 * @author Kwon
 * @date 2021/1/22 15:24
 */
public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * 读取客户端数据
     *
     * @author Kwon
     * @date 2021/1/22 15:24
     * @param channelHandlerContext
     * @param httpObject
     * @return
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {
        //判断 msg 是不是 httprequest
        if (httpObject instanceof HttpRequest){
            System.out.println("msg 类型="+httpObject.getClass());
            System.out.println("客户端地址:"+channelHandlerContext.channel().remoteAddress());

            //回复信息给浏览器 [http 协议]
            ByteBuf content = Unpooled.copiedBuffer("hello,My is Server", CharsetUtil.UTF_8);

            //构造一个http的响应，httpresponse
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,content);

            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,content.readableBytes());

            //将构建好的response返回
            channelHandlerContext.writeAndFlush(response);
        }
    }
}
