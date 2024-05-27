package ru.kpfu.itis.springbootsemestrovka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.springbootsemestrovka.dto.req.SearchRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.AjaxResponse;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.PostResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AjaxService {

    private final PostService postService;

    public AjaxResponse getSearchResult(SearchRequest search) {
        String query = search.query();
        List<PostResponse> posts;
        if (query != null && !query.isEmpty()) {
            posts = postService.getPostLikeByQuery(query);
        }
        else {
            posts = postService.getAll();
        }
        return AjaxResponse.builder()
                .result(posts)
                .build();
    }

}
