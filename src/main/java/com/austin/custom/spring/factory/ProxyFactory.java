package com.austin.custom.spring.factory;

import com.austin.custom.spring.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    private static ProxyFactory instance = new ProxyFactory();

    private ProxyFactory(){}

    public static ProxyFactory getInstance(){
        return instance;
    }


    /**
     * jdk动态代理 事务管理
     * @param object
     * @return
     */
    public Object getJdkProxy(Object object){

        Object proxy = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    //开启事务
                    TransactionManager.getInstance().beginTransaction();
                    result = method.invoke(object,args);
                    //提交事务
                    TransactionManager.getInstance().commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    //回滚事务
                    TransactionManager.getInstance().rollback();
                }
                return result;
            }
        });

        return proxy;
    }
}
