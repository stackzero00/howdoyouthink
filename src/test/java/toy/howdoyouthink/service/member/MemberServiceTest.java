package toy.howdoyouthink.service.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import toy.howdoyouthink.domain.member.Major;
import toy.howdoyouthink.domain.member.MemberRepository;
import toy.howdoyouthink.domain.member.Position;
import toy.howdoyouthink.dtos.member.SignupRequest;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Test
    @DisplayName("회원 가입")
    public void join() throws Exception{
        //given
        SignupRequest dto = new SignupRequest("member0", "1234", Major.COMPUTER_SCIENCE,
                "member0", "11111111", Position.STUDENT);

//        doReturn(new Member())

        //when

        //then
    }

}