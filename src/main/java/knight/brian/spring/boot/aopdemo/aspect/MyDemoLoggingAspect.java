package knight.brian.spring.boot.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // Pointcut Declaration to match any class and method (zero or more args) in the dao Package
    @Pointcut("execution(* knight.brian.spring.boot.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before on a DAO method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("=====>>> Performing API analytics");
    }

}
