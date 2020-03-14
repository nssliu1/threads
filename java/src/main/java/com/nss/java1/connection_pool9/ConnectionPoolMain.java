package com.nss.java1.connection_pool9;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/15 9:17
 * @describe:
 */
public class ConnectionPoolMain {
    public static void main(String[] args) throws SQLException {
        MyDataSource myDataSource = new MyDataSource();
        Connection connection = myDataSource.getConnection();
        System.out.println(connection);
        Connection connection2 = myDataSource.getConnection();
        System.out.println(connection2);
    }
}

class MyDataSource extends MyDataSourceModel {
    private List<Connection> connectionList;
    {
        Connection conn;
        connectionList = new LinkedList<>();
        try{
            for(int i = 0;i<10;i++){
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "123456");
                connectionList.add(conn);
            }
        }catch (Exception e){

        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        return  connectionList.remove(0);
    }

}

class MyDataSourceModel implements DataSource {

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
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
