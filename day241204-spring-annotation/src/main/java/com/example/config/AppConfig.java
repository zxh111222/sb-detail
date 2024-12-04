package com.example.config;

import com.example.controller.BlogController;
import com.example.dao.impl.NopeBlogRepository;
import com.example.dao.impl.SimpleBlogRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.service.impl.SimpleBlogService;

// Configuration 注解 相对于之前创建一个 beans.xml 文件
@Configuration
public class AppConfig {
    // Bean 注解 相当于之前 beans.xml 文件里面的 bean 标签
    @Bean
    public SimpleBlogRepository simpleBlogRepository() {
        return new SimpleBlogRepository();
    }

    @Bean
    public NopeBlogRepository nopeBlogRepository() {
        return new NopeBlogRepository();
    }

    @Bean
    public SimpleBlogService simpleBlogService() {
        return new SimpleBlogService(simpleBlogRepository());
    }

    @Bean
    public BlogController blogController() {
        return new BlogController(simpleBlogService());
    }
}
