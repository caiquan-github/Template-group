package com.caiquan.nio;

import java.nio.IntBuffer;

public class BasicBuffer {

    public static void main(String[] args) {
        //创建一个buffer 大小为5
        //Buffer 底层是一个数组
        IntBuffer intBuffer=IntBuffer.allocate(5);
        //put 4个数据
        intBuffer.put(10);
        intBuffer.put(11);
        intBuffer.put(12);
        intBuffer.put(13);

        //将buffer读写状态切换
        intBuffer.flip();

        intBuffer.clear();
        //read 数据
        while (intBuffer.hasRemaining()){
            //每get一次相当于指针会移到下一个数据
            System.out.println(intBuffer.get());
        }




    }
}
