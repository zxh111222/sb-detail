import controller.BlogController;
import entity.Blog;
import service.BlogService;
import service.impl.SimpleBlogService;

public class MyApplication {
    public static void main(String[] args) {
        System.out.println("MyApplication.main");
        BlogService blogService = new SimpleBlogService();
        BlogController blogController = new BlogController(blogService);
        Blog blog = new Blog(1L, "这是一个标题", "这是内容");
        blogController.save(blog);
    }
}
