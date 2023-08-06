package org.abstruck.fabric.fufucraft.fufucraft.common.auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.EventObject;
import java.util.Set;

/**
 * @author Astrack
 * @date 2023/7/19
 */
@Component
@Scope("prototype")
public class VarRegistryEvent extends EventObject {
    private Object bean;
    private Set<Field> fields;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public VarRegistryEvent(Object source,Object bean, Set<Field> fields) {
        super(source);
        this.bean = bean;
        this.fields = fields;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }
}
