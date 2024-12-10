package com.example;


import com.example.config.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnnotationBasedMyIoCTest {
    @Test
    public void xxx() {
        MyAnnotationConfigApplicationContext myAnnotationConfigApplicationContext = new MyAnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    public void xxxx() {
        MyAnnotationConfigApplicationContext myAnnotationConfigApplicationContext = new MyAnnotationConfigApplicationContext(AppConfig.class);
        Object appConfig = myAnnotationConfigApplicationContext.getBean("appConfig");
        Assertions.assertNotNull(appConfig);

    }

}
