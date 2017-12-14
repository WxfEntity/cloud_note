package cn.wxf.note.utils;

import org.apache.poi.ss.formula.functions.T;

import java.io.File;
import java.util.List;

/**
 * Created by TYZ027 on 2017/12/14.
 */
public class EntityUtil {
    public static List<T> entityList(String path){
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        File file1 = new File(file.getAbsolutePath());
        if(file1.exists()) {
            File[] files = file1.listFiles();
            for(File f:files ){
                System.out.print(f.getName());
            }
        }else {
            System.out.print("文件夹不存在");
        }

        return null;
    }
    public static void main(String[] args) {
        entityList("cn.tedu.note.entity");
    }
}
