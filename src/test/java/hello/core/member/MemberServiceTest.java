package hello.core.member;

import hello.core.AppConfig;
import hello.core.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach //Test실행 전 무조건 실행 시킨다.
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();

    }
    @Test
    void join() {
        //given > 이런게 주어졌을 때
        Member member = new Member(1L, "memberA" ,Gradle.VIP);

        //when > 이렇게 됐을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then > 일케 된다
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
