package cn.wxf.note.utils;


import cn.wxf.note.annotation.DBTable;
import cn.wxf.note.controller.JsonResult;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TYZ027 on 2017/12/14.
 */
public class EntityUtil extends UtilParent{
    /**
     * 查找指定实体类包含有DBTable注解的实体类
     * @param path
     * @return
     */
    public  List<String> entityList(String path){
        List<String> classList = new ArrayList<String>();
        File file = new File(path);
        String filePath= file.getAbsolutePath();
        System.out.println(filePath);
        System.out.println(filePath.length());
        filePath = filePath.substring(0,filePath.length()-path.length());
        filePath +="src\\main\\java\\";
        path = path.replaceAll("\\.", "\\\\");
        filePath+=path;
        File file1 = new File(filePath);

        if(file1.exists()) {
            File[] files = file1.listFiles();
            for(File f:files ){
                Class<?> cl = null;
                try {
                    cl = Class.forName(f.getName().split("\\.")[0]);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                }
                DBTable dbTable = cl.getAnnotation(DBTable.class);
                String className="";
                if(dbTable!=null){
                    className=dbTable.name().length()<1?cl.getName():dbTable.name();
                    String tableName = dbTable.name();
                }
                classList.add(className);
            }
        }else {
            System.out.print("文件夹不存在");
        }
        return classList;
    }
    public void main(String[] args) {
        entityList("cn.wxf.note.entity");
    }

    public  List<String> eqEntity(List<String> entityList,List<String> tableList){
        for(String className:entityList){

        }
        return null;
    }

    public JsonResult findName(String className){

        return null;
    }
}
