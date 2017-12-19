package test;

import cn.wxf.note.service.IocDemoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by TYZ027 on 2017/12/15.
 */
public class IocTest {
    @Test
    /**
     * 基于xml的自动装配
     */
    public void test(){
        ApplicationContext applicationContext=new
                ClassPathXmlApplicationContext("conf/spring-ioc.xml");
        IocDemoService iocDemoService = (IocDemoService) applicationContext.getBean("IocService");
        iocDemoService.done();
    }
}
