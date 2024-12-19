package org.springframework.beans.factory.config;
import org.springframework.beans.PropertyValues;
public interface BeanDefinition {
    /**
     * <bean> 的 id
     */
    String getId();
    void setId(String id);
    /**
     * <bean> 的 class
     */
    String getClassName();
    void setClassName(String name);
    /**
     * <bean> 下的 <property>
     */
    PropertyValues getPropertyValues();
    void setPropertyValues(PropertyValues propertyValues);
}