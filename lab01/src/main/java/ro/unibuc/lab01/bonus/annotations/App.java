package ro.unibuc.lab01.bonus.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class App {

    public static void main(String[] args) throws ReflectiveOperationException {

        invokeAnnotated(new PlainConfig(), new CustomConfigClass());

    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyConfiguration {}

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Invokeable {}

    public static class CustomConfigClass {

        public void method1() {
            System.out.println("called method 1");
        }

        @Invokeable
        public void method2() {
            System.out.println("called method 2");
        }

    }

    @MyConfiguration
    public static class PlainConfig {

        @Invokeable
        public void method3() {
            System.out.println("called method 3");
        }

        public void method4() {
            System.out.println("called method 4");
        }
    }

    public static void invokeAnnotated(Object... objects) throws ReflectiveOperationException {
        for (var obj : objects) {
            final var currentClass = obj.getClass();
            if (currentClass.isAnnotationPresent(MyConfiguration.class)) {
                for (var method : currentClass.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(Invokeable.class)) {
                        method.invoke(obj);
                    }
                }
            }
        }
    }

}
