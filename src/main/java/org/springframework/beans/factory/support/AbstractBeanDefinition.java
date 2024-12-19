package org.springframework.beans.factory.support;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
/**
 * 实现了 BeanDefinition 接口的基础抽象类
 */
public abstract class AbstractBeanDefinition implements BeanDefinition {
    private String id;
    private String className;
    private PropertyValues propertyValues;
    public AbstractBeanDefinition() {

    }
    public AbstractBeanDefinition(String id, String className, PropertyValues propertyValues) {
        this.id = id;
        this.className = className;
        this.propertyValues = propertyValues;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getClassName() {
        return className;
    }
    @Override
    public void setClassName(String name) {
        this.className = name;
    }
    @Override
    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
    @Override
    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}