package com.hateoas.poc.mapper;

import com.hateoas.poc.dto.PageBODto;
import com.hateoas.poc.service.bo.PageBO;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PageMapper {

    public <A, T>PageBODto<T> toDto(PageBO<A> pageBO, Function<A, T> pageElementMapper){
        PageBODto<T> pageBODto = new PageBODto<>();

        pageBODto.setContent(pageBO.getContent().stream().map(pageElementMapper).collect(Collectors.toList()));
        pageBODto.setNext(pageBO.getNext());
        pageBODto.setPrevious(pageBO.getPrevious());

        return pageBODto;

    }
}
