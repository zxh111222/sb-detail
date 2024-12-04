package com.example.config;

import com.example.dao.BlogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigTest {

    @Test
    void demo() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BlogRepository blogRepository = applicationContext.getBean(BlogRepository.class);
        blogRepository.save();
        System.out.println("--- --- ---");
        blogRepository.delete();
        System.out.println("--- --- ---");
        blogRepository.update();
        System.out.println("--- --- ---");
        blogRepository.list();
    }
}
