package inflearn.SpringCore.order;

import inflearn.SpringCore.discount.DiscountPolicy;
import inflearn.SpringCore.discount.FixDiscountPolicy;
import inflearn.SpringCore.discount.RateDiscountPolicy;
import inflearn.SpringCore.member.Member;
import inflearn.SpringCore.member.MemberRepository;
import inflearn.SpringCore.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // 여기도 MemberServiceImpl과 마찬가지로 추상화에만 의존하지 않고 구체화에도 의존하고 있다.
    // DIP라는 객체 지향의 원칙 중 하나를 위반하고 있는 것이다.
    // DIP를 위반하고 있기 때문에 할인 정책이 변경되어 FixDiscountPolicy에서 RateDiscountPolicy로 바꾸는 순간
    // 클라이언트인 OrderServiceImpl의 코드가 수정되는 것이기 때문에 OCP원칙도 위반하게 된다.
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
