package com.nss.java1.designpattern8.adaptor3;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/13 14:24
 * @describe:
 */
public class ConnPoolObjAdaptor extends ConnPoolAdaptor implements DataSourceExtend {
    private DataSource ds;
    public ConnPoolObjAdaptor(DataSource ds){
        this.ds = ds;
    }
    @Override
    public void add(Connection conn) {

    }

    @Override
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return ds.getConnection(username, password);
    }
}
