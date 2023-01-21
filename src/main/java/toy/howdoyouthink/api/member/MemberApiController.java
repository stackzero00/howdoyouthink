package toy.howdoyouthink.api.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toy.howdoyouthink.domain.member.MemberRepository;
import toy.howdoyouthink.dtos.member.SignupRequest;
import toy.howdoyouthink.dtos.member.SignupResponse;
import toy.howdoyouthink.service.member.MemberService;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    private final MemberRepository memberRepository;

    @GetMapping("/signup/duplication-check")
    public ResponseEntity<String> duplicationCheck(@RequestParam("id") String id) {

        Boolean result = memberRepository.existsByLoginId(id);
        if (result == false) {
            return new ResponseEntity<>("사용할 수 없는 id", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("사용가능한 id", HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody @Valid SignupRequest signupRequest){

        Long memberId = memberService.join(signupRequest);
        return new SignupResponse("회원가입 성공");
    }
}
