package ru.kpfu.itis.springbootsemestrovka.dto.resp;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class AjaxResponse {

    List<PostResponse> result;

}
