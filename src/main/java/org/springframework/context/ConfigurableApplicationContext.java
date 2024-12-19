package org.springframework.context;
/**
 * 配置应用程序上下文功能
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 启动方法（在后面的创建容器方法，该方法当做容器创建方法），如果失败了，所有实例都会被销毁
     * 在调用此方法之后，成功则实例化所有单例，失败则根本不实例化
     */
    void refresh() throws Exception;
}