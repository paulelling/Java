package Models;

import java.util.*;

public interface MovieModelInterface {
    void initialize();
    
    int getMovieId();
   
    void setMovieId(int movieId);
   
    String getMovieTitle();
   
    void setMovieTitle(String movieTitle);
   
    boolean getRented();
   
    void setRented(boolean rented);
    
    List<String> getAll();
    
    void create();
    
    void rent();
    
    void returnMovie();
    
    void registerObserver(MovieObserver o);
    
    void removeObserver(MovieObserver o);    
}
