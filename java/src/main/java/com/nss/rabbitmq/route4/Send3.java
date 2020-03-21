package com.nss.rabbitmq.route4;

import com.nss.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/20 13:43
 * @describe:
 */
public class Send3 {
    private final static String ROUTER_NAME = "test_router";
    public static void main(String[] args) throws Exception {
        //创建连接通道
        Connection connection = ConnectionUtil.getConnection();
        //获取通道
        Channel channel = connection.createChannel();
        //创建交换类型
        channel.exchangeDeclare(ROUTER_NAME,"direct");
        //消息内容
        String message = "插入商品";
        channel.basicPublish(ROUTER_NAME,"insert",null,message.getBytes());
        System.out.println("sent"+message);
        channel.close();
        connection.close();

    }
}
