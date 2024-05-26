package ru.kpfu.itis.springbootsemestrovka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.springbootsemestrovka.dto.req.PostRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.req.WalkerFormRequest;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;
import ru.kpfu.itis.springbootsemestrovka.security.user.UserDetailsImpl;
import ru.kpfu.itis.springbootsemestrovka.service.PostService;
import ru.kpfu.itis.springbootsemestrovka.service.UserService;
import ru.kpfu.itis.springbootsemestrovka.service.WalkerFormService;
import ru.kpfu.itis.springbootsemestrovka.service.UserInfoService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/walkers")
public class DogWalkersController {

    private final WalkerFormService walkerFormService;
    private final UserInfoService userInfoService;
    private final UserService userService;
    private final PostService postService;

    @GetMapping
    public String getWalkers(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("user", userInfoService.getProfileByUser(user.getUser()));
        model.addAttribute("current_user", user.getUser());
        model.addAttribute("service", userService);
        model.addAttribute("role", Role.WALKER);
        model.addAttribute("posts", postService.getAll());

        return "walkers/walkers_feed";
    }

    @PostMapping()
    public String sendWalkerRequest(@AuthenticationPrincipal UserDetailsImpl user,
                                    WalkerFormRequest walkerFormRequest){

        walkerFormService.sendWalkerRequest(user.getUser(), walkerFormRequest);
        return "redirect:/walkers";
    }

    @GetMapping("/addPost")
    public String getViewAddPost(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("current_user", user.getUser());
        model.addAttribute("posts", postService.getAll());

        return "walkers/post_add";
    }

    @PostMapping("/addPost")
    public String addPost(@AuthenticationPrincipal UserDetailsImpl user,
                         PostRequest postRequest) {

        postService.addPost(user.getUser(), postRequest);

        return "redirect:/walkers";
    }

}
