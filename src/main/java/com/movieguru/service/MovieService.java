package com.movieguru.service;

import com.movieguru.client.MovieClient;
import com.movieguru.dto.MovieDTO;
import com.movieguru.dto.RecommendationRequest;
import com.movieguru.dto.Results;
import com.movieguru.model.Movie;
import com.movieguru.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieClient movieClient;

    @Value("${movie.api.key}")
    private String apiKey;

    public List<Movie> getRecommendations(RecommendationRequest request) {
        List<Movie> localMovies = movieRepository.findByGenreAndRatingGreaterThanEqual(request.getGenre(), request.getMinRating());
        if (localMovies.isEmpty()) {
            String authorizationHeader = "Bearer " + apiKey;
            Results results = movieClient.getMovies(authorizationHeader, request.getGenre(), request.getMinRating());
            localMovies = results.getResults().stream().map(this::convertToMovie).collect(Collectors.toList());
            localMovies.forEach(movieRepository::save);
        }
        return localMovies;
    }

    private Movie convertToMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setId(movieDTO.getId());
        movie.setGenre("Action");  // Ajuste conforme necessário
        movie.setRating(movieDTO.getVoteAverage());
        movie.setTitle(movieDTO.getTitle());

        return movie;
    }
}