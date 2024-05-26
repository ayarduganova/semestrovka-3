package ru.kpfu.itis.springbootsemestrovka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.springbootsemestrovka.dto.req.DogRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.req.UserInfoRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.req.WalkerRequest;
import ru.kpfu.itis.springbootsemestrovka.entity.DogEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.WalkerEntity;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;
import ru.kpfu.itis.springbootsemestrovka.security.user.UserDetailsImpl;
import ru.kpfu.itis.springbootsemestrovka.service.DogService;
import ru.kpfu.itis.springbootsemestrovka.service.UserInfoService;
import ru.kpfu.itis.springbootsemestrovka.service.UserService;
import ru.kpfu.itis.springbootsemestrovka.service.WalkerService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final UserInfoService userInfoService;
    private final UserService userService;
    private final DogService dogService;
    private final WalkerService walkerService;

    @GetMapping
    public String getProfile(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("profile", userInfoService.getProfileByUser(user.getUser()));
        model.addAttribute("dogs", dogService.getDogs(user.getUser()));
        model.addAttribute("current_user", user.getUser());
        model.addAttribute("role", Role.WALKER);
        model.addAttribute("service", userService);

        if(user.getUser().getWalkerEntity() != null){
            model.addAttribute("walker", walkerService.getWalkerEntityByUser(user.getUser()));
        }

        return "profile/standart_profile";
    }

    @GetMapping("/editPerson")
    public String editPersonProfile(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("profile", userInfoService.getProfileByUser(user.getUser()));
        model.addAttribute("current_user", user.getUser());

        return "profile/person_profile_edit";
    }

    @PostMapping("/editPerson")
    public String editPersonProfile(@AuthenticationPrincipal UserDetailsImpl user,
                                    UserInfoRequest userInfoRequest) {

        userInfoService.editPersonProfile(user.getUser(), userInfoRequest);

        return "redirect:/profile";
    }

    @GetMapping("/editDog/{id}")
    public String editDogProfile(@PathVariable("id") DogEntity dog, Model model, @AuthenticationPrincipal UserDetailsImpl user) {

        model.addAttribute("dog", dog);
        model.addAttribute("dogs", dogService.getAll());
        model.addAttribute("current_user", user.getUser());

        return "profile/dog_profile_edit";
    }

    @PostMapping("/editDog")
    public String editDogProfile(@RequestParam("dogId") DogEntity dog,
                                 DogRequest dogRequest) {

        dogService.editDog(dog, dogRequest);

        return "redirect:/profile";
    }

    @GetMapping("/addDog")
    public String getViewAddDog(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("current_user", user.getUser());

        return "profile/dog_add";
    }

    @PostMapping("/addDog")
    public String addDog(@AuthenticationPrincipal UserDetailsImpl user,
                         DogRequest dogRequest) {

        dogService.addDog(user.getUser(), dogRequest);

        return "redirect:/profile";
    }

    @GetMapping("/editWalker")
    public String editWalkerProfile(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("current_user", user.getUser());
        if(user.getUser().getWalkerEntity() != null){
            model.addAttribute("walker", walkerService.getWalkerEntityByUser(user.getUser()));
        }

        return "profile/walker_profile_edit";
    }

    @PostMapping("/editWalker")
    public String editWalkerProfile(@AuthenticationPrincipal UserDetailsImpl user,
                                    WalkerRequest walkerRequest) {

        walkerService.editWalker(walkerRequest, user.getUser());

        return "redirect:/profile";
    }

}
