package ru.kpfu.itis.springbootsemestrovka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.springbootsemestrovka.dto.req.PostRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.req.WalkerFormRequest;
import ru.kpfu.itis.springbootsemestrovka.security.user.UserDetailsImpl;
import ru.kpfu.itis.springbootsemestrovka.service.PostService;
import ru.kpfu.itis.springbootsemestrovka.service.WalkerFormService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.yaml")
@Sql(value = "/sql/create_test_data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = "/sql/delete_test_data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class DogWalkersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WalkerFormService walkerFormService;

    @MockBean
    private PostService postService;

    @Test
    @WithUserDetails("nastya")
    public void dogWalkersListTest() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/walkers"))
                .andExpect(status().isOk())
                .andExpect(view().name("walkers/walkers_feed"))
                .andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();
        assertThat(modelAndView.getModel().get("user")).isNotNull();
        assertThat(modelAndView.getModel().get("current_user")).isNotNull();
        assertThat(modelAndView.getModel().get("posts")).isNotNull();
        assertThat(modelAndView.getModel().get("service")).isNotNull();
    }

    @Test
    @WithUserDetails("nastya")
    public void dogWalkersRequestTest() throws Exception {

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        WalkerFormRequest walkerFormRequest = WalkerFormRequest.builder()
                .lastName("Katya")
                .firstName("Voronova")
                .email("a@mail.ru")
                .phone("89177481987")
                .build();

        MockHttpServletRequestBuilder requestBuilder = post("/walkers")
                .flashAttr("walkerFormRequest", walkerFormRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/walkers"));

        verify(walkerFormService).sendWalkerRequest(userDetails.getUser(), walkerFormRequest);

    }

    @Test
    @WithUserDetails("katya")
    public void getViewAddPostWithWalkerRoleTest() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/walkers/addPost"))
                .andExpect(status().isOk())
                .andExpect(view().name("walkers/post_add"))
                .andReturn();

        ModelAndView modelAndView = mvcResult.getModelAndView();
        assertThat(modelAndView.getModel().get("current_user")).isNotNull();
        assertThat(modelAndView.getModel().get("posts")).isNotNull();
    }

    @Test
    @WithUserDetails("nastya")
    public void getViewAddPostWithoutWalkerRoleTest() throws Exception {

        this.mockMvc.perform(get("/walkers/addPost"))
                .andExpect(status().is5xxServerError());
    }

    @Test
    @WithUserDetails("katya")
    public void addPostTest() throws Exception {

        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        PostRequest postRequest = PostRequest.builder()
                .comment("Мой интересный пост")
                .build();

        MockHttpServletRequestBuilder requestBuilder = post("/walkers/addPost")
                .flashAttr("postRequest", postRequest);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/walkers"));

        verify(postService).addPost(userDetails.getUser(), postRequest);

    }

}
