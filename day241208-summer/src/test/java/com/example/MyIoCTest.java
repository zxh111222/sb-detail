package com.example;

import com.example.bean.Bean1;
import com.example.bean.Bean2;
import com.example.bean.Bean3NeedBean2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

public class MyIoCTest {

    @Test
    public void xxx() throws IOException {
        // 根据配置文件 new 出自己的容器
        MyBeanFactory applicationContext = new MyClassPathXmlApplicationContext("beans.xml");
        // 根据名称获取 bean
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        Assertions.assertNotNull(bean1);
        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
        Assertions.assertNotNull(bean2);
        Bean3NeedBean2 bean3 = (Bean3NeedBean2) applicationContext.getBean("bean3NeedBean2");
        Assertions.assertEquals(bean3.bean2, bean2);
        // 判断容器中是否包含某些 bean
          Assertions.assertTrue(applicationContext.containsBean("bean2"));
        // 返回容器中所有 bean 的名称的数组
         System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }

}
