package org.springframework.beans.factory.support;
import org.springframework.beans.PropertyValues;
/**
 * 通用的 bean 的实现类
 */
public class GenericBeanDefinition extends AbstractBeanDefinition {
    public GenericBeanDefinition() {
        super();
    }
    public GenericBeanDefinition(String id, String name, PropertyValues propertyValues) {
        super(id, name, propertyValues);
    }
}