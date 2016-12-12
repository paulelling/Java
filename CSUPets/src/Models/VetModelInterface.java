package Models;

import java.util.*;

public interface VetModelInterface {
    void initialize();
    
    int getVetId();
   
    void setVetId(int vetId);    
    
    String getName();
   
    void setName(String name);       
    
    String getAddress();
   
    void setAddress(String address);       
    
    String getCity();
   
    void setCity(String city);      
    
    String getState();
   
    void setState(String state);      
    
    String getZip();
   
    void setZip(String zip);         
    
    String getPhoneNumber();
   
    void setPhoneNumber(String phoneNumber);
   
    boolean getDeleted();
   
    void setDeleted(boolean deleted);    
    
    List<String> getAll();
    
    void create();
    
    void delete();
    
    void registerObserver(VetObserver o);
    
    void removeObserver(VetObserver o);     
}
