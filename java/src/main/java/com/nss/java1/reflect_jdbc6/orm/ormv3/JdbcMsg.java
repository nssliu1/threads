package com.nss.java1.reflect_jdbc6.orm.ormv3;

import com.nss.java1.reflect_jdbc6.orm.ClassUtil;
import com.nss.java1.reflect_jdbc6.orm.TypeMappingUtil;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/11 18:36
 * @describe:
 * {
 *     "className":{"类名":"public(null)"},
 *     "propertyName":{"属性名":"String"
 *                     "属性名":"Integer"},
 *     "packageName":{"包名":"包路径（null）"}
 * }
 */
public class JdbcMsg {
    private static Map<String,Map<String,String>> classMap = new HashMap();
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "123456");
        String m_TableName = "student";
        DatabaseMetaData m_DBMetaData = conn.getMetaData();
        ResultSet tableRet = m_DBMetaData.getTables(null, "%",m_TableName,new String[]{"TABLE"});

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("com.nss.java1.reflect_jdbc6.produce_package",null);
        classMap.put("packageName",stringStringHashMap);
        while(tableRet.next()){
            String tableName = tableRet.getString("TABLE_NAME");
            System.out.println(tableName);

            String className = ClassUtil.classNameFormat(tableName);

            HashMap<String, String> classMsg = new HashMap<>();
            classMsg.put(className,"public");
            classMap.put("className",classMsg);

        }

        String columnName;
        String columnType;
        ResultSet colRet = m_DBMetaData.getColumns(null,"%", m_TableName,"%");
        HashMap<String, String> propertyMsg = new HashMap<>();
        while(colRet.next()) {
            columnName = colRet.getString("COLUMN_NAME");
            columnType = colRet.getString("TYPE_NAME");
            System.out.println(columnName+" "+columnType);

            columnName = columnName.toLowerCase();
            columnType = TypeMappingUtil.getTypeOfTableType(columnType);
            propertyMsg.put(columnName,columnType);
        }
        classMap.put("propertyName",propertyMsg);
        System.out.println(classMap);

        ProduceClassV2.produceClass(classMap);


    }
}

