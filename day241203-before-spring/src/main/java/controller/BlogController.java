package controller;

import entity.Blog;
import service.BlogService;
import service.impl.NopeBlogService;
import service.impl.SimpleBlogService;

public class BlogController {
     public void save(Blog blog) {
         // 这里只是简单举了一个小例子 - 切换 BlogController 中依赖的具体 BlogService 实现类
         // 其他地方也可能需要切换，如：BlogService 依赖的具体 BlogRepository 实现类
         // ... 真实项目要切换的地方可能很多
         // 思考：如何在不修改 .java 源代码的方式，实现自由切换？
        BlogService blogService = new SimpleBlogService();
        blogService.save(blog);
    }
}
