package com.nss.java1.socket10.version2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/15 14:35
 * @describe:
 */
public class Servers {
    public static void main(String[] args) throws IOException {
        //启动一个进程 绑定一个端口，等待客户接入ServerSocket
        ServerSocket ss = new ServerSocket(8080);
        //等待接入  阻塞方法
        Socket s = ss.accept();
        //网络连接对象中获得输入流
        InputStream is = s.getInputStream();
        //回复应答
        OutputStream os = s.getOutputStream();
        while (true){
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            System.out.println("服务器接收到数据："+inputStreamReader.read());

            PrintWriter pw  = new PrintWriter(os);
            pw.println("HelloClient");
            pw.flush();
        }


        //关闭网络连接对象 判断是否已经关闭
//		s.isClosed()是否关闭网络连接
        //if(!s.isClosed())s.close();//没有关闭连接时再关掉连接
    }
}
