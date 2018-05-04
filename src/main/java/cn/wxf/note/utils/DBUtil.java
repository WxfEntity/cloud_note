package cn.wxf.note.utils;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by TYZ027 on 2017/12/14.
 */
public class DBUtil {

    protected static String driverClassName=null;
    protected static String url=null;
    protected static String username=null;
    protected static String password=null;
    protected static String maxActive=null;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(String maxActive) {
        this.maxActive = maxActive;
    }

    private static BasicDataSource ds;

    static{
        Properties p = new Properties();
        try {
            p.load(DBUtil.class.getClassLoader().getResourceAsStream("conf/jdbc.properties"));
            ds = new BasicDataSource();
            ds.setDriverClassName(driverClassName);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);
            //Integer num = Integer.valueOf(maxActive);
            ds.setMaxActive(20);


        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("连接池启动失败",e);
        }

    }
    public static Connection getConnection() throws SQLException {

        return ds.getConnection();
    }
    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("归还连接失败",e);
            }
        }
    }
    public static void rollback(Connection conn){
        if(conn!=null){
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("回滚失败，连接为空",e);
            }
        }
    }
}
