package com.aubay.spaceships.application.command.getspaceship;

public class GetSpaceshipsRequest {

    Integer page;
    Integer size;

    public Integer getPage() {
        return page;
    }
    
    public Integer getSize() {
        return size;
    }

    public GetSpaceshipsRequest(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }
}