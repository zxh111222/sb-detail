package com.example.dao.impl;

import com.example.dao.BlogRepository;
import com.example.entity.Blog;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Primary
public class NopeBlogRepository implements BlogRepository {
    @Override
    public void save(Blog blog) {
        System.out.println("我...视而不见");
    }
}
