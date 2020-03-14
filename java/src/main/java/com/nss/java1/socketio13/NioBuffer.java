package com.nss.java1.socketio13;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/28 13:42
 * @describe:
 */
public class NioBuffer {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //初始化buffer的空间
        ByteBuffer buffer = ByteBuffer.allocate(10000);
        System.out.println(buffer);
        //切换为写模式

        //写数据
        buffer.put("hello nss".getBytes());
        System.out.println(buffer);
        //切换为读模式
        buffer.flip();
        //获取已经存的数据大小
        int remaining = buffer.remaining();
        //创建字节数组，准备接收读取的数据
        byte[] bytes = new byte[remaining];
        //从可读写buffer内存中读数据到java内存bytes数组中
        buffer.get(bytes);
        //打印数据
        System.out.println(new String(bytes,"UTF-8"));

        //重新写
        buffer.clear();
        buffer.put("hello nss".getBytes());
        buffer.flip();
        int ra = buffer.remaining();
        byte [] bytes1 = new byte[ra];
        buffer.get(bytes1);
        System.out.println(new String(bytes1,"UTF-8"));


    }
}
