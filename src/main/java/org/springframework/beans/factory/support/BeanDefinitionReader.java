package org.springframework.beans.factory.support;
public interface BeanDefinitionReader {
    /**
     * 获取 BeanDefinitionRegistry 对象
     */
    BeanDefinitionRegistry getRegistry();
    /**
     * 加载 XML 配置文件
     */
    void loadBeanDefinitions(String location) throws Exception;
}