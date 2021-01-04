import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dqpi.edu.User.Model.User;
import com.dqpi.edu.User.Service.UserService;

public class HelloMain {

    public static void main(String[] args) {
        User user = new User();
        // create and configure beans

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add(user);
    }

}
