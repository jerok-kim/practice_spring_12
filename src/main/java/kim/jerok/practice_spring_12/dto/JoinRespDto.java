package kim.jerok.practice_spring_12.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JoinRespDto {
    private String username;
    private String tel;
}
