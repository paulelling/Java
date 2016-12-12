package Models;

import java.util.*;

public interface RentalModelInterface {
    void initialize();
    
    int getRentalId();
   
    void setRentalId(int rentalId);
    
    int getMovieId();
   
    void setMovieId(int movieId);
    
    int getClientId();
   
    void setClientId(int clientId);
    
    Date getDateOut();
    
    void setDateOut(Date dateOut);
    
    Date getDateIn();
    
    void setDateIn(Date dateIn);
    
    List<String> getAll();
    
    void rent();
    
    void returnMovie();
    
    void registerObserver(MovieObserver o);
    
    void removeObserver(MovieObserver o);        
}
