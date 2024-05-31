package ru.kpfu.itis.springbootsemestrovka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.WalkerFormEntity;
import ru.kpfu.itis.springbootsemestrovka.security.user.Role;
import ru.kpfu.itis.springbootsemestrovka.security.user.UserDetailsImpl;
import ru.kpfu.itis.springbootsemestrovka.service.RoleService;
import ru.kpfu.itis.springbootsemestrovka.service.UserService;
import ru.kpfu.itis.springbootsemestrovka.service.WalkerFormService;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;
    private final WalkerFormService walkerFormService;

    @GetMapping("/users")
    public String getUsers(Model model, @AuthenticationPrincipal UserDetailsImpl user) {

        model.addAttribute("users", userService.getAll());
        model.addAttribute("current_user", user.getUser());

        return "admin/users";
    }

    @GetMapping("/user/{id}")
    public String userEdit(@PathVariable("id") UserEntity user, Model model,
                           @AuthenticationPrincipal UserDetailsImpl currentUser) {

        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.allRoles());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("current_user", currentUser.getUser());

        return "admin/user_edit";
    }

    @PostMapping("/user")
    public String userEdit(@RequestParam("userId") UserEntity user,
                           @RequestParam("block_action") String blockAction,
                           @RequestParam Map<String, String> form,
                           @RequestParam("btn_action") String btnAction) {


        userService.editUser(user, blockAction, form, btnAction);

        return "redirect:/admin/users";
    }

    @GetMapping("/requests")
    public String getRequests(Model model, @AuthenticationPrincipal UserDetailsImpl user) {

        model.addAttribute("users", userService.getAll());
        model.addAttribute("current_user", user.getUser());
        model.addAttribute("requests", walkerFormService.getRequests());

        return "admin/requests";
    }

    @PostMapping("/requests")
    public String approveForm(@RequestParam("requestId")Long walkerFormId,
                              @RequestParam("action") String action){

        if (action.equals("approve")) {
            walkerFormService.approveForm(walkerFormId);
        } else if (action.equals("reject")) {
            walkerFormService.rejectForm(walkerFormId);
        }

        return "redirect:/admin/requests";
    }

}
