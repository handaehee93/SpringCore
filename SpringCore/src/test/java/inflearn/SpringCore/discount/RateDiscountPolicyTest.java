package inflearn.SpringCore.discount;

import inflearn.SpringCore.member.Grade;
import inflearn.SpringCore.member.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%의 할인이 적용된다")
    void vipMember () {
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        int discount = rateDiscountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않는다")
    void basicMember () {
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);
        int discount = rateDiscountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }

}