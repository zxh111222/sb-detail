package com.example;

import com.example.annotation.MyComponentScan;
import com.example.annotation.MyConfiguration;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyAnnotationConfigApplicationContext implements MyBeanFactory {

    Map<String, Object> beansMap = new HashMap<String, Object>();

    public MyAnnotationConfigApplicationContext(Class<?> configClass) {
        Annotation[] annotations = configClass.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        try{
            for (Annotation annotation : annotations) {
                if (annotation instanceof MyConfiguration) {
                    Object o = configClass.getDeclaredConstructor().newInstance();
                    beansMap.put(getKeyName(configClass), o);
                } else if(annotation instanceof MyComponentScan) {

                }
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private String getKeyName(Class<?> cls) {
        String className = cls.getName().replace(cls.getPackageName() + ".", "");
        //System.out.println(className);
        String key = className.substring(0, 1).toLowerCase() + className.substring(1);
        //System.out.println(key);
        return key;
    }

    @Override
    public Object getBean(String name) {
        return beansMap.get(name);
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
