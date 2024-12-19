package org.springframework.beans.factory.support;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.config.BeanDefinition;
/**
 * BeanDefinitionRegistry 的默认简单实现类
 */
public class SimpleBeanDefinitionRegistry implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    public SimpleBeanDefinitionRegistry() {

    }
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
    @Override
    public void removeBeanDefinition(String beanName) throws Exception {
        if (beanDefinitionMap.remove(beanName) == null) {
            throw new Exception(beanName);
        }
    }
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new Exception(beanName);
        }
        return beanDefinition;
    }
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }
    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(String[]::new);
    }
    @Override
    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }
    @Override
    public boolean isBeanNameInUse(String beanName) {
        return containsBeanDefinition(beanName);
    }
}