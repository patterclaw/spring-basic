package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    @Test
    @DisplayName("호출할때마다 객체 생성")
    void pureContainer()
    {
        AppConfig appConfig = new AppConfig();
        MemberService memberService1=appConfig.memberService();
        MemberService memberService2=appConfig.memberService();
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 테스트")
    void 싱글톤_테스트() {
        SingletonService single1 = SingletonService.getInstance();
        SingletonService single2 = SingletonService.getInstance();
        System.out.println("single1 = " + single1);
        System.out.println("single2 = " + single2);
        assertThat(single1).isSameAs(single2);
    }

    @Test
    @DisplayName("스프링 컨테이너 이용")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        assertThat(memberService1).isSameAs(memberService2);
    }
}
