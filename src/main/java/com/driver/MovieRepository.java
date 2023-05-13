package com.Driver;

import com.driver.Director;
import com.driver.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository{

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }
    public void saveMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }

    public void saveDirector(Director director){
        directorMap.put(director.getName(), director);
    }
    public void saveMovieDirectorPair(String movie, String director){
        List<String> currentMoviesByDirector = new ArrayList<>();
        if(directorMovieMapping.containsKey(director)){
            currentMoviesByDirector = directorMovieMapping.get(director);
        }
        currentMoviesByDirector.add(movie);
        directorMovieMapping.put(director, currentMoviesByDirector);

    }

    public Movie findMovie(String movieName){
        return movieMap.get(movieName);
    }
    public Director findDirector(String directorName){
        return directorMap.get(directorName);
    }
    public List<String> findMoviesFromDirector(String director){
        List<String> movieList = new ArrayList<>();
        if(directorMovieMapping.containsKey(director)) movieList = directorMovieMapping.get(director);
        return movieList;
    }
    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }
    public void removeDirector(String director){
        directorMap.remove(director);
        directorMovieMapping.remove(director);
    }
    public void removeMovie(String movieName){
        movieMap.remove(movieName);
    }
    public List<String> getAllDirectors(){
        return new ArrayList<>(directorMap.keySet());
    }
}
