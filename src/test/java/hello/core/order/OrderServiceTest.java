package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceTest {
    OrderService orderService ;
    MemberService memberService ;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService=appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        Member member = new Member(Grade.VIP, 1L, "brian");
        Member member2 = new Member(Grade.BASIC, 2L, "Andrew");
        memberService.join(member);
        memberService.join(member2);
        Order order = orderService.CreateOrder(1L, "itemA", 20000);
        Order order2 = orderService.CreateOrder(2L, "itemB", 30000);

        assertThat(order.getDiscountPrice()).isEqualTo(2000);
        assertThat(order2.getDiscountPrice()).isEqualTo(0);
    }
}
