package Controllers;

import java.util.*;

public interface MovieControllerInterface {
    void setMovieId(int movieId);
    void setMovieTitle(String movieTitle);
    void setRented(boolean rented);
    List<String> getAll();
    void create(); 
    void rent();
    void returnMovie();
}
