package Models;

import java.util.*;
import Repository.*;

public class MovieModel implements MovieModelInterface {
    private ArrayList<MovieObserver> movieObservers = new ArrayList<MovieObserver>();
    private int movieId;
    private String movieTitle;
    private boolean rented;
    private MovieRepository repository;
    
    public void initialize() {  
        repository = new MovieRepository();
    }
    
    public int getMovieId() {
        return movieId;
    }
    
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
    public String getMovieTitle() {
        return movieTitle;
    }
    
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    
    public boolean getRented() {
        return rented;
    }
    
    public void setRented(boolean rented) {
        this.rented = rented;
    }
    
    public List<String> getAll() {
        resetRepository();
        List<String> movies = repository.getAllMovies();
        notifyMovieObservers();
        return movies;
    }
    
    public void create() {        
        repository.addMovie(this);
        notifyMovieObservers();
    }
    
    public void rent() {
        repository.rentMovie(movieId);
        notifyMovieObservers();
    }
    
    public void returnMovie() {
        repository.returnMovie(movieId);
        notifyMovieObservers();
    }
   
    public void registerObserver(MovieObserver o) {
        movieObservers.add(o);
    }
    
    public void notifyMovieObservers() {
        for (int i = 0; i < movieObservers.size(); i++) {
            MovieObserver observer = (MovieObserver)movieObservers.get(i);
            observer.updateMovie();
        }
    }
    
    public void removeObserver(MovieObserver o) {
        int i = movieObservers.indexOf(o);
        if (i >= 0) {
            movieObservers.remove(i);
        }
    }

    private void resetRepository() {
        if (repository == null) {
            repository = new MovieRepository();        
        }    
    }    
}
