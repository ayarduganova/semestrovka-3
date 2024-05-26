package ru.kpfu.itis.springbootsemestrovka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.springbootsemestrovka.dto.req.PostRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.PostResponse;
import ru.kpfu.itis.springbootsemestrovka.entity.PostEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.mapper.PostMapper;
import ru.kpfu.itis.springbootsemestrovka.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;


    public void addPost(UserEntity user, PostRequest postRequest) {
        PostEntity postEntity = postMapper.toEntity(postRequest);
        postEntity.setUser(user);
        postRepository.save(postEntity);
    }

    public List<PostResponse> getAll() {
        return postMapper.toListResponse(postRepository.findAll());
    }

}
