import controller.BlogController;
import dao.BlogRepository;
import dao.impl.SimpleBlogRepository;
import entity.Blog;
import service.BlogService;
import service.impl.NopeBlogService;
import service.impl.SimpleBlogService;

public class MyApplication {
    public static void main(String[] args) {
        System.out.println("MyApplication.main");
        BlogRepository blogRepository = new SimpleBlogRepository();
        BlogService blogService = new NopeBlogService(blogRepository);
        BlogController blogController = new BlogController(blogService);
        Blog blog = new Blog(1L, "这是一个标题", "这是内容");
        blogController.save(blog);
    }
}
