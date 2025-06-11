package codesquadBoardPratice.Elbin.user.controller;

import codesquadBoardPratice.Elbin.user.domain.User;
import codesquadBoardPratice.Elbin.user.dto.request.UserCreateDto;
import codesquadBoardPratice.Elbin.user.dto.request.UserLoginDto;
import codesquadBoardPratice.Elbin.user.service.UserService;
import codesquadBoardPratice.Elbin.web.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody UserCreateDto userCreateDto) {
        userService.save(userCreateDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserLoginDto userLoginDto, HttpServletRequest request) {
        User user = userService.login(userLoginDto);

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, user);

        return ResponseEntity.ok().build();
    }

}
