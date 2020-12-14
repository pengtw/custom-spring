package com.austin.custom.spring.factory;

import com.austin.custom.spring.pojo.Bean;
import com.austin.custom.spring.pojo.BeanConfig;
import com.austin.custom.spring.pojo.Property;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 默认生成bean的工厂
 */
public class DefaultBeanFactory implements BeanFactory {

    //bean配置文件
    private BeanConfig beanConfig;

    //保存生成的bean
    private Map<String,Object> beanMap = new HashMap<>();

    public DefaultBeanFactory(BeanConfig beanConfig) {
        this.beanConfig = beanConfig;
        //初始化工厂
        this.init();
    }

    /**
     * 生成bean
     */
    private void init(){
        try {
            //实例化bean
            for (Bean bean : beanConfig.getBeans()) {
                if (getBean(bean.getId()) != null){
                    throw new IllegalArgumentException("bean id: "+bean.getId()+" 重复");
                }

                Class<?> aClass = Class.forName(bean.getClazz());
                Object object = aClass.newInstance();
                beanMap.put(bean.getId(),object);
            }
            //设置参数
            for (Bean bean : beanConfig.getBeans()) {
                //没有配置参数
                if (bean.getProperties().isEmpty()){
                    continue;
                }
                Object parentObject = getBean(bean.getId());
                for (Property property : bean.getProperties()) {
                    //获取属性 name: 参数名称  ref: 指向另一个bean的id
                    String methodName = splicingSet(property.getName());
                    String ref = property.getRef();
                    Object object = getBean(ref);
                    Method method = null;
                    //根据方法名称查找方法
                    for (Method classMethod : parentObject.getClass().getMethods()) {
                        if (Objects.equals(methodName,classMethod.getName())){
                            method = classMethod;
                            break;
                        }
                    }
                    if (method != null){
                        method.invoke(parentObject,object);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据id获取bean
     * @param id
     * @return
     */
    @Override
    public Object getBean(String id){
        return beanMap.get(id);
    }

    /**
     * 根据参数名称拼接set方法
     * @param name
     * @return
     */
    private String splicingSet(String name){
        return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    }


}
