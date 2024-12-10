package com.example;

public class MyAnnotationConfigApplicationContext implements MyBeanFactory {

    public MyAnnotationConfigApplicationContext(Class<?> configClass) {
        System.out.println(configClass.getName());
    }

    @Override
    public Object getBean(String name) {
        return null;
    }

    @Override
    public boolean containsBean(String name) {
        return false;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return new String[0];
    }
}
