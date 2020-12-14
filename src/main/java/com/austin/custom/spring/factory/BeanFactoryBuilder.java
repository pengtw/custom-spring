package com.austin.custom.spring.factory;

import com.austin.custom.spring.config.XMLBeanBuilder;
import com.austin.custom.spring.pojo.BeanConfig;
import org.dom4j.DocumentException;

import java.io.InputStream;

public class BeanFactoryBuilder {

    public BeanFactory build(InputStream in) throws DocumentException {
        //1.加载配置文件 解析成BeanConfig
        BeanConfig beanConfig = new BeanConfig();
        XMLBeanBuilder xmlBeanBuilder = new XMLBeanBuilder(beanConfig);
        xmlBeanBuilder.parse(in);

        //生成BeanFactory
        return new DefaultBeanFactory(beanConfig);
    }

}
