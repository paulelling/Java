package Repository;

import java.util.*;
import Models.*;
import Utility.*;

public class MovieRepository {
    private String filePath;
    
    public MovieRepository() {
        String filePath = FileManager.getLine(Constants.FilePathFile);
        filePath += "\\movies.txt";        
        this.filePath = filePath;
    }    
    
    public MovieModel addMovie(MovieModel model) {        
        int movieId = getNextMovieId();  
        String movieTitle = model.getMovieTitle();
        int rented = BooleanData.convertBooleanToInt(model.getRented());        
        String movieText = movieId + "; " + movieTitle + "; " + rented;
        FileManager.appendToFile(filePath, movieText);        
        return model;
    }
    
    public void rentMovie(int movieId) {        
        FileManager.updateLine(filePath, movieId, "1");
    }    
    
    public void returnMovie(int movieId) {
        FileManager.updateLine(filePath, movieId, "0");
    }
    
    public int getNextMovieId() {
        int movieId = 0;
        String movie = getLastMovie();
        
        if (movie.isEmpty()) {            
            movieId = 1;
        }
        else {
            String movieIdString = movie.substring(0, movie.indexOf(";")).trim(); 
            
            if (!movieIdString.isEmpty()) {
                movieId = Integer.parseInt(movieIdString);
                movieId++;
            }
        }   
        
        return movieId;
    }
    
    public String getLastMovie() {
        String movie = "";        
        List<String> movies = getAllMovies();
        int movieCount = getNumberOfMovies(movies);
        
        if (movieCount > 0) {
            movie = movies.get(movieCount);
        }
        
        return movie;
    }
    
    public int getNumberOfMovies(List<String> lines) {
        return FileManager.getLineCount(lines) - 1;
    }
    
    public List<String> getAllMovies() {
        return FileManager.getAllLines(filePath);
    }    
}
