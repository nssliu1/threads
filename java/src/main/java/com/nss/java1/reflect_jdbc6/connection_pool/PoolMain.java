package com.nss.java1.reflect_jdbc6.connection_pool;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/15 11:51
 * @describe:
 */
public class PoolMain {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MyDataSourcePool();
        System.out.println(dataSource.getConnection());

        dataSource.getConnection().close();
    }
}
