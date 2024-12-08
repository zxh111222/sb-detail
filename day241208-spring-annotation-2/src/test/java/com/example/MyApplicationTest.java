package com.example;

import com.example.config.AppConfig;
import com.example.controller.BlogController;
import com.example.entity.Blog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

public class MyApplicationTest {


    @Test
    public void xmlTest() {
        ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
        boolean blogController = applicationContext.containsBean("blogController");
        Assertions.assertTrue(blogController);
    }

    @Test
    public void annotationTest() {
        AnnotationConfigApplicationContext applicationContext =  new AnnotationConfigApplicationContext(AppConfig.class);
        boolean blogController = applicationContext.containsBean("blogController");
        Assertions.assertTrue(blogController);
    }

}
