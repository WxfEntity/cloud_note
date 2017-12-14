package cn.wxf.note.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxf on 2017/12/13.
 */
public class FileUtil {
    public static List getAllDirectory(File file) {
        //创建过滤器
        System.out.println(file.getAbsolutePath());
        File[] f = file.listFiles();
        List<String> fileList = new ArrayList<String>();
        for (File f1 : f) {
            //判断目录是否为空
            if (f1.length() != 0){
                getAllDirectory(f1);
            }else{
                if(f1.getName().endsWith(".java")){
                    fileList.add(f1.getName());
                }
            }

        }
        return fileList;
    }
}


