package controller;

import entity.Blog;
import service.BlogService;
import service.impl.SimpleBlogService;

public class BlogController {
     public void save(Blog blog) {
        SimpleBlogService simpleBlogService = new SimpleBlogService();
        simpleBlogService.save(blog);
    }
}
