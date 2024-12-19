package org.springframework.beans;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
/**
 * 存储多个 PropertyValue 对象的容器
 */
public class MutablePropertyValues implements PropertyValues {
    private final List<PropertyValue> propertyValueList;
    public MutablePropertyValues() {
        this.propertyValueList = new ArrayList<>();
    }
    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        if (propertyValueList != null) {
            this.propertyValueList = propertyValueList;
        }
        else {
            this.propertyValueList = new ArrayList<>();
        }
    }
    /**
     * 添加 PropertyValue 对象
     * @return this 返回自身以实现链式编程
     */
    public MutablePropertyValues addPropertyValue(PropertyValue PropertyValue) {
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue currentPropertyValue = propertyValueList.get(i);
            if (Objects.equals(currentPropertyValue.getName(), PropertyValue.getName()) == true) {
                propertyValueList.set(i, PropertyValue);
                return this;
            }
        }
        propertyValueList.add(PropertyValue);
        return this;
    }
    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }
    @Override
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(PropertyValue[]::new);
    }
    @Override
    public PropertyValue getPropertyValue(String propertyName) {
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue currentPropertyValue = propertyValueList.get(i);
            if (Objects.equals(currentPropertyValue.getName(), propertyName) == true) {
                return currentPropertyValue;
            }
        }
        return null;
    }
    @Override
    public PropertyValues changesSince(PropertyValues old) {
        return null;
    }
    @Override
    public boolean contains(String propertyName) {
        return getPropertyValue(propertyName) != null;
    }
    @Override
    public boolean isEmpty() {
        return propertyValueList.isEmpty();
    }
}