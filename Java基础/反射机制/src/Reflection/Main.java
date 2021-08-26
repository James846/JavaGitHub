package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args)throws Exception{
        Class<?> TargetClass=Class.forName("Reflection.TargetObject");
        TargetObject targetObject=(TargetObject)TargetClass.newInstance();
        Method[] methods=TargetClass.getDeclaredMethods();
        for(Method method :methods){
            System.out.println(method.getName());
        }
        //调用指定方法
        Method publicMethod = TargetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(targetObject, "JavaGuide");
        Field field = TargetClass.getDeclaredField("value");
        //为了对类中的参数进行修改我们取消安全检查
        field.setAccessible(true);
        field.set(targetObject, "JavaGuide");
    }
}
