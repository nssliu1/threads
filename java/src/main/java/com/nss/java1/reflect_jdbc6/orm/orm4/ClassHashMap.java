package com.nss.java1.reflect_jdbc6.orm.orm4;

import com.nss.java1.reflect_jdbc6.orm.ClassUtil;
import com.nss.java1.reflect_jdbc6.orm.TypeMappingUtil;

import java.util.HashMap;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/12 16:32
 * @describe:
 */
public class ClassHashMap extends HashMap<String,String> {
    @Override
    public String put(String columnName, String columnType) {
        columnName = columnName.toLowerCase();
        columnType = TypeMappingUtil.getTypeOfTableType(columnType);
        return super.put(columnName, columnType);
    }
}
