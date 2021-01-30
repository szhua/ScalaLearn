package org.szhua.org.szhua;


import java.lang.reflect.ParameterizedType;

public class Szhua44<T> {

    public static void main(String[] args) {
        Student sz = new Student();
        Class clazz =sz.getClass();
        System.err.println(clazz);
        ParameterizedType ss = (ParameterizedType) new Szhua44<Integer>(){}.getClass().getGenericSuperclass();
        System.err.println(ss.getActualTypeArguments()[0]);
    }
}
