package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static hello.core.member.Grade.VIP;
import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {

    MemberService memberService ;
    @BeforeEach // 각각의 test를 실행하기전에 무조건 실행
    @DisplayName("로그인 테스트1") // 이거는 출력 안됨
    public void beforeEach(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService=applicationContext.getBean("memberService", MemberService.class);
//        AppConfig appConfig=new AppConfig();
//        memberService=appConfig.memberService();
    }
    @Test
    @DisplayName("로그인 테스트")
    void join() {
        //given
        Member member = new Member(VIP, 1L, "Brian");

        //when
        memberService.join(member);
        Member findMember=memberService.findMember(1L);
        //then
        assertThat(member).isEqualTo(findMember);

    }
}
