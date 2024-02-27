package inflearn.SpringCore;

import inflearn.SpringCore.member.Grade;
import inflearn.SpringCore.member.Member;
import inflearn.SpringCore.member.MemberService;
import inflearn.SpringCore.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("가입한 회원" + member.getName());
        System.out.println("찾은 회원" + findMember.getName());
    }
}
