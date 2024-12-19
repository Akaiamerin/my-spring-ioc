package org.springframework;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.entity.User;
import org.springframework.service.UserService;
public class ApplicationTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        User user = userService.select();
        System.out.println(user.getUsername() + " " + user.getPassword());
    }
}