package com.caiquan.netty.simple;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author aa3
 */
public class NettyServer {


    public static void main(String[] args) throws InterruptedException {

        //创建 bossGroup 与 WorkerGroup
        // 创建两个线程组
        // bossGroup 只处理连接请求
        // workerGroup 处理业务请求
        // 2个都是无限循环
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {


            //创建服务器端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class) //通道类型
                    .option(ChannelOption.SO_BACKLOG, 128) //设置线程队列等待连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true) //设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() { //创建一个通道测试对象（匿名对象）
                        //给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //增加一个处理器
                            socketChannel.pipeline().addLast(new NettyServerHandler());
                        }
                    }); //给我们的workerGroup 的EventLoop对应的管道设置处理器

            System.out.println(".....服务器 is read...");

            //绑定一个端口并且同步,并且生成ChannelFuture对象
            //启动服务器并绑定端口
            ChannelFuture channelFuture = bootstrap.bind(6668).sync();

            //对关闭通道进行监听  这里只是对关闭通道这个事件进行监听 非关闭通道
            channelFuture.channel().closeFuture().sync();
        }finally {
            //如果有异常 进行优雅关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
