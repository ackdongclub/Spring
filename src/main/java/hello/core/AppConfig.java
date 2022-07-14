package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//여기에서 객체 생성과 연결을 담당한다
//MemberserviceImpl/ memoryMemberRepository도 생성해서 연결 시켜준다
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository()); //생성자 주입
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
       //return new FixDiscountPolicy(); // 할인정책을 변경할 땐 이부분만 변경하면 된다 / OCP 만족
        return new RateDiscountPolicy();
    }
}
