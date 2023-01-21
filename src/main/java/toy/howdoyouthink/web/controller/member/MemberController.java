package toy.howdoyouthink.web.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/signup")
    public String loadSignupForm() {
        return "member/signup-form";
    }

//    @PostMapping("/signup")
//    public String signUp(@ModelAttribute("requestDto") SignupRequestDto requestDto,
//                         BindingResult bindingResult) {
//
//        return "signup-form";
//    }

}
