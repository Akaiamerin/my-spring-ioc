package org.springframework.context.support;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ConfigurableApplicationContext;
/**
 * 实现了 ConfigurableApplicationContext 接口的抽象类，非延迟加载
 */
public abstract class AbstractApplicationContext implements ConfigurableApplicationContext {
    protected String location;
    private BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(new SimpleBeanDefinitionRegistry());
    private Map<String, Object> singletonObjectMap = new HashMap<>();
    @Override
    public Object getBean(String name) throws Exception {
        Object obj = singletonObjectMap.get(name);
        if (obj != null) {
            return obj;
        }
        BeanDefinitionRegistry beanDefinitionRegistry = beanDefinitionReader.getRegistry();
        BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(name);
        String className = beanDefinition.getClassName();
        Class<?> clazz = Class.forName(className);
        obj = clazz.getDeclaredConstructor().newInstance();
        PropertyValue[] propertyValueArr = beanDefinition.getPropertyValues().getPropertyValues();
        for (int i = 0; i < propertyValueArr.length; i++) {
            PropertyValue currentpropertyValue = propertyValueArr[i];
            String propertyName = currentpropertyValue.getName();
            String propertyValue = currentpropertyValue.getValue();
            String propertyRef = currentpropertyValue.getRef();
            Method[] methodArr = clazz.getDeclaredMethods();
            String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1, propertyName.length());
            if (propertyValue != null && propertyValue.length() > 0) {
                for (int j = 0; j < methodArr.length; j++) {
                    if (Objects.equals(methodArr[j].getName(), methodName) == true) {
                        methodArr[j].invoke(obj, propertyValue);
                        break;
                    }
                }
            }
            if (propertyRef != null && propertyRef.length() > 0) {
                Object refObj = getBean(propertyRef);
                for (int j = 0; j < methodArr.length; j++) {
                    if (Objects.equals(methodArr[j].getName(), methodName) == true) {
                        methodArr[j].invoke(obj, refObj);
                        break;
                    }
                }
            }
        }
        singletonObjectMap.put(name, obj);
        return obj;
    }
    @Override
    public <T> T getBean(String name, Class<? extends T> requiredType) throws Exception {
        Object obj = getBean(name);
        if (obj != null) {
            return requiredType.cast(obj);
        }
        return null;
    }
    @Override
    public void refresh() throws Exception {
        beanDefinitionReader.loadBeanDefinitions(location);
        BeanDefinitionRegistry beanDefinitionRegistry = beanDefinitionReader.getRegistry();
        String[] beanDefinitionNameArr = beanDefinitionRegistry.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNameArr.length; i++) {
            getBean(beanDefinitionNameArr[i]);
        }
    }
}