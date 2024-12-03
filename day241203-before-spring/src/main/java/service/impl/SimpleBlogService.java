package service.impl;

import dao.impl.SimpleBlogRepository;
import entity.Blog;
import service.BlogService;

public class SimpleBlogService implements BlogService {

    @Override
    public void save(Blog blog) {
        // 调用 Repository 之前可能做一些其他的操作，比如记录日志等
        SimpleBlogRepository simpleBlogRepository = new SimpleBlogRepository();
        simpleBlogRepository.save(blog);
        // 调用 Repository 之后也可能做一些其他的操作，比如统计等...
    }
}
