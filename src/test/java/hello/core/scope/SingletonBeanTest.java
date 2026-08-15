package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.Annotation;

public class SingletonBeanTest {
    @Test
    void SingletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanTest.class);
        BeanTest bean1=ac.getBean(BeanTest.class);
        BeanTest bean2=ac.getBean(BeanTest.class);
        System.out.println(bean1);
        System.out.println(bean2);
        Assertions.assertThat(bean1).isSameAs(bean2);
        ac.close();
    }
    @Scope("singleton")
    @Component
    static class BeanTest {
        @PostConstruct
        public void init() {
            System.out.println("singletonBean init");

        }

        @PreDestroy
        public void destroy() {
            System.out.println("singletonBean destroy");
        }
    }
}
