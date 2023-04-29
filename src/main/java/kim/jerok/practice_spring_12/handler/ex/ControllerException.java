package kim.jerok.practice_spring_12.handler.ex;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ControllerException extends RuntimeException {

    private HttpStatus httpStatus;

    public ControllerException(String msg) {
        this(msg, HttpStatus.BAD_REQUEST);
    }

    public ControllerException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

}
