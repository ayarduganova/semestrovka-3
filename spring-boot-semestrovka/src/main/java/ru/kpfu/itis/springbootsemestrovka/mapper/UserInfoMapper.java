package ru.kpfu.itis.springbootsemestrovka.mapper;


import org.springframework.stereotype.Component;
import ru.kpfu.itis.springbootsemestrovka.dto.req.UserInfoRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.UserInfoResponse;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.UserInfoEntity;

@Component
public class UserInfoMapper implements StandartMapper<UserInfoRequest, UserInfoEntity, UserInfoResponse> {

    @Override
    public UserInfoEntity toEntity(UserInfoRequest userInfoRequest) {

        UserInfoEntity userInfoEntity = UserInfoEntity.builder()
                .firstName(userInfoRequest.getFirstName())
                .lastName(userInfoRequest.getLastName())
                .birthday(userInfoRequest.getBirthday())
                .gender(userInfoRequest.getGender())
                .build();
        if(userInfoRequest.getEmail() != null) {
            userInfoEntity.setEmail(userInfoRequest.getEmail());
        }
        if(userInfoRequest.getPhone() != null) {
            userInfoEntity.setPhone(userInfoEntity.getPhone());
        }

        return userInfoEntity;
    }

    @Override
    public UserInfoEntity updateEntityFromRequest(UserInfoRequest userInfoRequest, UserInfoEntity userInfoEntity) {

        userInfoEntity.setFirstName(userInfoRequest.getFirstName());
        userInfoEntity.setLastName(userInfoRequest.getLastName());
        userInfoEntity.setGender(userInfoRequest.getGender());
        userInfoEntity.setBirthday(userInfoRequest.getBirthday());
        if(userInfoRequest.getEmail() != null) {
            userInfoEntity.setEmail(userInfoRequest.getEmail());
        }
        if(userInfoRequest.getPhone() != null) {
            userInfoEntity.setPhone(userInfoEntity.getPhone());
        }

        return userInfoEntity;
    }

    @Override
    public UserInfoResponse toResponse(UserInfoEntity user){
        return UserInfoResponse.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .birthday(user.getBirthday())
                .email(user.getEmail())
                .build();
    }
}
