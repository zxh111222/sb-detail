package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Configuration 注解 相对于之前创建一个 beans.xml 文件
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

}
