package com.hateoas.poc.service.bo;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageBO<A> {

    private List<A> content;
    private String next;
    private String previous;

    public static <A> PageBO<A> build(Page<A> page, String url, int limit, int offset) {
        PageBO<A> pageBO = new PageBO<>();

        pageBO.content = page.getContent();

        if (page.hasNext()) {
            pageBO.next = pageBO.urlNext(url, limit, offset);

        }
        if (page.hasPrevious()) {
            pageBO.previous = "aca irá el previous";
        }
        return pageBO;
    }


    public String urlNext(String url, int limit, int offset) {

        String offsetFinal = String.valueOf(offset + limit);

        String replace = "offset=" + offsetFinal;

        url = url.replace("offset=" + offset, replace);


        return url;
    }

    public String urlPrevious(String url, int limit, int offset) {


        return url;
    }


    public List<A> getContent() {
        return content;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setContent(List<A> content) {
        this.content = content;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}



