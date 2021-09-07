package com.caiquan.netty.simple;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        //创建一个事件循环组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建客户端启动对象
            Bootstrap bootstrap = new Bootstrap()
                    .group(group) //指定事件循环组
                    .channel(NioSocketChannel.class) //指定通道类型
                    .handler(new ChannelInitializer<SocketChannel>() { //增加一个处理
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            System.out.println("客户端准备完成");

            //启动客户端连接服务器
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6668).sync();


            //监听通道关闭事件
            channelFuture.channel().closeFuture().sync();
        } finally {
            //优雅关闭
            group.shutdownGracefully();
        }
    }
}
