package com.example;

import com.example.bean.Bean1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyIoCTest {

    @Test
    public void xxx() {
        // 根据配置文件 new 出自己的容器
        MyBeanFactory myBeanFactory = new MyClassPathXmlApplicationContext("beans.xml");
        // 根据名称获取 bean
        Bean1 bean1 = (Bean1) myBeanFactory.getBean("bean1");
        Assertions.assertNull(bean1);
        // 判断容器中是否包含某些 bean

        // 返回容器中所有 bean 的名称的数组
    }

}
