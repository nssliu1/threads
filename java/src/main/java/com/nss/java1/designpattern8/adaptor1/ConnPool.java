package com.nss.java1.designpattern8.adaptor1;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/13 14:03
 * @describe:
 */
public class ConnPool extends ConnPoolAdaptor{
    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

}
