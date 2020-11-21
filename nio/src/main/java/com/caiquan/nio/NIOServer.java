package com.caiquan.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    public static void main(String[] args) throws Exception{
        //创建server socket channel
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();


        //得到一个selector
        Selector selector = Selector.open();

        //绑定一个端口6666，在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));

        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //把ServerSocketChannel 注册到 selector 关心事件为连接事件 OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端连接
        while (true){

            //0代表没有任何事件发生，1000代表等待时间
            if (selector.select(1000)==0){
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }

            //如果范围>0 代表有事件
            //通过selectedKeys 获取到有事件的keys集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            //遍历集合
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                //获取key
                SelectionKey key = keyIterator.next();

                //判断如果是OP_ACCEPT事件
                if (key.isAcceptable()){
                    //拿到socketChannel
                    // accept方法本身是阻塞的，但是本身这里我就知道有人需要来连接了，所以方法是阻塞的，但是实际上是会直接返回socketChannel。
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    //将socketChannel 注册到selector，关注事件为OP_READ。 同时关联一个Buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                //判断如果是OP_READ 事件
                if (key.isReadable()){
                    //通过key反向获取到对于的channel 强转为SocketChannel
                    SocketChannel socketChannel=(SocketChannel)key.channel();

                    //获取到channel关联的buffer
                    ByteBuffer byteBuffer = (ByteBuffer)key.attachment();

                    //将通道的数据读取到Buffer中
                    socketChannel.read(byteBuffer);

                    System.out.println("form 客户端"+ new String(byteBuffer.array()));

                }

                //重要！ 手动从集合中移除当前的selectedKey  ,防止重复操作
                keyIterator.remove();
            }
        }

    }
}
