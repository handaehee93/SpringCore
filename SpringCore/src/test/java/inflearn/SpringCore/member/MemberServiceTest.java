package inflearn.SpringCore.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {


    @Test
    void join () {
        // member 객체 생성 하고
        Member member = new Member(1L, "memberA", Grade.VIP);
        // 서비스를 가져 온다.
        MemberService memberService = new MemberServiceImpl();

        // 가져온 서비스에서 회원을 가입 시키고, 해당 회원을 다시 찾아 본다.
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // 가입한 회원과 찾은 회원을 비교한다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
