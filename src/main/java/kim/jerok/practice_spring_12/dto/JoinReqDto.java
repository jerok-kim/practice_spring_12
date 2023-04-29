package kim.jerok.practice_spring_12.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinReqDto {
    private String username;
    private String password;
    private String tel;
}
