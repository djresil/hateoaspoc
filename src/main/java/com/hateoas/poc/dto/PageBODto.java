package com.hateoas.poc.dto;

import java.util.List;


public class PageBODto<A> {

    private List<A> content;
    private String next;
    private String previous;


    public List<A> getContent() {
        return content;
    }

    public void setContent(List<A> content) {
        this.content = content;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
