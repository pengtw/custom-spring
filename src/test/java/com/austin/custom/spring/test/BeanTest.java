package com.austin.custom.spring.test;

import com.austin.custom.spring.factory.BeanFactory;
import com.austin.custom.spring.factory.BeanFactoryBuilder;
import com.austin.custom.spring.factory.ProxyFactory;
import com.austin.custom.spring.io.Resources;
import com.austin.custom.spring.test.pojo.Computer;
import com.austin.custom.spring.test.pojo.User;
import com.austin.custom.spring.test.service.UserService;
import org.dom4j.DocumentException;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.SQLException;

public class BeanTest {

    private BeanFactory beanFactory;

    @Before
    public void before() throws DocumentException {
        InputStream inputStream = Resources.getResourceAsStream("beans.xml");
        beanFactory = new BeanFactoryBuilder().build(inputStream);
    }

    @Test
    public void test1(){
        Computer computer = (Computer) beanFactory.getBean("computer");
        computer.configurationInfo();
    }

    @Test
    public void test2() throws Exception {
        UserService userService = (UserService) ProxyFactory.getInstance().getJdkProxy(beanFactory.getBean("userService"));

        User user1 = new User();
        user1.setId(1);
        user1.setUsername("1");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("1");

        userService.updateUser(user1,user2);
    }

}
