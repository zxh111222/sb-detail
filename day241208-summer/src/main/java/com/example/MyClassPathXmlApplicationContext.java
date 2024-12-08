package com.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.File;
import java.io.IOException;

public class MyClassPathXmlApplicationContext implements MyBeanFactory {

    public MyClassPathXmlApplicationContext(String configLocation) throws IOException {
        String path = this.getClass().getClassLoader().getResource(configLocation).getPath();
        Document document = Jsoup.parse(new File(path), "UTF-8");
        System.out.println(document.html());
    }

    @Override
    public Object getBean(String name) {
        return null;

    }
}
