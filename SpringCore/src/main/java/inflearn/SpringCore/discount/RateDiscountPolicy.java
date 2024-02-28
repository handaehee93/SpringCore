package inflearn.SpringCore.discount;

import inflearn.SpringCore.member.Grade;
import inflearn.SpringCore.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPolicy = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPolicy/100;
        } else {
            return 0;
        }
    }
}
