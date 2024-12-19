package org.springframework.context.support;
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    public ClassPathXmlApplicationContext(String location) throws Exception {
        this.location = location;
        refresh();
    }
}