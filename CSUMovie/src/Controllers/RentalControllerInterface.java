package Controllers;

import java.util.*;

public interface RentalControllerInterface {
    void setRentalId(int rentalId);
    void setClientId(int clientId);
    void setMovieId(int movieId);
    void setDateOut(Date dateOut);
    void setDateIn(Date dateIn);
    List<String> getAll();
    void rent();
    void returnMovie();
}
