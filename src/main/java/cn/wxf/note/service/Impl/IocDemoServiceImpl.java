package cn.wxf.note.service.Impl;

import cn.wxf.note.dao.IocDemoDao;
import cn.wxf.note.service.IocDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by wxf on 2017/12/15.
 */
//@Component 相同效果
@Service("iocDemoService")
public class IocDemoServiceImpl  implements IocDemoService{
    /**
     *
     */
    @Autowired
    private IocDemoDao iocDemoDao;

    //占位符方式
    @Value("#{jdbc.url}")
    private String url;
    //SpEL表达方式，其中代表xml配置文件中的id值configProperties
    @Value("#{jdbc.user}")
    private String userName;

    /**
     * 使用自动装配，有这3中注入方式，值需要选择一种进行操作
     * 建议选择成员变量注入
     *
     */
    /*@Autowired
    public IocDemoServiceImpl(IocDemoDao iocDemoDao){
        this.iocDemoDao=iocDemoDao;
    }
    @Autowired
    public void setIocDemoDao(IocDemoDao iocDemoDao) {
        this.iocDemoDao = iocDemoDao;
    }*/

    public void done() {
        System.out.println("url:"+url);
        System.out.println("username:"+userName);
        iocDemoDao.done();
    }

}
