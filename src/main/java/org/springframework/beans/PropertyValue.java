package org.springframework.beans;
/**
 * <bean> 下的 <property>
 * <property name="name" value="value"></property>
 * <property name="name" ref="ref"></property>
 */
public class PropertyValue {
    private String name;
    private String value;
    private String ref;
    public PropertyValue() {

    }
    public PropertyValue(String name, String value, String ref) {
        this.name = name;
        this.value = value;
        this.ref = ref;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
}