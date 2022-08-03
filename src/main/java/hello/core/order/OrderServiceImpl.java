package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //추상 + 구체에도 의존 DIP 위반 / 단일 책임X
    // private  final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //새로운 할인정책으로 수정 / OCP 위반

    //Interface에만 의존
    private final MemberRepository memberRepository; //DIP 지킴
    private final DiscountPolicy discountPolicy; //DIP를 지킴

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 주문이 들어오면 멤버를 확인하고
        int discountPrice = discountPolicy.discount(member, itemPrice); // 할인정책을 확인해서 할인 함

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
