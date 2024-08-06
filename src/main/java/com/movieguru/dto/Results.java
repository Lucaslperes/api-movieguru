package com.movieguru.dto;

import com.movieguru.model.Movie;

import java.util.List;

public class Results {

    public Integer page;
    public List<MovieDTO> results;
    public Integer totalPages;
    public Integer totalResults;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<MovieDTO> getResults() {
        return results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }
}
