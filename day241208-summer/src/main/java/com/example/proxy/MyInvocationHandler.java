package com.example.proxy;


import java.lang.reflect.Method;

public interface MyInvocationHandler {

    void invoke(Method m);

}
