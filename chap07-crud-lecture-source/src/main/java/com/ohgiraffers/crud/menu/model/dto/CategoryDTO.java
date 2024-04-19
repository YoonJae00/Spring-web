package com.ohgiraffers.crud.menu.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.ResponseBody;

@NoArgsConstructor
@ResponseBody
@Getter
@Setter
@ToString
public class CategoryDTO {

    private int code;
    private String name;
    private int refCategoryCode;
}
