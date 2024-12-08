package com.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.javapoet.ClassName;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MyClassPathXmlApplicationContext implements MyBeanFactory {

    Map<String, Object> beansMap = new HashMap<String, Object>();

    public MyClassPathXmlApplicationContext(String configLocation) throws IOException {
        String path = this.getClass().getClassLoader().getResource(configLocation).getPath();
        Document document = Jsoup.parse(new File(path), "UTF-8");
        Elements beans = document.select("beans bean");

        for (Element bean : beans) {
            String beanClass = bean.attr("class");
            String beanId = bean.attr("id");
            try {
                Constructor<?> declaredConstructor = Class.forName(beanClass).getDeclaredConstructor();
                Object o = declaredConstructor.newInstance();
                beansMap.put(beanId, o);
            } catch (Exception e) {
                throw new RuntimeException(e);

            }
        }
    }

    @Override
    public Object getBean(String name) {
        return beansMap.get(name);
    }

    @Override
    public boolean containsBean(String name) {
        return beansMap.containsKey(name);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beansMap.keySet().toArray(new String[0]);
    }

}
