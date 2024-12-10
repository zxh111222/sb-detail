package com.example.proxy;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class LoggingHandler implements MyInvocationHandler {

    Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Method m) {
        System.out.println("用户 admin 开始访问该方法，地点：xm，时间：" + LocalDateTime.now());

        try {
            m.invoke(target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("用户 admin 结束访问该方法，地点：xm，时间：" + LocalDateTime.now());

    }
}
