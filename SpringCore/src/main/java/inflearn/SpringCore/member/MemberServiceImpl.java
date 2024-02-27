package inflearn.SpringCore.member;

public class MemberServiceImpl implements MemberService {
    /*
    * 테스트는 정상적으로 통과 되었지만 지금 객체 지향의 원칙을 위반하고 있다.
    * 객체 지향의 원칙 중 의존 관계 역전 원칙인 DIP를 위반하고 있는데 그 이유는 아래를 보면
    * MemberRepository라는 인터페이스 즉, 추상화에도 의존하고 있고 MemoryMemberRepository
    * 라는 구현체 즉, 구체화에도 의존하고 있기 때문이다.
    * 추상화에만 의존해야 하는 DIP원칙을 위반하고 있는 것.
    * */

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
