package org.springframework.beans.factory.support;
import org.springframework.beans.factory.config.BeanDefinition;
public interface BeanDefinitionRegistry {
    /**
     * 注册 BeanDefinition 对象
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception;
    /**
     * 移除 BeanDefinition 对象
     */
    void removeBeanDefinition(String beanName) throws Exception;
    /**
     * 根据 id 获取 BeanDefinition 对象
     */
    BeanDefinition getBeanDefinition(String beanName) throws Exception;
    /**
     * 判断容器中是否包含指定 id 的 BeanDefinition 对象
     */
    boolean containsBeanDefinition(String beanName);
    /**
     * 获取所有的 BeanDefinition 对象名
     */
    String[] getBeanDefinitionNames();
    /**
     * 获取 BeanDefinition 对象的个数
     */
    int getBeanDefinitionCount();
    /**
     * 判断包含指定 id 的 BeanDefinition 对象是否在使用
     */
    boolean isBeanNameInUse(String beanName);
}