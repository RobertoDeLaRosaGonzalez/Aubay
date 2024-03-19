package com.aubay.spaceships.application.command.getspaceship;

public class GetSpaceshipsRequest {

    Integer size;
    Integer page;

    public Integer getSize() {
        return size;
    }

    public Integer getPage() {
        return page;
    }

    public GetSpaceshipsRequest(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }
}