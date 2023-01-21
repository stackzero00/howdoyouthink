package toy.howdoyouthink.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import toy.howdoyouthink.exception.login.UserNotFountException;

@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ApiResponse UserNotFountException(UserNotFountException e) {
        log.info("[exceptionHandler] ex: ",e);
        return ApiResponse.createFail("ID 또는 PW 불일치");
    }
}
