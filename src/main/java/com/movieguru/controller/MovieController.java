package com.movieguru.controller;

import com.movieguru.dto.RecommendationRequest;
import com.movieguru.model.Movie;
import com.movieguru.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/recommendations")
    public List<Movie> getRecommendations(@RequestBody RecommendationRequest request) {
        return movieService.getRecommendations(request);
    }
}