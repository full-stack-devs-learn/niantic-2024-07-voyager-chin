package com.niantic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@SuppressWarnings("ALL")
public class ReflectionBase<T>
{
    public Constructor<T> getConstructor(Class<T> klass, Class<?>... parameterTypes) {
        try {
            return (Constructor<T>) klass.getConstructor(parameterTypes);
        } catch (Exception e) {
            return null;
        }
    }

    public Method getMethod(Class<T> klass, String methodName, Class<?>... parameterTypes) {
        try {
            //getMethod returns public methods whether they were declared in class or inherited.
            if (parameterTypes == null) {
                return klass.getMethod(methodName);
            } else {
                Class<?>[] types = new Class[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    types[i] = parameterTypes[i];
                }
                return klass.getMethod(methodName, types);
            }
        } catch (Exception e) {
            return null;
        }
    }
}
