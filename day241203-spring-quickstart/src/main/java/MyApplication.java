import controller.BlogController;
import entity.Blog;

public class MyApplication {
    public static void main(String[] args) {
        System.out.println("MyApplication.main");
        BlogController blogController = new BlogController();
        Blog blog = new Blog(1L, "这是一个标题", "这是内容");
        blogController.save(blog);
    }
}
