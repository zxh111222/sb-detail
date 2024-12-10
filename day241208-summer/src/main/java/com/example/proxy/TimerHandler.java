package com.example.proxy;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimerHandler implements MyInvocationHandler {

    Object target;

    public TimerHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Method m) {
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);

        try {
            m.invoke(target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("fly time = " + (end - start));
    }
}
