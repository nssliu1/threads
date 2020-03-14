package com.nss.java1.designpattern8.adaptor3;

import java.sql.SQLException;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/13 14:27
 * @describe:
 */
public class ConnMain {
    public static void main(String[] args) throws SQLException {
        ConnPool connPool = new ConnPool();
        ConnPoolObjAdaptor connPoolObjAdaptor = new ConnPoolObjAdaptor(connPool);

        connPoolObjAdaptor.add(connPoolObjAdaptor.getConnection());
    }
}
