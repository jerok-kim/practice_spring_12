package kim.jerok.practice_spring_12.controller;

import kim.jerok.practice_spring_12.dto.JoinReqDto;
import kim.jerok.practice_spring_12.dto.JoinRespDto;
import kim.jerok.practice_spring_12.dto.ResponseDto;
import kim.jerok.practice_spring_12.handler.ex.ControllerException;
import kim.jerok.practice_spring_12.handler.ex.RestControllerException;
import kim.jerok.practice_spring_12.util.Script;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("/login/v1")
    public String loginV1() {
        // DB에서 username과 password를 체크하고 잘되면!! redirect 하겠다.
        return "redirect:/";
    }

    @PostMapping(value = "/login/v2", produces = "text/html; charset=utf-8")
    public @ResponseBody String loginV2() {
        return Script.href("/", "로그인성공");
    }

    // 유효성 : POST, PUT
    @PostMapping("/login/v3")
    public @ResponseBody String loginv3(String username, String password) {
        if (username == null || username.isEmpty()) {
            return Script.back("username을 입력해주세요");
        }
        if (password == null || password.isEmpty()) {
            return Script.back("password를 입력해주세요");
        }
        return Script.href("/", "로그인성공");
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("/join/v1")
    public ResponseEntity<?> joinV1(JoinReqDto joinReqDto) {

        if (joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()) {
            ResponseDto<?> responseDto = new ResponseDto<>("username이 없습니다");
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
        if (joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()) {
            ResponseDto<?> responseDto = new ResponseDto<>("password가 없습니다");
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
        if (joinReqDto.getTel() == null || joinReqDto.getTel().isEmpty()) {
            ResponseDto<?> responseDto = new ResponseDto<>("tel이 없습니다");
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }

        JoinRespDto joinRespDto = new JoinRespDto("jerok", "01012345678");
        ResponseDto<?> responseDto = new ResponseDto<>("회원가입 성공", joinRespDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);

    }

    // 핸들러 사용
    @PostMapping("/join/v2")
    public ResponseEntity<?> joinV2(@RequestBody JoinReqDto joinReqDto) {

        if (joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()) {
            throw new RestControllerException("username을 입력해주세요");
        }
        if (joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()) {
            throw new RestControllerException("password를 입력해주세요");
        }
        if (joinReqDto.getTel() == null || joinReqDto.getTel().isEmpty()) {
            throw new RestControllerException("tel을 입력해주세요");
        }

        JoinRespDto joinRespDto = new JoinRespDto("jerok", "01012345678");
        ResponseDto<?> responseDto = new ResponseDto<>("회원가입 성공", joinRespDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    // 핸들러 사용
    @PostMapping("/login/v4")
    public @ResponseBody String loginV4(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new ControllerException("username을 입력해주세요");
        }
        if (password == null || password.isEmpty()) {
            throw new ControllerException("password를 입력해주세요");
        }
        return Script.href("/", "로그인성공");
    }
}
