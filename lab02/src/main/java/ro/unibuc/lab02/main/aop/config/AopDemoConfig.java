package ro.unibuc.lab02.main.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ro.unibuc.lab02.main.aop")
@EnableAspectJAutoProxy
public class AopDemoConfig {
}
