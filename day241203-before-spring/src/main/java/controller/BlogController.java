package controller;

import entity.Blog;
import service.BlogService;
import service.impl.NopeBlogService;
import service.impl.SimpleBlogService;

public class BlogController {
     public void save(Blog blog) {
        BlogService blogService = new NopeBlogService();
        blogService.save(blog);
    }
}
