package cn.wxf.note.utils;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by TYZ027 on 2017/12/13.
 */
public class JDBCHelper {


    private  String url;


    private  String user;


    private  String pwd;

    private  String driver;

     public List<String> findDBEntity(String sql) throws Exception{
         List<String> list = new ArrayList<String>();
         Connection conn = null;
         Properties prop =new Properties();
         prop.load(DBUtil.class.getClassLoader().getResourceAsStream("conf/jdbc.properties"));
         url = prop.getProperty("url");
         user = prop.getProperty("user");
         pwd = prop.getProperty("pwd");
         String driver = prop.getProperty("driver");
         try {
             Class.forName(driver);// 动态加载mysql驱动
             conn = DriverManager.getConnection(url,user,pwd);
             System.out.println("成功加载MySQL驱动程序");
             Statement statement = conn.createStatement();
             //statement.executeUpdate(sql);
             //从元数据获取所有表名
             DatabaseMetaData db = conn.getMetaData();
             ResultSet rs = db.getTables(null, null, null, new String[] { "TABLE" });
             while(rs.next()){
                 // 选择Name这列数据
                 // 输出结果
                 System.out.println(rs.getString(3));
                 list.add(rs.getString(3));
             }
             return null;
         } catch (SQLException e) {
             System.out.println("MySQL操作错误");
             e.printStackTrace();
             DBUtil.rollback(conn);
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             DBUtil.close(conn);
             return null;
         }
     }


}
