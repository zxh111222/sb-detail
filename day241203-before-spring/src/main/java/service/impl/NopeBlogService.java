package service.impl;

import dao.BlogRepository;
import dao.impl.NopeBlogRepository;
import entity.Blog;
import service.BlogService;

public class NopeBlogService implements BlogService {
    @Override
    public void save(Blog blog) {
// 调用 Repository 之前可能做一些其他的操作，比如记录日志等...
        BlogRepository blogRepository = new NopeBlogRepository();
        blogRepository.save(blog);
        // 调用 Repository 之后也可能做一些其他的操作，比如统计等...
    }
}
