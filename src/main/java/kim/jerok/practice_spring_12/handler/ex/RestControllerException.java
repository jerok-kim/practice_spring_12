package kim.jerok.practice_spring_12.handler.ex;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestControllerException extends RuntimeException {
    private HttpStatus httpStatus;

    public RestControllerException(String msg) {
        this(msg, HttpStatus.BAD_REQUEST);
    }

    public RestControllerException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }
}
