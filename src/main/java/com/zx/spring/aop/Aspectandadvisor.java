package com.zx.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Aspectandadvisor {

    //高级切面
    @Aspect
    static class Aspect1 {
        @Before("execution(* com.zx.spring.aop.Aspectandadvisor.foo())")
        public void before() {
            System.out.println("before.........");
        }

        @After("execution(* com.zx.spring.aop.Aspectandadvisor.bar())")
        public void after() {
            System.out.println("after.........");
        }
    }

    public void foo() {
        System.out.println("foo....");
    }

    public void bar() {
        System.out.println("bar....");
    }

    @Configuration
    static class Config {
        @Bean
        public Advisor advisor(MethodInterceptor advisor3) {
            AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
            pointcut.setExpression("execution(* com.zx.spring.aop.Aspectandadvisor.foo())");
            return new DefaultPointcutAdvisor(pointcut, advisor3);
        }

        @Bean
        //环绕通知
        public MethodInterceptor advisor3() {
            return new MethodInterceptor() {
                @Nullable
                @Override
                public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
                    System.out.println("before invoke.....");
                    Object result = invocation.proceed();
                    System.out.println("after invoke.....");
                    return result;
                }
            };
        }
    }

    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        context.registerBean("Aspectandadvisor", Aspectandadvisor.class);
        context.registerBean("Config", Config.class);
        //加一个bean工厂后处理器去处理@Bean
        context.registerBean(ConfigurationClassPostProcessor.class);

        //在Bean的创建--->（1）依赖注入--->初始化（2）两个地方有机会执行bean后处理器增强  从而收集切面类创建代理对象
        context.registerBean(AnnotationAwareAspectJAutoProxyCreator.class);

        context.refresh();
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
}

