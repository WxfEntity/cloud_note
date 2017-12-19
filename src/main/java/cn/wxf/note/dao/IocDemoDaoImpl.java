package cn.wxf.note.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by wxf on 2017/12/15.
 */

//@Component 相同效果
@Repository("IocDemoDao")
public class IocDemoDaoImpl implements  IocDemoDao{
    public void done(){
        System.out.println("UserDaoImpl.invoke......");
    }
}
