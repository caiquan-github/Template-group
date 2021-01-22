package com.caiquan.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //加入处理器

        //得到管道
        ChannelPipeline pipeline = socketChannel.pipeline();

        //加入一个netty提供的HttpServerCodec
        //HttpServerCodec 是netty 提供的处理http编解码处理器
        pipeline.addLast("MyHttpServerCodec",new HttpServerCodec());

        //增加一个自定义的handler
        pipeline.addLast("MyHttpServerHandler",new TestHttpServerHandler());
    }
}
