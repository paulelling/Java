package Controllers;

import Models.*;
import Views.*;
import Repository.*;
import java.util.*;

public class MovieController implements MovieControllerInterface {
    MovieModelInterface model;
    MovieView view;

    public MovieController(MovieModelInterface model) {
        this.model = model;
        view = new MovieView(this, model);
        view.createView();
        model.initialize();
    }
    
    public void setMovieId(int movieId) {
        model.setMovieId(movieId);
    }
    
    public void setMovieTitle(String movieTitle) {
        model.setMovieTitle(movieTitle);
    }
    
    public void setRented(boolean rented) {
        model.setRented(rented);
    }
    
    public List<String> getAll() {
        return model.getAll();
    }
    
    public void create() {
        model.create();
    }       
    
    public void rent() {
        model.rent();
    }
    
    public void returnMovie() {
        model.returnMovie();
    }
}
