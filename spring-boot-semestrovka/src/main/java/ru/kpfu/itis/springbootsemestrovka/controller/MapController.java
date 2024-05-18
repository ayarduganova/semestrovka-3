package ru.kpfu.itis.springbootsemestrovka.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.springbootsemestrovka.security.user.UserDetailsImpl;

@Controller
public class MapController {

    @GetMapping("/map")
    public String getMap(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("current_user", user.getUser());

        return "map/map";
    }

}
