package service.impl;

import dao.BlogRepository;
import dao.impl.SimpleBlogRepository;
import entity.Blog;
import service.BlogService;

public class SimpleBlogService implements BlogService {
    BlogRepository blogRepository;

    public SimpleBlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void save(Blog blog) {
        // 调用 Repository 之前可能做一些其他的操作，比如记录日志等
        blogRepository.save(blog);
        // 调用 Repository 之后也可能做一些其他的操作，比如统计等...
    }
}
