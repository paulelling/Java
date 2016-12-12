package Models;

import java.util.Date;

public class RentalModel {
    private int rentalId;
    private int clientId;
    private int movieId;
    private Date dateOut;
    private Date dateIn;
    
    public RentalModel() {
    }
    
    public RentalModel(int rentalId, int clientId, int movieId, Date dateOut, Date dateIn) {
        this.rentalId = rentalId;
        this.clientId = clientId;
        this.movieId = movieId;
        this.dateOut = dateOut;
        this.dateIn = dateIn;
    }
    
    public int getRentalId() {
        return rentalId;
    }
    
    public void setRentalId() {
        this.rentalId = rentalId;
    }
    
    public int getClientId() {
        return clientId;
    }
   
    public void setClientId(int clientId) {
       this.clientId = clientId;
    }
    
    public int getMovieId() {
        return movieId;
    }
    
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    
    public Date getDateOut() {
        return dateOut;
    }
    
    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }
    
    public Date getDateIn() {
        return dateIn;
    }
    
    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }
}
