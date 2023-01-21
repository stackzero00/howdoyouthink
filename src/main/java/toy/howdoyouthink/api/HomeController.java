package toy.howdoyouthink.api;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import toy.howdoyouthink.domain.member.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class HomeController {

//    @GetMapping("/")
//    @ResponseStatus(HttpStatus.OK)
    public ApiResponse loginHome(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null) {
            return ApiResponse.createSuccessWithNoContent();
        }

        Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        if (loginMember == null) {
            return ApiResponse.createSuccessWithNoContent();
        }

        HomeResponse responseDto = new HomeResponse();
        responseDto.setUserName(loginMember.getName());
        return ApiResponse.createSuccess(responseDto);

    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse loginHomeV2(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember){

        if (loginMember == null) {
            return ApiResponse.createSuccessWithNoContent();
        }

        HomeResponse responseDto = new HomeResponse();
        responseDto.setUserName(loginMember.getName());
        return ApiResponse.createSuccess(responseDto);

    }

    @Data
    static class HomeResponse{
        private String userName;
    }
}
