package ru.kpfu.itis.springbootsemestrovka.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.springbootsemestrovka.dto.req.UserInfoRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.req.UserSignUpRequest;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.security.user.UserDetailsImpl;
import ru.kpfu.itis.springbootsemestrovka.service.UserInfoService;
import ru.kpfu.itis.springbootsemestrovka.service.UserService;

import static ru.kpfu.itis.springbootsemestrovka.alert.AlertMessage.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signUp")
public class SignUpController {

    private final UserService userService;
    private final UserInfoService userInfoService;

    @GetMapping
    public String signUp() {
        return "signin/signup";
    }

    @PostMapping
    public String signUp(UserSignUpRequest userRequest, HttpSession session, Model model) {

        if (userService.exist(userRequest.username())) {
            model.addAttribute("message", USER_EXIST);
            return "signin/signup";
        }

        UserEntity user = userService.signUp(userRequest);
        session.setAttribute("user", user.getUsername());

        return "redirect:/signUp/fillInfo";
    }

    @GetMapping("/fillInfo")
    public String fillInfo(HttpSession session, Model model) {

        model.addAttribute("username", session.getAttribute("user"));

        return "signin/fillInfo";
    }

    @PostMapping("/fillInfo")
    public String fillInfo(String username, UserInfoRequest userRequest) {

        userInfoService.setUserInfo(username, userRequest);

        return "redirect:/login";
    }

    //нужно подправить
    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("message", INVALID_DATA);
        return "signin/login";
    }

    //нужно убрать
    @GetMapping("/main")
    public String main(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("current_user", user.getUser());
        return "main/main";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }

}
