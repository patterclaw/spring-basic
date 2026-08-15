package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class PrototypeBeanTest {
    @Test//프로토타입 스코프의 빈은 스프링 컨테이너에서 빈을 조회할 때 생성되고, 초기화 메서드도 실행된다
    void prototypeBeanTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(BeanTest2.class);
        System.out.println("find bean1");
        BeanTest2 bean1 = ac.getBean(BeanTest2.class);
        System.out.println("find bean2");
        BeanTest2 bean2 = ac.getBean(BeanTest2.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        Assertions.assertThat(bean1).isNotSameAs(bean2);
        ac.close(); //실행이 안됨
    }

    @Scope("prototype")
    @Component
    static class BeanTest2 {
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
