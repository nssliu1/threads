package com.nss.java1.reflect_jdbc6.orm;

import java.io.*;
import java.sql.*;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/11 14:57
 * @describe:
 */
public class ProduceClass {
    private static OutputStreamWriter write;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static String className;
    private static String filePath = "E:\\supermap\\work\\code\\gq\\java\\src\\main\\java\\com\\nss\\java1\\reflect_jdbc6\\orm\\";
    private static String packageName = ProduceClass.class.getPackage().getName();
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "123456");
        String m_TableName = "student";
        DatabaseMetaData m_DBMetaData = conn.getMetaData();
        ResultSet tableRet = m_DBMetaData.getTables(null, "%",m_TableName,new String[]{"TABLE"});
/*其中"%"就是表示*的意思，也就是任意所有的意思。其中m_TableName就是要获取的数据表的名字，如果想获取所有的表的名字，就可以使用"%"来作为参数了。*/

//3. 提取表的名字。

        stringBuilder.append("package "+packageName+";\n");
        while(tableRet.next()){
            String tableName = tableRet.getString("TABLE_NAME");
            System.out.println(tableName);
            className = ClassUtil.classNameFormat(tableName);
            System.out.println(className);

            stringBuilder.append("public class "+className+"{\n");

        }
        stringBuilder.append("\tstatic{\n");
        stringBuilder.append("\t\tSystem.out.println(\"nssliu\");\n");
        stringBuilder.append("\t}\n");

        String columnName;
        String columnType;
        ResultSet colRet = m_DBMetaData.getColumns(null,"%", m_TableName,"%");
        while(colRet.next()) {
            columnName = colRet.getString("COLUMN_NAME");
            columnType = colRet.getString("TYPE_NAME");

            System.out.println(columnName+" "+columnType);
            stringBuilder.append("\tprivate "+TypeMappingUtil.getTypeOfTableType(columnType)+" "+columnName.toLowerCase()+";\n");

            stringBuilder.append("\tpublic "+TypeMappingUtil.getTypeOfTableType(columnType)+" "+"get"+ClassUtil.classNameFormat(columnName)+"(){\n");
            stringBuilder.append("\t\treturn this."+columnName+";\n");
            stringBuilder.append("\t}\n");

            stringBuilder.append("\tpublic void set"+ClassUtil.classNameFormat(columnName)+"("+TypeMappingUtil.getTypeOfTableType(columnType)+" "+columnName+"){\n");
            stringBuilder.append("\t\tthis."+columnName+"="+columnName+";\n");
            stringBuilder.append("\t}\n");

        }

        stringBuilder.append("}");
        String filePath1 = filePath+className+".java";
        write = StreamUtil.getWrite(filePath1);
        write.write(stringBuilder.toString());
        StreamUtil.closeWriter(write);
        Class.forName(packageName+"."+className);

    }
}
