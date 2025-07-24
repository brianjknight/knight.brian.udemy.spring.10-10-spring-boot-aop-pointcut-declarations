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

    // Pointcut Declaration to match dao getters
    @Pointcut("execution(* knight.brian.spring.boot.aopdemo.dao.*.get*(..))")
    private void getter() {}

    // Pointcut Declaration to match dao setters
    @Pointcut("execution(* knight.brian.spring.boot.aopdemo.dao.*.set*(..))")
    private void setter() {}

    // Combining declarations dao methods that are NOT getters or setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterNoSetter() {}

    @Before("forDaoPackageNoGetterNoSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before on a DAO method");
    }

//    @Before("forDaoPackage()")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=====>>> Executing @Before on a DAO method");
//    }

    @Before("forDaoPackageNoGetterNoSetter()")
    public void performApiAnalytics() {
        System.out.println("=====>>> Performing API analytics");
    }

}
