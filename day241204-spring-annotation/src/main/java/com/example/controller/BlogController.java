package com.example.controller;

import com.example.entity.Blog;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//@Component
@Controller
public class BlogController {

    BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    public void save(Blog blog) {
         // 这里只是简单举了一个小例子 - 切换 BlogController 中依赖的具体 BlogService 实现类
         // 其他地方也可能需要切换，如：BlogService 依赖的具体 BlogRepository 实现类
         // ... 真实项目要切换的地方可能很多
         // 思考：如何在不修改 .java 源代码的方式，实现自由切换？
         // 思路提醒：现在是“自己 new” => 能否“让别人 new 好给我直接用”，现实中有很多这样的需求和例子
         // 解决方法有很多，先参考 Spring 给出的解决方案
         // 回顾之前看到的一张图：https://docs.spring.io/spring-framework/reference/core/beans/basics.html
        blogService.save(blog);
    }
}
