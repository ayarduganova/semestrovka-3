package ru.kpfu.itis.springbootsemestrovka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.springbootsemestrovka.dto.req.UserInfoRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.req.WalkerFormRequest;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.UserInfoEntity;
import ru.kpfu.itis.springbootsemestrovka.exception.UserInfoNotFoundException;
import ru.kpfu.itis.springbootsemestrovka.mapper.UserInfoMapper;
import ru.kpfu.itis.springbootsemestrovka.repository.UserInfoRepository;
import ru.kpfu.itis.springbootsemestrovka.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private final UserRepository userRepository;
    private final UserInfoMapper userInfoMapper;

    public void setUserInfo(String username, UserInfoRequest userInfo){

        UserInfoEntity userInfoEntity = userInfoMapper.toEntity(userInfo);
        userInfoEntity.setUser(userRepository.getUserEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found")));
        userInfoRepository.save(userInfoEntity);
    }

    public UserInfoEntity getProfileByUser(UserEntity user) {
        return userInfoRepository.getUserInfoEntityByUser(user).orElseThrow(() -> new UserInfoNotFoundException(user.getId()));
    }

    public void editPersonProfile(UserEntity user, UserInfoRequest userInfoRequest) {
        UserInfoEntity profile = getProfileByUser(user);
        userInfoRepository.save(userInfoMapper.updateEntityFromRequest(userInfoRequest, profile));
    }

}
