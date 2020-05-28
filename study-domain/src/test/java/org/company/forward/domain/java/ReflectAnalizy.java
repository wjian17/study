package org.company.forward.domain.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangjian
 * @date 2020/5/28 0028 16:06
 */
 public class ReflectAnalizy {

    public static void main(String[] args) throws Exception {
        new ReflectAnalizy().testReflect();
//        new ReflectAnalizy().test1(1,"333",3);
    }

    //    @Test
    public void testReflect() throws InvocationTargetException, IllegalAccessException {
        Class reflectAnalizy = ReflectAnalizy.class;
        reflectAnalizy = new ReflectAnalizy().getClass();
        try {
            reflectAnalizy = Class.forName("org.company.forward.domain.java.ReflectAnalizy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        list.add("333");
        Method[] methods = reflectAnalizy.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("=====方法"+method.getName()+"参数参数类型");
            Class[] ptype = method.getParameterTypes();
            for(Class c1:ptype){
                System.out.println(c1.getName());
            }
            System.out.println("=================================");
            if ("test".equalsIgnoreCase(method.getName())) {
                System.out.println(method.getName());

                method.invoke(new ReflectAnalizy(), list, "123");
            } else if ("test2".equalsIgnoreCase(method.getName())) {
//                Method method2 = reflectAnalizy.getMethod("test2",new Class[]{List.class});
                method.invoke(new ReflectAnalizy(), new Object[]{list});
                method.invoke(new ReflectAnalizy(), list);
            } else if ("test3".equalsIgnoreCase(method.getName())) {
//                Method method2 = reflectAnalizy.getMethod("test2",new Class[]{List.class});
                method.invoke(new ReflectAnalizy(), new Object[]{list});
            } else if ("test4".equalsIgnoreCase(method.getName())) {
                System.out.println(new Object[]{list,list}.getClass().getName());
//                Method method2 = reflectAnalizy.getMethod("test2",new Class[]{List.class});
                method.invoke(new ReflectAnalizy(), new Object[]{list});
            }

        }
        try {
            Method method = reflectAnalizy.getMethod("test", new Class[]{List.class, String.class});
            System.out.println(method.getName());
            method.invoke(new ReflectAnalizy(), list, "123");
//            Method method2 = reflectAnalizy.getMethod("test2",new Class[]{List.class});
//            method2.invoke(new ReflectAnalizy(),list,list,list);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    public void test(List<Object> list, String method) {
        for (Object obj : list) {
            System.out.println(obj.toString() + "::::::" + method);
        }
    }

    public <T> void test1(T... args) {
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        System.out.println(args);
    }

    public void test2(List<String> args) {

        System.out.println(args);
        for (String string : args) {
            System.out.println("============");
            System.out.println(string + "::::::");
        }
    }
    public <T> void test3(List<T> args) {
        System.out.println(args);
        System.out.println("============");
        for (T string : args) {
            System.out.println(string + "::::::");
        }
    }

    public <T> void test4(T ... args) {
        System.out.println(args.length);
        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        System.out.println(args);
    }
}
