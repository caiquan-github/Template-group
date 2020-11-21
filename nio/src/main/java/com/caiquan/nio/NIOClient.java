package com.caiquan.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class NIOClient {
    public static void main(String[] args) throws Exception{


        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();



        //设置非阻塞模式
        socketChannel.configureBlocking(false);

        //提供服务器端的ip和端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);

        //连接服务器
        if (!socketChannel.connect(inetSocketAddress)){
            //如果没有成功
            while (!socketChannel.finishConnect()){
                System.out.println("客户端连接需要事件，客户端不会阻塞，继续其他工作");
            }
        }

        //连接成功 发送数据
        String str="hello world";

        for (int i=0;i<3;i++){
            //产生一个字节数组放入这个Buffer中
            ByteBuffer wrap = ByteBuffer.wrap(str.getBytes());
            //发送数据，将buffer数据写入channel中
            socketChannel.write(wrap);
        }

        //阻塞
        System.in.read();


    }
}
