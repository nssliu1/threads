package com.nss.java1.reflect_jdbc6.orm.ormv3;

import com.nss.java1.reflect_jdbc6.orm.ClassUtil;
import com.nss.java1.reflect_jdbc6.orm.StreamUtil;
import com.nss.java1.reflect_jdbc6.orm.TypeMappingUtil;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

/**
 * @author liuzhiheng
 * @version 1.0
 * @date 2019/11/11 14:57
 * @describe:
 */
public class ProduceClassV2 {
    private static OutputStreamWriter write;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static String className="";
    private static String filePath;// = "E:\\supermap\\work\\code\\gq\\java\\src\\main\\java\\com\\nss\\java1\\reflect_jdbc6\\orm\\ormv2\\";
    private static String packageName;// = ProduceClassV2.class.getPackage().getName();

    public static void createPackagePath(String packageName) throws IOException {
        String rootPath = new File("").getCanonicalPath();//项目包根目录 java
        System.out.println(packageName);
        String[] pNames = packageName.split("\\.");
        System.out.println(pNames.length);
        rootPath+=File.separator+"src"+File.separator+"main"+File.separator+"java";
        for (String str: pNames){
            rootPath+=(File.separator+str);
        }
        //rootPath+=";\n";
        filePath = rootPath;
        String packagePath = rootPath;
        File file = new File(packagePath);
        System.out.println(packagePath);
        file.mkdirs();
    }
    //写包路径
    public static void producePackage(String packageName){
        stringBuilder.append("package "+ ProduceClassV2.packageName +";\n");
        stringBuilder.append("\n");
    }

    //导入包
    public static void produceImportPackage(Map<String, String> propertys){
        String columnName;
        String columnType;
        //创建属性
        Set<String> propertyKeys = propertys.keySet();
        for(String key: propertyKeys){
            columnType = propertys.get(key);
            String packageOfPropertyType = TypeMappingUtil.getPackageOfPropertyType(columnType);
            if(packageOfPropertyType!=null){
                stringBuilder.append("import "+packageOfPropertyType+";"+"\n");
            }
        }
        stringBuilder.append("\n");
    }

    public static void produceStaticBlock(){
        //创建静态代码块
        stringBuilder.append("\tstatic{\n");
        stringBuilder.append("\t\tSystem.out.println(\"nssliu\");\n");
        stringBuilder.append("\t}\n");
        stringBuilder.append("\n");
    }
    public static void producePropertyGetSet(Map<String, String> propertys){
        String columnName;
        String columnType;
        //创建属性

        Set<String> propertyKeys = propertys.keySet();
        for(String key: propertyKeys){
            columnType = propertys.get(key);
            columnName = key;
            stringBuilder.append("\tprivate "+columnType+" "+columnName+";\n");
        }
        stringBuilder.append("\n");
        for(String key: propertyKeys){
            columnType = propertys.get(key);
            columnName = key;
            //创建get
            stringBuilder.append("\tpublic "+columnType+" "+"get"+ ClassUtil.classNameFormat(columnName)+"(){\n");
            stringBuilder.append("\t\treturn this."+columnName+";\n");
            stringBuilder.append("\t}\n");
            //创建set
            stringBuilder.append("\tpublic void set"+ClassUtil.classNameFormat(columnName)+"("+columnType+" "+columnName+"){\n");
            stringBuilder.append("\t\tthis."+columnName+"="+columnName+";\n");
            stringBuilder.append("\t}\n");
        }
    }

    public static void produceClass(Map<String,Map<String,String>> clazzMap) throws SQLException, ClassNotFoundException, IOException {


        //创建生成类的路径
        Map<String, String> packageNameMap = clazzMap.get("packageName");
        if(packageNameMap==null){
            throw new RuntimeException("包名标识不可为空");
        }
        Set<Map.Entry<String, String>> packageNameMapSet = packageNameMap.entrySet();
        for (Map.Entry<String, String> entry: packageNameMapSet) {
            ProduceClassV2.packageName = entry.getKey();
        }
        createPackagePath(ProduceClassV2.packageName);

        //写包名
        producePackage(ProduceClassV2.packageName);

        //导入依赖包
        Map<String, String> propertys = clazzMap.get("propertyName");
        produceImportPackage(propertys);

        //创建类
        Map<String, String> classNameMsg = clazzMap.get("className");
        Set<String> keys = classNameMsg.keySet();
        for(String key: keys){
            className = key;
            stringBuilder.append(classNameMsg.get(key)+" class "+key+"{\n");
        }
        stringBuilder.append("\n");

        //创建静态代码块
        produceStaticBlock();

        //创建属性和getset方法
        //Map<String, String> propertys = clazzMap.get("propertyName");
        producePropertyGetSet(propertys);

        //类结尾符
        stringBuilder.append("}");
        //保存文件位置
        String filePath1 = filePath+File.separator+className +".java";
        write = StreamUtil.getWrite(filePath1);
        write.write(stringBuilder.toString());
        StreamUtil.closeWriter(write);
        //Class.forName(ProduceClassV2.packageName +"."+ className);

    }
}
