package com.nss.rabbitmq.releasesub3;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2020/3/20 11:47
 * @describe:
 */

        import com.nss.rabbitmq.utils.ConnectionUtil;
        import com.rabbitmq.client.Channel;
        import com.rabbitmq.client.Connection;

public class Send {

    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // 消息内容
        String message = "Hello World!";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
