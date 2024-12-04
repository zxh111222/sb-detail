package dao.impl;

import dao.BlogRepository;
import entity.Blog;

public class NopeBlogRepository implements BlogRepository {
    @Override
    public void save(Blog blog) {
        System.out.println("我...视而不见");
    }
}
