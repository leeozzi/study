package inflearn.hello_spring.service;

import inflearn.hello_spring.domain.Member;
import inflearn.hello_spring.repository.MemberRepository;
import inflearn.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;
    // 다 new로 만들어주면 새로운 객체 -> 테스트마다 다른 레포지토리로 테스트하게 됨
    // -> MemberService 생성자에서 반환하게 만들어주고, 여기서 MemberService 만들 때 넣어줘야 함
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }   // 이런 걸 dependency injection (DI)라고 함



    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given 데이터가 주어졌을 때
        Member member1 = new Member();
        member1.setName("hello");

        // when 이걸 실행했을 때
        Long saveID = memberService.join(member1);

        //then 이게 나와야 해
        Member findMember = memberService.findOne(saveID).get();
        assertThat(member1.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring1");

        // when
        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}