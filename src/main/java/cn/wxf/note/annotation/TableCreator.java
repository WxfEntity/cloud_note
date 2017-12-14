package cn.wxf.note.annotation;

import cn.wxf.note.utils.JDBCHelper;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TYZ027 on 2017/12/12.
 * 运行时注解处理器，构造表创建语句
 */
public class TableCreator {
    public static String createTableSql(String className) throws ClassNotFoundException {
        Class<?> cl = Class.forName(className);
        DBTable dbTable = cl.getAnnotation(DBTable.class);
        //如果没有表注解，直接返回
        if(dbTable == null) {
            System.out.println(
                    "No DBTable annotations in class " + className);
            return null;
        }
        String tableName = dbTable.name();
        // If the name is empty, use the Class name:
        if(tableName.length() < 1)
            tableName = cl.getName();
        List<String> columnDefs = new ArrayList<String>();

        Integer integer=0;
        //通过Class类API获取到所有成员字段
        for(Field field : cl.getDeclaredFields()) {
            //数据库字段名称
            String columnName = field.getName();

            //获取字段上的注解
            Annotation[] anns = field.getAnnotations();
            if(anns.length < 1){
                continue; // Not a db table column
            }
            //获取字段类型
            String leng = "";
            String type ="";
            String isId="";
            String comment="";
            String nullable="DEFAULT NULL";
            Class colType = field.getType();
            if(Integer.TYPE.equals(colType)){
                type="INT";
                leng="11";
            }else if(Long.class.equals(colType)){
                type = "BIGINT";
                leng = "20";
            }else if(Boolean.class.equals(colType)){
                type="DATETIME";
                leng="";
            }else if(Double.class.equals(colType)){
                type="decimal";
                leng="18,4";
            } else{
                type = "VARCHAR";
                leng ="255";
            }
            for(int i=0;i<anns.length;i++){
                //判断是否主键
                if(anns[i] instanceof Id){
                    Id id = (Id) anns[i];
                    nullable="";
                    if(id.autoCreat()){
                        isId="PRIMARY KEY AUTO_INCREMENT";
                    }else{
                        isId="PRIMARY KEY";
                    }
                }
                // 字段属性获取
                if(anns[i] instanceof SQLClolum){
                    SQLClolum sqlClolum = (SQLClolum) anns[i];
                    if(sqlClolum.name().length()>1){
                        columnName=sqlClolum.name();
                    }
                    if(sqlClolum.length()!=255){
                        leng =String.valueOf(sqlClolum.length());
                    }
                    if(sqlClolum.comment().length()>1){
                        comment=sqlClolum.comment();
                    }
                    if(!sqlClolum.nullable()){
                        nullable="false";
                    }
                }
            }
            //拼接语句
            if(type.equals("DATETIME")){
                columnDefs.add(columnName+" "+type+" "+nullable+" "+isId+" "+comment);
            }else {
                columnDefs.add(columnName+" "+type+"("+leng+") "+nullable+" "+isId+" "+comment);
            }
        }
        //数据库表构建语句
        StringBuilder createCommand = new StringBuilder(
                "CREATE TABLE " + tableName + "(");
        for(String columnDef : columnDefs)
            createCommand.append("\n    " +columnDef.trim() + ",");

        // Remove trailing comma
        String tableCreate = createCommand.substring(
                0, createCommand.length() - 1) + "\n );";
        return tableCreate;
    }


    public static void createst() throws Exception {
        String[] arg={"Member"};
        File file = new File("cn.tedu.note.entity");
        String sql="" ;
        for(String className : arg) {
            sql=createTableSql(className);
        }
        JDBCHelper jdbcHelper = new JDBCHelper();
        jdbcHelper.createTable(sql);

    }
}
