package kr.co.fastcampus.cli.app;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;


public class Main {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(new RetryAdvice());

        Pojo pojo = (Pojo) factory.getProxy();
        System.out.println(">>>");
        pojo.foo();
        System.out.println(">>>");

    }
}

class RetryAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object proceed = methodInvocation.proceed();
        return proceed;
    }
}
interface Pojo{
    void foo();
}
class SimplePojo implements Pojo {

    public void foo() {
        System.out.println("run foo");
    }

}