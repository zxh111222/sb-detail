package com.example;

import com.example.bean.Bean2NeedBean3;
import com.example.bean.Bean3;
import com.example.config.AppConfig;
import com.example.controller.BlogController;
import com.example.entity.Blog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

public class MyApplicationTest {


    @Test
    @DisplayName("XML-based")
    public void xmlTest() {
        ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
        boolean blogController = applicationContext.containsBean("blogController");
        Assertions.assertTrue(blogController);
    }

    @Test
    @DisplayName("Annotation-based")
    public void annotationTest() {
        AnnotationConfigApplicationContext applicationContext =  new AnnotationConfigApplicationContext(AppConfig.class);
        boolean blogController = applicationContext.containsBean("blogController");
        Assertions.assertTrue(blogController);
    }

    @Test
    @DisplayName("bean2 当中的 bean3 和容器中拿的 bean3 是同一个对象")
    public void testBean2NeedBean3() {
        ClassPathXmlApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
        Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
        Bean2NeedBean3 bean2 = applicationContext.getBean(Bean2NeedBean3.class);
        Assertions.assertEquals(bean3, bean2.bean3);
    }


}
