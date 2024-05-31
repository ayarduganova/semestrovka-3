package ru.kpfu.itis.springbootsemestrovka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.jdbc.Sql;
import ru.kpfu.itis.springbootsemestrovka.dto.req.PostRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.PostResponse;
import ru.kpfu.itis.springbootsemestrovka.entity.PostEntity;
import ru.kpfu.itis.springbootsemestrovka.entity.UserEntity;
import ru.kpfu.itis.springbootsemestrovka.repository.PostRepository;
import ru.kpfu.itis.springbootsemestrovka.security.user.UserDetailsImpl;
import ru.kpfu.itis.springbootsemestrovka.service.PostService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@WithUserDetails("katya")
@Sql(value = "/sql/create_test_data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/sql/delete_test_data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Test
    public void addPostTest() {
        postRepository.deleteAll();

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity user = userDetails.getUser();
        PostRequest post = PostRequest.builder()
                            .comment("Мой первый пост")
                            .build();
        postService.addPost(user, post);

        List<PostEntity> posts = postRepository.findAll();
        assertThat(posts).hasSize(1);
        assertThat(posts.get(0).getUser().getUsername()).isEqualTo(user.getUsername());
        assertThat(posts.get(0).getComment()).isEqualTo("Мой первый пост");

    }

    @Test
    public void  getAllPostsTest(){
        postRepository.deleteAll();

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity user = userDetails.getUser();
        PostRequest post1 = PostRequest.builder()
                .comment("Мой первый пост")
                .build();
        PostRequest post2 = PostRequest.builder()
                .comment("Мой второй пост")
                .build();
        postService.addPost(user, post1);
        postService.addPost(user, post2);

        List<PostResponse> posts = postService.getAll();

        assertThat(posts).hasSize(2);
        assertThat(posts.get(0).getUserInfoResponse().getFirstName()).isEqualTo(user.getUserInfoEntity().getFirstName());
        assertThat(posts.get(0).getUserInfoResponse().getLastName()).isEqualTo(user.getUserInfoEntity().getLastName());
        assertThat(posts.get(0).getComment()).isEqualTo(post1.comment());
        assertThat(posts.get(1).getUserInfoResponse().getFirstName()).isEqualTo(user.getUserInfoEntity().getFirstName());
        assertThat(posts.get(1).getUserInfoResponse().getLastName()).isEqualTo(user.getUserInfoEntity().getLastName());
        assertThat(posts.get(1).getComment()).isEqualTo(post2.comment());

    }

    @Test
    public void getPostLikeByQuery(){
        postRepository.deleteAll();

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity user = userDetails.getUser();
        PostRequest post1 = PostRequest.builder()
                .comment("Мой первый пост")
                .build();
        PostRequest post2 = PostRequest.builder()
                .comment("Мой второй пост")
                .build();
        postService.addPost(user, post1);
        postService.addPost(user, post2);

        String query1 = "Мой";
        List<PostResponse> result1 = postService.getPostLikeByQuery(query1);
        assertThat(result1).hasSize(2);

        String query2 = "второй";
        List<PostResponse> result2 = postService.getPostLikeByQuery(query2);
        assertThat(result2).hasSize(1);
        assertThat(result2.get(0).getComment()).isEqualTo("Мой второй пост");
        assertThat(result2.get(0).getUserInfoResponse().getFirstName()).isEqualTo(user.getUserInfoEntity().getFirstName());

    }

}
