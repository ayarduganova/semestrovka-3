package ru.kpfu.itis.springbootsemestrovka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.springbootsemestrovka.dto.req.PostRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.req.SearchRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.req.WalkerFormRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.AjaxResponse;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.PostResponse;
import ru.kpfu.itis.springbootsemestrovka.entity.PostEntity;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;
import ru.kpfu.itis.springbootsemestrovka.security.user.UserDetailsImpl;
import ru.kpfu.itis.springbootsemestrovka.service.PostService;
import ru.kpfu.itis.springbootsemestrovka.service.UserService;
import ru.kpfu.itis.springbootsemestrovka.service.WalkerFormService;
import ru.kpfu.itis.springbootsemestrovka.service.UserInfoService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/walkers")
public class DogWalkersController {

    private final WalkerFormService walkerFormService;
    private final UserService userService;
    private final PostService postService;

    @GetMapping
    public String getWalkers(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("user", user.getUser().getUserInfoEntity());
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
    @PreAuthorize("hasAuthority('WALKER')")
    public String getViewAddPost(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("current_user", user.getUser());
        model.addAttribute("posts", postService.getAll());

        return "walkers/post_add";
    }

    @PostMapping("/addPost")
    @PreAuthorize("hasAuthority('WALKER')")
    public String addPost(@AuthenticationPrincipal UserDetailsImpl user,
                         PostRequest postRequest) {

        postService.addPost(user.getUser(), postRequest);

        return "redirect:/walkers";
    }

}
