package com.nss.java1.socket10.version2;

import java.io.*;
import java.net.Socket;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/15 14:35
 * @describe:
 */
public class Clients {
    public static void main(String[] args) throws IOException {
        //需要ip port
		/*
		 * ip  192.168.0.3
		 * 本机：127.0.0.1、localhost
		 * port  1024之前的端口都已经被占用
		 * 	8000   9000  8888
		 */
        //创建网络连接对象Socket
        Socket s = new Socket("localhost",8080);
        //获取网络连接对象中的io流
        //给服务器发数据
        OutputStream os = s.getOutputStream();
        //接收应答
        InputStream is = s.getInputStream();
        while (true){
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os);
            outputStreamWriter.write(10);
            outputStreamWriter.flush();

            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader in = new BufferedReader(isr);
            String str = in.readLine();
            System.out.println("客户端接收应答："+str);
        }


        //if(!s.isClosed())s.close();//如果没有关闭网络连接，我关闭网络连接





    }
}
