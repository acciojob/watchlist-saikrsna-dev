package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.*;


@Service
public class MovieService {

    @Autowired
    com.Driver.MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.saveMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }

    public void createMovieDirectorPair(String movie, String director){
        if(Objects.nonNull(movieRepository.findMovie(movie)) && Objects.nonNull(movieRepository.findDirector(director))){
            movieRepository.saveMovieDirectorPair(movie, director);
        }
    }
    public Movie findMovie(String movieName){
        return movieRepository.findMovie(movieName);
    }
    public Director findDirector(String directorName){
        return movieRepository.findDirector(directorName);
    }
    public List<String> findMoviesFromDirector(String director){
        return movieRepository.findMoviesFromDirector(director);
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public void deleteDirector(String director){
        List<String> moviesToDelete = movieRepository.findMoviesFromDirector(director);
        movieRepository.removeDirector(director);
        for(String movieName : moviesToDelete){
            movieRepository.removeMovie(movieName);
        }
    }
    public void deleteAllDirectors(){
        List<String> directors = movieRepository.getAllDirectors();
        for(String directorName : directors){
            deleteDirector(directorName);
        }
    }
}
