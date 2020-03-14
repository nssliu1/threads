package com.nss.java1.designpattern8.adaptor3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/13 14:23
 * @describe:
 */
public class ConnPool extends ConnPoolAdaptor {
    private final List<Connection> conn;
    {
        conn = new LinkedList<>();
    }
    @Override
    public Connection getConnection() throws SQLException {
        return conn.remove(0);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return conn.remove(0);
    }
}
