package org.springframework.beans.factory;
/**
 * IOC 容器的父接口
 */
public interface BeanFactory {
    /**
     * 根据 bean 对象的名称获取 bean 对象
     */
    Object getBean(String name) throws Exception;
    /**
     * 根据 bean 对象的名称获取 bean 对象并进行类型转换
     */
    <T> T getBean(String name, Class<? extends T> requiredType) throws Exception;
}