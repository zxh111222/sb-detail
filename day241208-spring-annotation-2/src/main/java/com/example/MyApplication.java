package com.example;

import com.example.config.AppConfig;
import com.example.controller.BlogController;
import com.example.dao.BlogRepository;
import com.example.entity.Blog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MyApplication {
    public static void main(String[] args) {
        // XML-based Configuration Metadata
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        // Annotation-based Configuration Metadata
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("MyApplication.main");
//        BlogRepository blogRepository = new NopeBlogRepository();
//        BlogService blogService = new SimpleBlogService(blogRepository);
//        BlogController blogController = new BlogController(blogService);
        BlogController blogController = (BlogController) applicationContext.getBean("blogController");
        Blog blog = new Blog(1L, "这是一个标题", "这是内容");
        blogController.save(blog);


        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("=== === ===");

        BlogRepository simpleBlogRepository = (BlogRepository) applicationContext.getBean("simpleBlogRepository");
        System.out.println(applicationContext.containsBean("simpleBlogRepository"));
    }
}
