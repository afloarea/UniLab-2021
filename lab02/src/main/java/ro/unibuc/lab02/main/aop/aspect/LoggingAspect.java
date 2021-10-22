package ro.unibuc.lab02.main.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* ro.unibuc.lab02.main.aop.services..*(..))")
    public void logInputParams(JoinPoint joinPoint) {
        System.out.println("Calling method %s from %s with params %s".formatted(
                joinPoint.getSignature().getName(),
                joinPoint.getTarget().getClass(),
                Arrays.deepToString(joinPoint.getArgs())
        ));
    }

    @Around("execution(* ro.unibuc.lab02.main.aop.services..*Drink*(..))")
    public Object warnAboutDrinking(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Drinking involved");
        final var result = joinPoint.proceed();
        System.out.println("Drinking call done");
        return result;
    }

}
