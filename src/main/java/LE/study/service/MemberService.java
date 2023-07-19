package LE.study.service;

import LE.study.domain.Member;
import LE.study.repository.MemberRepository;
import LE.study.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {        //cmd + Shift + T = 새 테스트 추출
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    //원본

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //DI (dependency Injection): 외부에서 넣어주는 것

    /**
     * 회원 가입
     */
    public Long join(Member member) {

        validateDuplicateMember(member); //중복 회원 검증 (Ctrl + T -> opt + cmd + M)
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }); //원형
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}


