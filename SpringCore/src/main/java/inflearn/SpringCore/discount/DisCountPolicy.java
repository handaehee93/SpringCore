package inflearn.SpringCore.discount;

import inflearn.SpringCore.member.Member;

public interface DisCountPolicy {
    int discount (Member member ,int price);
}
