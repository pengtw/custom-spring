package com.austin.custom.spring.config;

import com.austin.custom.spring.pojo.Bean;
import com.austin.custom.spring.pojo.BeanConfig;
import com.austin.custom.spring.pojo.Property;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class XMLBeanBuilder {

    private BeanConfig beanConfig;

    public XMLBeanBuilder(BeanConfig beanConfig) {
        this.beanConfig = beanConfig;
    }

    public void parse(InputStream in) throws DocumentException {
        //使用dom4j加载配置文件
        Document document = new SAXReader().read(in);
        //获取根节点
        Element rootElement = document.getRootElement();
        //查询所有bean配置
        List<Element> beanElements = rootElement.selectNodes("//bean");

        for (Element beanElement : beanElements) {
            //封装成bean对象
            Bean bean = new Bean();
            bean.setId(beanElement.attributeValue("id"));
            bean.setClazz(beanElement.attributeValue("class"));
            bean.setProperties(new ArrayList<>());
            //查询当前bean下的Properties配置
            List<Element> propertyElements = beanElement.selectNodes("property");
            for (Element propertyElement : propertyElements) {
                String name = propertyElement.attributeValue("name");
                String ref = propertyElement.attributeValue("ref");
                Property properties = new Property();
                properties.setName(name);
                properties.setRef(ref);
                bean.getProperties().add(properties);
            }
            beanConfig.getBeans().add(bean);
        }
    }
}
