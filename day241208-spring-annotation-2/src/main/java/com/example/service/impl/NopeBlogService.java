package com.example.service.impl;

import com.example.dao.BlogRepository;
import com.example.entity.Blog;
import com.example.service.BlogService;
import org.springframework.stereotype.Service;


public class NopeBlogService implements BlogService {
    BlogRepository blogRepository;

    public NopeBlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void save(Blog blog) {
        // 调用 Repository 之前可能做一些其他的操作，比如记录日志等...
        blogRepository.save(blog);
        // 调用 Repository 之后也可能做一些其他的操作，比如统计等...
    }
}