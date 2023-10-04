package springcore.core.order;


import springcore.core.discount.DiscountPolicy;
import springcore.core.member.Member;
import springcore.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {
    // 서비스는 Repository랑 할인 정책이 필요하다.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
