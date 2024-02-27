package inflearn.SpringCore.discount;

import inflearn.SpringCore.member.Grade;
import inflearn.SpringCore.member.Member;

public class FixDiscountPolicy implements DisCountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
