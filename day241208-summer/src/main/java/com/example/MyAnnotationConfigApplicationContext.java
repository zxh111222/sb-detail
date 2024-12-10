package com.example;

import com.example.annotation.MyComponent;
import com.example.annotation.MyComponentScan;
import com.example.annotation.MyConfiguration;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.*;

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
                    String basePackage = ((MyComponentScan) annotation).value();
                    System.out.println(basePackage);
                    List<Class<?>> classes = scanPackage(basePackage);
                    // 按类名排序（当前例子的解法之一，实际需要更严谨的处理）
                    classes.sort(Comparator.comparing(Class::getName));
                    for (Class<?> cls : classes) {
                        if (cls.getAnnotation(MyComponent.class) != null) {
                            Constructor<?>[] constructors = cls.getDeclaredConstructors();
                            if (constructors.length == 1 && constructors[0].getParameterCount() == 0) {
                                Object o = constructors[0].newInstance();
                                beansMap.put(getKeyName(cls), o);
                            } else if (constructors.length == 1 && constructors[0].getParameterCount() == 1) {
                                Class<?> refType = constructors[0].getParameters()[0].getType();
                                Object refObj = beansMap.get(getKeyName(refType));
                                Object o = constructors[0].newInstance(refObj);
                                beansMap.put(getKeyName(cls), o);
                            } else {
                                throw new RuntimeException("暂时只支持自动处理「空参」和「单个参数」构造器的 Bean");
                            }
                        }
                    }
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

    private List<Class<?>> scanPackage(String basePackage) {
        List<Class<?>> classes = new ArrayList<>();
        try {
            String path = basePackage.replace('.', '/');
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            Enumeration<URL> resources = classLoader.getResources(path);
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                String protocol = resource.getProtocol();
                if ("file".equals(protocol)) {
                    File directory = new File(resource.getFile());
                    if (directory.exists()) {
                        scanDirectory(directory, basePackage, classes);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to scan package: " + basePackage, e);
        }
        return classes;
    }

    private void scanDirectory(File directory, String basePackage, List<Class<?>> classes) {
        if (!directory.exists()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                if (file.isDirectory()) {
                    scanDirectory(file, basePackage + "." + fileName, classes);
                } else if (fileName.endsWith(".class")) {
                    try {
                        String className = basePackage + "." + fileName.substring(0, fileName.length() - 6);
                        Class<?> cls = Class.forName(className);
                        classes.add(cls);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("Failed to load class: " + fileName, e);
                    }
                }
            }
        }
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
