package partthree.lesson7;

import javafx.collections.transformation.SortedList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MyTest {
    public static void main(String[] args) {
        start(TestClass.class);
    }

    public static void start(Class tc){
        Method[] methods = tc.getDeclaredMethods();
        int count = 0;
        List<Method> testMethods = new ArrayList<>();
        for (Method m : methods
             ) {
            if(m.isAnnotationPresent(BeforeSuite.class)){
                count++;
            }
            if(count > 1){
                throw new RuntimeException("Класс может содержать только один метод с аннотацией BeforeSuite");
            } else {
                count = 0;
            }
            if(m.isAnnotationPresent(AfterSuite.class)){
                count++;
            }
            if(count > 1){
                throw new RuntimeException("Класс может содержать только один метод с аннотацией AfterSuite");
            } else {
                count = 0;
            }

            if(m.isAnnotationPresent(Test.class)){
                testMethods.add(m);
            }
        }
        testMethods.sort((o1, o2) -> o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority());

        for (Method m: methods
             ) {
            if(m.isAnnotationPresent(BeforeSuite.class)){
                try {
                    m.invoke(null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        for (Method m : testMethods
             ) {
            try {
                m.invoke(null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        for (Method m: methods
        ) {
            if(m.isAnnotationPresent(AfterSuite.class)){
                try {
                    m.invoke(null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
