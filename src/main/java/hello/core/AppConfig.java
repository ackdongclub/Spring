package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//여기에서 객체 생성과 연결을 담당한다
//MemberserviceImpl/ memoryMemberRepository도 생성해서 연결 시켜준다

@Configuration //구성정보
public class AppConfig {
    @Bean //각메써드에 Bean을 적어주면 spring container에 해당 매써드가 등록됨
    public MemberService memberService() {

        return new MemberServiceImpl(memberRepository()); //생성자 주입
    }
    @Bean
    public  MemoryMemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
       //return new FixDiscountPolicy(); // 할인정책을 변경할 땐 이부분만 변경하면 된다 / OCP 만족
        return new RateDiscountPolicy();
    }
}
