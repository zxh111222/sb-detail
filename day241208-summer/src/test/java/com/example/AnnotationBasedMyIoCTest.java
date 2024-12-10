package com.example;


import com.example.config.AppConfig;
import org.junit.jupiter.api.Test;

public class AnnotationBasedMyIoCTest {
    @Test
    public void xxx() {
        MyAnnotationConfigApplicationContext myAnnotationConfigApplicationContext = new MyAnnotationConfigApplicationContext(AppConfig.class);
    }

}
