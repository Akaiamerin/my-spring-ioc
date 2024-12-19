package org.springframework.beans.factory.support;
/**
 * 实现了 BeanDefinitionReader 接口的基础抽象类
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }
    @Override
    public final BeanDefinitionRegistry getRegistry() {
        return registry;
    }
}