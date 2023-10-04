package springcore.core.member;

public class MemberServiceImpl implements MemberService{

    // 회원 가입,  찾기를 하려면 데이터 저장소가 필요하다.
    // 따라서 MemberRepository라는 인터페이스를 따르는 것들 중 MemoryMemberRepository라는 구현체의 인스턴스 생성
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    // 생성한 MemoryMemberRepository안의 메서드를 활용하여 저장하고 조회
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
