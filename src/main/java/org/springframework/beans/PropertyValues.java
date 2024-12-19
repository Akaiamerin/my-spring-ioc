package org.springframework.beans;
public interface PropertyValues extends Iterable<PropertyValue> {
    /**
     * 获取所有的 PropertyValue 对象
     */
    PropertyValue[] getPropertyValues();
    /**
     * 根据 name 属性获取 PropertyValue 对象
     */
    PropertyValue getPropertyValue(String propertyName);
    /**
     * 修改 old 之后所有的 PropertyValue，子类必须实现重写 equals 方法
     */
    PropertyValues changesSince(PropertyValues old);
    /**
     * 判断容器是否包含指定的 name 属性的 PropertyValue 对象
     */
    boolean contains(String propertyName);
    /**
     * 判断容器是否为空
     */
    boolean isEmpty();
}