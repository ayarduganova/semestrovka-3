package ru.kpfu.itis.springbootsemestrovka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.springbootsemestrovka.dto.req.SearchRequest;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.AjaxResponse;
import ru.kpfu.itis.springbootsemestrovka.dto.resp.PostResponse;
import ru.kpfu.itis.springbootsemestrovka.service.AjaxService;
import ru.kpfu.itis.springbootsemestrovka.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AjaxController {

    private final AjaxService ajaxService;

    @PostMapping("/walkers/search")
    public AjaxResponse getSearchResultViaAjax(SearchRequest search) {
        return ajaxService.getSearchResult(search);
    }

}
