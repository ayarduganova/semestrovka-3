package ru.kpfu.itis.springbootsemestrovka.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.springbootsemestrovka.dto.req.UserInfoRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.UserInfoResponse;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.service.UserInfoService;

@RestController
@RequiredArgsConstructor
@Tag(name="user-info")
@RequestMapping("/rest/user-info")
public class UserInfoRestController {

    private final UserInfoService userInfoService;

    @Operation(description = "Create info for user", summary = "create-user-info")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/setInfo")
    public void setUserInfo(@RequestParam("username") String username, @RequestBody UserInfoRequest userInfo){
        userInfoService.setUserInfo(username, userInfo);
    }

    @Operation(description = "Get info by user", summary = "get-user-info")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/getByUser")
    public UserInfoResponse getProfileByUser(@RequestBody UserEntity user) {
        return userInfoService.getUserInfoByUser(user);
    }

    @Operation(description = "Update user-info", summary = "update-user-info")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/editInfo")
    public void editPersonProfile(@RequestBody UserEntity user, @RequestBody UserInfoRequest userInfoRequest) {
       userInfoService.editPersonProfile(user, userInfoRequest);
    }

}
