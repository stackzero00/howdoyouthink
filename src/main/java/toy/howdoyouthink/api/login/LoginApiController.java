package toy.howdoyouthink.api.login;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import toy.howdoyouthink.api.ApiResponse;
import toy.howdoyouthink.api.SessionConst;
import toy.howdoyouthink.api.login.dto.LoginApiRequestDto;
import toy.howdoyouthink.domain.member.Member;
import toy.howdoyouthink.exception.login.UserNotFountException;
import toy.howdoyouthink.service.login.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginApiController {

    private final LoginService loginService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse login(@RequestBody LoginApiRequestDto requestDto,
                             HttpServletRequest request) {

        Member member = loginService.login(requestDto);

        if (member == null) {
            throw new UserNotFountException("ID 또는 패스워드 오류!");
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);

        return ApiResponse.createSuccessWithNoContent();
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/logout")
    public ApiResponse logout(HttpServletRequest request){

        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return ApiResponse.createSuccessWithNoContent();
    }
}
