package org.springframework.beans.factory.xml;
import java.io.InputStream;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
/**
 * 解析 XML 文件的实现类
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }
    @Override
    public void loadBeanDefinitions(String location) throws Exception {
        SAXReader reader = new SAXReader();
        InputStream is = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(location);
        Document doc = reader.read(is);
        Element rootElem = doc.getRootElement();
        //获取 <bean>
        List<Element> beanElemList = rootElem.elements("bean");
        for (int i = 0; i < beanElemList.size(); i++) {
            Element beanElem = beanElemList.get(i);
            //获取 <bean> 的 id 属性
            String beanId = beanElem.attributeValue("id");
            //获取 <bean> 的 class 属性
            String beanName = beanElem.attributeValue("class");
            //获取 <bean> 下的 <property>
            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
            List<Element> propertyElemList = beanElem.elements("property");
            for (int j = 0; j < propertyElemList.size(); j++) {
                Element propertyElem = propertyElemList.get(j);
                //获取 <property> 的 name
                String propertyName = propertyElem.attributeValue("name");
                //获取 <property> 的 value
                String propertyValue = propertyElem.attributeValue("value");
                //获取 <property> 的 ref
                String propertyRef = propertyElem.attributeValue("ref");
                mutablePropertyValues.addPropertyValue(new PropertyValue(propertyName, propertyValue, propertyRef));
            }
            AbstractBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setId(beanId);
            beanDefinition.setClassName(beanName);
            beanDefinition.setPropertyValues(mutablePropertyValues);
            getRegistry().registerBeanDefinition(beanId, beanDefinition);
        }
    }
}