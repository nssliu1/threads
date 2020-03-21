package com.nss.rabbitmq.route4;

import com.nss.rabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/20 14:56
 * @describe:
 */
public class RecvLiu2 {
    private final static String QUEUE_NAME="test_queue_direct_2";
    private final static String ROUTER_NAME = "test_router";
    public static void main(String[] args) throws Exception {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //绑定队列交换机,以及关心的路由
        channel.queueBind(QUEUE_NAME,ROUTER_NAME,"insert");
        channel.queueBind(QUEUE_NAME,ROUTER_NAME,"update");
        channel.queueBind(QUEUE_NAME,ROUTER_NAME,"delete");
        //同时刻服务器只发送一条消息给消费者
        channel.basicQos(1);
        //定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 监听队列，手动返回完成
        channel.basicConsume(QUEUE_NAME, false, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [RecvLiu2] Received '" + message + "'");
            Thread.sleep(10);

            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }

    }
}
