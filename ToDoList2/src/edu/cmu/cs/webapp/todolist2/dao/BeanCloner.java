package edu.cmu.cs.webapp.todolist2.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to clone JavaBeans.
 * @author Jeffrey Eppinger (eppinger@cmu.edu)
 *
 * @param <T>
 */
public class BeanCloner<T> {
    private Constructor<T> constructor;
    private List<Property<T>> propList = new ArrayList<>();
    
    /**
     * Inspects the JavaBean class to find its constructor,
     * its getters and its corresponding setters.
     * @param c the JavaBean class.
     */
    public BeanCloner(Class<T> c) {
        try {
            constructor = c.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new AssertionError("Could not find no-args constructor", e);
        }
        
        for (Method m : c.getDeclaredMethods()) {
            if (m.getName().startsWith("get")) {
                propList.add(new Property<T>(c, m));
            }
        }
    }
    
    /**
     * Clones a JavaBean.
     * @param original Instance of JavaBean to be cloned.
     * @return Cloned copy of original JavaBean.
     */
    public T clone(T original) {
        if (original == null) {
            return null;
        }
        
        T copy;
        try {
            copy = constructor.newInstance();
        } catch (Exception e) {
            throw new AssertionError("Call to constructor has failed", e);
        }
        
        for (Property<T> p : propList) {
            Object value;
            try {
                value = p.getter.invoke(original);
            } catch (Exception e) {
                throw new AssertionError("Call to getter for " + p.propName + " property has failed", e);
            }
            
            try {
                p.setter.invoke(copy, value);
            } catch (Exception e) {
                throw new AssertionError("Call to setter for " + p.propName + " property has failed", e);
            }
        }
        
        return copy;
    }
    
    private static class Property<T> {
        Method   getter;
        Method   setter;
        String   propName;
        Class<?> propType;
        
        Property(Class<T> c, Method getter) {
            this.getter = getter;
            propName = getter.getName().substring(3);
            propType = getter.getReturnType();
            
            try {
                setter = c.getMethod("set" + propName, propType);
            } catch (NoSuchMethodException e) {
                throw new AssertionError("Could not find set"
                        + propName + "(" + propType.getName() + ")",
                        e);
            }
        }
    }
}
