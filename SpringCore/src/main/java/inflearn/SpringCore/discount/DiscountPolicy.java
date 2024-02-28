package inflearn.SpringCore.discount;

import inflearn.SpringCore.member.Member;

public interface DiscountPolicy {
    int discount (Member member ,int price);
}
