package com.nss.java1.reflect_jdbc6.orm.ormv3;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/12 11:13
 * @describe:
 */
public class Tests {
    @Test
    public void testJdbc() throws IOException {
        //File file = new File(new File("").getCanonicalPath());
        System.out.println(new File("").getCanonicalPath()
                +File.separator+"com"
                +File.separator+"nss"
                +File.separator+"java1"
                +File.separator+"reflect_jdbc6"
                +File.separator+"producePackage");
        Map<String ,String> map = new HashMap<>();
        System.out.println(map.get("st"));

    }
}
