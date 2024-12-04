import com.example.config.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(AppConfig.class)
public class IoCTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    void testContainBeanBlogController() {
        boolean blogController = applicationContext.containsBean("blogController");
        System.out.println(blogController);

        Assertions.assertTrue(blogController);
    }

    @Test
    void testNotContainBeanBlogController() {
        boolean blogController = applicationContext.containsBean("blogController_123321");
        System.out.println(blogController);

        Assertions.assertTrue(blogController);
    }

}
