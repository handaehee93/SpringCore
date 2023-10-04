package springcore.core.member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springcore.core.AppConfig;

class MemberServiceTest {
    MemberService memberService;
    // @BeforeEach는 각각의 테스트 메서드 실행 전에 실행되게 하는 역할을 한다.
    @BeforeEach
    public void beforeEach () {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given 이런 환경이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when 이렇게 하면
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then 이렇게 된다. import org.assertj.core.api.Assertions;를 import한것
        // member와 findMember랑 같냐고 묻는 것
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
