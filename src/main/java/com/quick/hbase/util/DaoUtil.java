package com.quick.hbase.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DaoUtil {

    public static List<String> getAttributes(Class myClass) throws Exception {
        List<String> result = new ArrayList<>();
        List<Method> methods = getGetterList(myClass);
        for (Method method : methods) {
            result.add(getParameterName(method));
        }
        return result;
    }

    public static List<Method> getGetterList(Class myClass) throws Exception {
        Method[] methods = myClass.getMethods();
        List<Method> getters = new ArrayList<>();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (!method.getName().equals("getClass") && !method.getReturnType().getName().equals("java.util.List") && method.getName().startsWith("get")) {
                getters.add(method);
            }

        }

        return getters;
    }

    public static String getParameterName(Method methodGetter) {
        return (methodGetter.getName().substring(3).charAt(0) + "").toLowerCase() + methodGetter.getName().substring(4);
    }
}
