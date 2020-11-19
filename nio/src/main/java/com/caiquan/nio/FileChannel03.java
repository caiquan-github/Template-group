package com.caiquan.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel03 {
    public static void main(String[] args) throws Exception {
        File file=new File("C:\\test\\testFile\\1.txt");
        FileInputStream fileInputStream=new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();


        FileOutputStream fileOutputStream=new FileOutputStream("C:\\test\\testFile\\2.txt");
        FileChannel channel1 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer=ByteBuffer.allocate(1);
        while (true){
            //清空buffer 重要的方法
            byteBuffer.clear();

            int read = channel.read(byteBuffer);
            if (read==-1){
                break;
            }
            byteBuffer.flip();
            channel1.write(byteBuffer);
        }

        fileOutputStream.close();
        fileInputStream.close();




    }
}
