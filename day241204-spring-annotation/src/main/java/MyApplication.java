import controller.BlogController;
import entity.Blog;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplication {
    public static void main(String[] args) {
        // XML-based Configuration Metadata
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("MyApplication.main");
//        BlogRepository blogRepository = new NopeBlogRepository();
//        BlogService blogService = new SimpleBlogService(blogRepository);
//        BlogController blogController = new BlogController(blogService);
        BlogController blogController = (BlogController) applicationContext.getBean("blogController");
        Blog blog = new Blog(1L, "这是一个标题", "这是内容");
        blogController.save(blog);

        // 现在可以去看看之前的 sb-blog 项目，猜猜哪里能找到 IoC 容器
    }
}
