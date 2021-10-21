package ro.unibuc.lab02.bonus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxyDemo {

    public static void main(String[] args) {
        // create a proxy that adds additional functionality
        final CapitalizationService capitalizationService = (CapitalizationService) Proxy.newProxyInstance(
                JdkDynamicProxyDemo.class.getClassLoader(),
                BasicCapitalizationService.class.getInterfaces(),
                new WarningInvocationHandler(new BasicCapitalizationService()));

        System.out.println(capitalizationService.capitalize("Papagal"));

    }

    private interface CapitalizationService {

        String capitalize(String original);

    }

    private static class BasicCapitalizationService implements CapitalizationService {

        @Override
        public String capitalize(String original) {
            if (original == null || original.length() < 1) {
                return original;
            }
            return Character.toUpperCase(original.charAt(0)) + original.substring(1);
        }
    }

    private static final class WarningInvocationHandler implements InvocationHandler {

        private final Object target;

        public WarningInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (args.length >= 1 && args[0] instanceof String param
                    && param.length() >= 1 && Character.isUpperCase(param.charAt(0))) {

                System.out.println("Warning - parameter is capitalized");
            }

            return method.invoke(target, args);
        }
    }

}
