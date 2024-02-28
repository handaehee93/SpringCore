package inflearn.SpringCore.order;

import inflearn.SpringCore.discount.DiscountPolicy;
import inflearn.SpringCore.discount.FixDiscountPolicy;
import inflearn.SpringCore.discount.RateDiscountPolicy;
import inflearn.SpringCore.member.Member;
import inflearn.SpringCore.member.MemberRepository;
import inflearn.SpringCore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 주문이 들어오면 저장된 회원을 가져와 할인 정책에 전달하면
        // 거기서 등급 확인 후 할인된 금액을 전달 받는다.
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
