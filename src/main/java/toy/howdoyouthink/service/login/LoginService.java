package toy.howdoyouthink.service.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toy.howdoyouthink.api.login.dto.LoginApiRequestDto;
import toy.howdoyouthink.domain.member.Member;
import toy.howdoyouthink.domain.member.MemberRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(LoginApiRequestDto loginApiRequestDto) {

        String loginId = loginApiRequestDto.getLoginId();
        String password = loginApiRequestDto.getPassword();

        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }
}
