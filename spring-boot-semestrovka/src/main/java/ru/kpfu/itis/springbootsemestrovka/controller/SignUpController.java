package ru.kpfu.itis.springbootsemestrovka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.springbootsemestrovka.dto.UserRequest;
import ru.kpfu.itis.springbootsemestrovka.service.UserService;
import static ru.kpfu.itis.springbootsemestrovka.alert.AlertMessage.*;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;

    @GetMapping("/signUp")
    public String signUp() {
        return "signin/signup";
    }

    @PostMapping("/signUp")
    public String signUp(UserRequest userRequest, Model model){
        if (userService.exist(userRequest.getUsername())){
            model.addAttribute("message", USER_EXIST);
            return "signin/signup";
        }

        userService.signUp(userRequest);
        return "redirect:/login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("message", INVALID_DATA);
        return "signin/login";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login?logout";
    }
}
