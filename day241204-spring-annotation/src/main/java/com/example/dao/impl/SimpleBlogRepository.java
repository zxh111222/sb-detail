package com.example.dao.impl;

import com.example.dao.BlogRepository;
import com.example.entity.Blog;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class SimpleBlogRepository implements BlogRepository {
    @Override
    public void save(Blog blog) {
        System.out.println("已经将 blog 保存到「数据库」 - " + blog);
    }
}
