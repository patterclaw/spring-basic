package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutoWiredTest {
    @Test
    void autoWiredOption() {
        ApplicationContext ac=new AnnotationConfigApplicationContext(TestBean.class);
    }
    static class TestBean {
        @Autowired(required = false)
        public void setBean1(Member member) {
            System.out.println("member = " + member);
        }
        @Autowired
        public void setBean2(@Nullable Member member2){
            System.out.println("member2 = " + member2);

        }

        @Autowired(required = false)
        public void setBean3(Optional<Member>  member3) {
            System.out.println("member3 = " + member3);

        }
    }
}