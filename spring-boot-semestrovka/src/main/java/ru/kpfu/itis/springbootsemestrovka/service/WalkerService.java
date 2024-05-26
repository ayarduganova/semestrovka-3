package ru.kpfu.itis.springbootsemestrovka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.springbootsemestrovka.dto.req.WalkerRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.WalkerResponse;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.WalkerEntity;
import ru.kpfu.itis.springbootsemestrovka.exception.WalkerNotFoundServiceException;
import ru.kpfu.itis.springbootsemestrovka.mapper.WalkerMapper;
import ru.kpfu.itis.springbootsemestrovka.repository.WalkerRepository;

@Service
@RequiredArgsConstructor
public class WalkerService {

    private final WalkerRepository walkerRepository;
    private final WalkerMapper walkerMapper;

    public WalkerEntity getWalkerEntityByUser(UserEntity user){
        return walkerRepository.getWalkerEntityByUser(user)
                .orElseThrow(() -> new WalkerNotFoundServiceException(user.getId()));
    }

    public void editWalker(WalkerRequest walkerRequest, UserEntity user) {

        WalkerEntity walkerEntity = user.getWalkerEntity();
        if(walkerEntity != null){
            walkerEntity = walkerMapper.updateEntityFromRequest(walkerRequest, walkerEntity);
        }
        else{
            walkerEntity = walkerMapper.toEntity(walkerRequest);
            walkerEntity.setUser(user);
        }

        walkerRepository.save(walkerEntity);
        user.setWalkerEntity(walkerEntity);

    }

}
