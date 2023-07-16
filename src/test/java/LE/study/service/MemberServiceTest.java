package LE.study.service;

import LE.study.domain.Member;
import LE.study.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
//    MemberService memberService = new MemberService();
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
//    //원본
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given (어떤 상황, 기반이 주어졌을 때)
        Member member = new Member();
        member.setName("hello");

        //when  (이걸 실행했을 떄)
        Long saveId = memberService.join(member);

        //then  (이런 결과가 나와야 돼)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

/*
        //원본
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //(1 ,2 ) 오른쪽(2)을 실행할거고, 왼쪽(1)이 나와야 한다는 뜻
*/
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //실제로 메세지가 같은건지 (='정확한지') 확인해주겠다

/*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
*/

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}