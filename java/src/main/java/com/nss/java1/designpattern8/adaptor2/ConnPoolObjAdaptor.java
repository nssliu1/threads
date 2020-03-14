package com.nss.java1.designpattern8.adaptor2;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/13 14:07
 * @describe:
 */
public class ConnPoolObjAdaptor implements DataSource,DataSourceExtend {
    private DataSource ds;
    private final List<Connection> pool;
    {
        pool = new LinkedList<>();
    }
    public ConnPoolObjAdaptor(DataSource ds){
        this.ds = ds;
    }
    @Override
    public void add(Connection conn) {
        this.pool.add(conn);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return ds.getConnection(username,password);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
