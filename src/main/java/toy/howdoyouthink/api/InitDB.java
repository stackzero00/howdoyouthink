package toy.howdoyouthink.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toy.howdoyouthink.domain.member.Major;
import toy.howdoyouthink.domain.member.Member;
import toy.howdoyouthink.domain.member.MemberRepository;
import toy.howdoyouthink.domain.member.Position;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init() {

        Member member = Member.builder()
                .loginId("testtest")
                .password("12345678")
                .name("testUser")
                .position(Position.STUDENT)
                .major(Major.COMPUTER_SCIENCE)
                .build();

        memberRepository.save(member);
    }
}
