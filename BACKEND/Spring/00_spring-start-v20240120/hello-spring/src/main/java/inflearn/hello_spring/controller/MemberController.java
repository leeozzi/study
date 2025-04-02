package inflearn.hello_spring.controller;

import inflearn.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    // spring container에 memberservice 등록해놓고 쓰기
    private final MemberService memberService;

    // 연결시켜줄 때 Autowired -> Dependency Injection
    // spring container에서 MemberService를 가져옴 -> MemberService에서 등록해줘야 함 (@Service)
    // 이게 컴포넌트 스캔 방식
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createFrom() {
        return "members/createMemberForm";
    }
}
