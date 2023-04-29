package kim.jerok.practice_spring_12.handler;

import kim.jerok.practice_spring_12.dto.ResponseDto;
import kim.jerok.practice_spring_12.handler.ex.ControllerException;
import kim.jerok.practice_spring_12.handler.ex.RestControllerException;
import kim.jerok.practice_spring_12.util.Script;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// RestController -> Data 줘
// Controller -> View 줘 text/html 줘

@RestControllerAdvice
public class ExHandler {

    @ExceptionHandler(ControllerException.class)
    public String controllerException(ControllerException e) {
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(RestControllerException.class)
    public ResponseEntity<?> restControllerException(RestControllerException e) {
        ResponseDto<?> responseDto = new ResponseDto<>(e.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

}
