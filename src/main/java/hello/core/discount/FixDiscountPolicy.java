package hello.core.discount;

import hello.core.member.Gradle;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int privce) {
        if(member.getGradle() == Gradle.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
