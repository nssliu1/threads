package com.nss.java1.designpattern8.adaptor3;

import java.sql.Connection;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/13 14:07
 * @describe:
 */
public interface DataSourceExtend {
    public void add(Connection conn);
}
