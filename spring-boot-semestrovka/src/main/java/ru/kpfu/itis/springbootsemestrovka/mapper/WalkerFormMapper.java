package ru.kpfu.itis.springbootsemestrovka.mapper;

import org.springframework.stereotype.Component;
import ru.kpfu.itis.springbootsemestrovka.dto.req.WalkerFormRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.WalkerFormResponse;
import ru.kpfu.itis.springbootsemestrovka.entity.WalkerFormEntity;

import java.util.ArrayList;
import java.util.List;

@Component
public class WalkerFormMapper implements StandartMapper<WalkerFormRequest, WalkerFormEntity>{

    @Override
    public WalkerFormEntity toEntity(WalkerFormRequest walkerFormRequest) {
        return WalkerFormEntity.builder()
                .firstName(walkerFormRequest.firstName())
                .lastName(walkerFormRequest.lastName())
                .email(walkerFormRequest.email())
                .phone(walkerFormRequest.phone())
                .isChecked(false)
                .build();
    }

    public WalkerFormResponse toResponse(WalkerFormEntity walkerFormEntity){
        return WalkerFormResponse.builder()
                .id(walkerFormEntity.getId())
                .firstName(walkerFormEntity.getFirstName())
                .lastName(walkerFormEntity.getLastName())
                .email(walkerFormEntity.getEmail())
                .phone(walkerFormEntity.getPhone())
                .build();
    }

    public List<WalkerFormResponse> toListResponse(List<WalkerFormEntity> walkerFormEntities){
        List<WalkerFormResponse> walkerFormResponses = new ArrayList<>();
        for(WalkerFormEntity walkerFormEntity : walkerFormEntities){
            walkerFormResponses.add(toResponse(walkerFormEntity));
        }
        return walkerFormResponses;
    }

    @Override
    public WalkerFormEntity updateEntityFromRequest(WalkerFormRequest walkerFormRequest, WalkerFormEntity walkerFormEntity) {
        return null;
    }
}
