package com.example;

public class MyClassPathXmlApplicationContext implements MyBeanFactory {

    public MyClassPathXmlApplicationContext(String configLocation) {
        System.out.println(configLocation);
    }

    @Override
    public Object getBean(String name) {
        return null;

    }
}
