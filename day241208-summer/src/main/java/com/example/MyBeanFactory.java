package com.example;

public interface MyBeanFactory {

    Object getBean(String name);

    boolean containsBean(String name);

    String[] getBeanDefinitionNames();

}
