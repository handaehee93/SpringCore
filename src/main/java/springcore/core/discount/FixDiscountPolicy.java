package springcore.core.discount;

import springcore.core.member.Grade;
import springcore.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
//        enum타입은 == 으로 비교하는 것이 맞다.
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
