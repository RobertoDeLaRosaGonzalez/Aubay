package com.aubay.spaceships.Application.Command.GetSpaceship;

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