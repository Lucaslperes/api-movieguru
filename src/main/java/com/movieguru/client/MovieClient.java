package com.movieguru.client;

import com.movieguru.dto.Results;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "movieClient", url = "https://api.themoviedb.org/3")
public interface MovieClient {

    @GetMapping("/discover/movie")
    Results getMovies(
            @RequestHeader("Authorization") String authorization,
            @RequestParam("genre") String genre,
            @RequestParam("minRating") Double minRating
    );
}