package com.example.config;

import com.example.controller.BlogController;
import com.example.dao.impl.NopeBlogRepository;
import com.example.dao.impl.SimpleBlogRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.example.service.impl.SimpleBlogService;

// Configuration 注解 相对于之前创建一个 beans.xml 文件
@Configuration
@ComponentScan(basePackages = "com.example")
public class AppConfig {

}
