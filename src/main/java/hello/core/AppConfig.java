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

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()  > 각각 다른 객체 2개 생성이 된다
    //singleton이 깨지는 거 아닝가



    //여기에서 객체 생성과 연결을 담당한다
    //MemberserviceImpl/ memoryMemberRepository도 생성해서 연결 시켜준다

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService


@Configuration //설정정보고 았는 곳에 모두 붙이면 싱글톤 보장 가능
public class AppConfig {
    //스프링 빈 조회 시 동일한 타입이 둘 이상일 경우 에러남 > 빈 이름 지정
    //
    @Bean //각메써드에 Bean을 적어주면 spring container에 해당 매써드가 등록됨
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); //생성자 주입
    }
    @Bean
    public  MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
       //return new FixDiscountPolicy(); // 할인정책을 변경할 땐 이부분만 변경하면 된다 / OCP 만족
        return new RateDiscountPolicy();
    }

}
