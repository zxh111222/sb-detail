package dao.impl;

import dao.BlogRepository;
import entity.Blog;

public class SimpleBlogRepository implements BlogRepository {
    @Override
    public void save(Blog blog) {
        System.out.println("已经将 blog 保存到「数据库」 - " + blog);
    }
}
