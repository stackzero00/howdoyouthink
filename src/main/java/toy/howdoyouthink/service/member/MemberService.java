package toy.howdoyouthink.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.howdoyouthink.domain.member.MemberRepository;
import toy.howdoyouthink.domain.member.Member;
import toy.howdoyouthink.dtos.member.SignupRequest;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    // EnumType 입력 받아야됨 -> major, position
    public Long join(SignupRequest signupRequestDto) {

        Member member = Member.builder()
                .name(signupRequestDto.getName())
                .studentId(signupRequestDto.getStudentId())
                .major(signupRequestDto.getMajor())
                .position(signupRequestDto.getPosition())
                .loginId(signupRequestDto.getLoginId())
                .password(signupRequestDto.getPassword())
                .build();

        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }
}
