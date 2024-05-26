package ru.kpfu.itis.springbootsemestrovka.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.springbootsemestrovka.dto.req.PostRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.PostResponse;
import ru.kpfu.itis.springbootsemestrovka.entity.PostEntity;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PostMapper implements StandartMapper<PostRequest, PostEntity>{

    private final UserInfoMapper userInfoMapper;

    @Override
    public PostEntity toEntity(PostRequest postRequest) {
        return PostEntity.builder()
                .comment(postRequest.comment())
                .build();
    }

    public PostResponse toResponse(PostEntity postEntity){
        return PostResponse.builder()
                .comment(postEntity.getComment())
                .userInfoResponse(userInfoMapper.toResponse(postEntity.getUser().getUserInfoEntity()))
                .build();
    }

    public List<PostResponse> toListResponse(List<PostEntity> postEntities){
        List<PostResponse> postResponses = new ArrayList<>();
        for(PostEntity postEntity : postEntities){
            postResponses.add(toResponse(postEntity));
        }
        return postResponses;
    }

    @Override
    public PostEntity updateEntityFromRequest(PostRequest postRequest, PostEntity postEntity) {
        return null;
    }

}
