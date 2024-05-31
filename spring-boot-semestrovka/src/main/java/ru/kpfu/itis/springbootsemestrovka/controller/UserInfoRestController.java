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
@Tag(name = "Информация о пользователе")
@RequestMapping("/rest/user-info")
public class UserInfoRestController {

    private final UserInfoService userInfoService;

    @Operation(
            summary = "Заполнить информацию о пользователе",
            description = "Позволяет заполнить информацию о пользователе по его username и по запросу с инфой"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/setInfo")
    public void setUserInfo(@RequestParam("username") String username, @RequestBody UserInfoRequest userInfo) {
        userInfoService.setUserInfo(username, userInfo);
    }

    @Operation(
            summary = "Получить информацию о пользователе для профиля",
            description = "Позволяет получить информацию о пользователе для профиля по пользователю"
    )
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/getByUser")
    public UserInfoResponse getProfileByUser(@RequestBody UserEntity user) {
        return userInfoService.getUserInfoByUser(user);
    }

    @Operation(
            summary = "Отредактировать информацию о пользователе для профиля",
            description = "Позволяет отредактировать информацию о пользователе по пользователю и запросу"
    )
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/editInfo")
    public void editPersonProfile(@RequestBody UserEntity user, @RequestBody UserInfoRequest userInfoRequest) {
        userInfoService.editPersonProfile(user, userInfoRequest);
    }

}
