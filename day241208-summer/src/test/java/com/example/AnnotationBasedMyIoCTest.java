package com.example;


import com.example.bean.Bean1;
import com.example.bean.Bean2;
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
        // 根据名称获取 bean
        Bean1 bean1 = (Bean1) myAnnotationConfigApplicationContext.getBean("bean1");
        Assertions.assertNotNull(bean1);
        Bean2 bean2 = (Bean2) myAnnotationConfigApplicationContext.getBean("bean2");
        Assertions.assertNotNull(bean2);
        // 反面测试
        Object bean3 = myAnnotationConfigApplicationContext.getBean("bean3");
        Assertions.assertNull(bean3);

    }

}
