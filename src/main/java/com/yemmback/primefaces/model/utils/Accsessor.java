package com.yemmback.primefaces.model.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class Accsessor {

    public static void callSetter(Object obj, String fieldName, Object value){
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(fieldName, obj.getClass());
            pd.getWriteMethod().invoke(obj, value);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | java.beans.IntrospectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void callGetter(Object obj, String fieldName){
        PropertyDescriptor pd;
        try {
            pd = new PropertyDescriptor(fieldName, obj.getClass());
            System.out.println("" + pd.getReadMethod().invoke(obj));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | java.beans.IntrospectionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
