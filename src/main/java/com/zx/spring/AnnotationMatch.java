package com.zx.spring;

import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

public class AnnotationMatch {

    public static void main(String[] args) throws NoSuchMethodException {
        StaticMethodMatcherPointcut pointcut = new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> aClass) {
                /*//查看方法上是否匹配注解
                MergedAnnotations annotations = MergedAnnotations.from(method);
                if (annotations.isPresent(Transactional.class)) {
                    return true;
                }
                //查看类上是否匹配注解
                annotations = MergedAnnotations.from(aClass);
                if (annotations.isPresent(Transactional.class)) {
                    return true;
                }*/
                //从类的继承树上找有没有匹配的注解
                MergedAnnotations from = MergedAnnotations.from(dazuh.class, MergedAnnotations.SearchStrategy.TYPE_HIERARCHY);
                if (from.isPresent(Transactional.class)) {
                    return true;
                }
                return false;
            }
        };
        System.out.println(pointcut.matches(bar.class.getMethod("bar"), bar.class));
    }


    @Transactional
    static class foo {
    }

    static class bar {
        @Transactional
        public void bar() {
        }
    }

    @Transactional
    interface xiaopang {
        void hello();
    }

    static class dazuh implements xiaopang {

        @Override
        public void hello() {

        }
    }

}
