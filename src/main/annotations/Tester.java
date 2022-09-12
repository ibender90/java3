package annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tester {

    public static void start(Class inputClass) {

        boolean BeforeSuitAnnotationIsFound = false;
        boolean AfterSuitAnnotationIsFound = false;

        Method[] methods = inputClass.getDeclaredMethods();

        for (Method method : methods) { //проверяю, что аннотации BeforeSuit & AfterSuit в единственном экземляре
            if (method.getAnnotation(BeforeSuit.class) != null) {
                if(BeforeSuitAnnotationIsFound){
                    throw new RuntimeException();
                }
                BeforeSuitAnnotationIsFound = true;
            }
            if (method.getAnnotation(AfterSuit.class) != null) {
                if(AfterSuitAnnotationIsFound){
                    throw new RuntimeException();
                }
                AfterSuitAnnotationIsFound = true;

            }
        }
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuit.class) != null) {
                try {
                    method.invoke(inputClass);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        int priority = 1;
        while (priority <= 10) {
            for (Method method : methods) {
                if (method.isAnnotationPresent(TestAnn.class)) {
                    if (method.getAnnotation(TestAnn.class).priority() == priority) {
                        try {
                            method.invoke(inputClass);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            priority++;
        }

        for (Method method : methods) {
            if (method.getAnnotation(AfterSuit.class) != null) {
                try {
                    method.invoke(inputClass);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
