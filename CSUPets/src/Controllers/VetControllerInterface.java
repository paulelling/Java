package Controllers;

import java.util.*;

public interface VetControllerInterface {
    void setVetId(int vetId);   
    void setName(String name);   
    void setAddress(String address);   
    void setCity(String city);   
    void setState(String state);   
    void setZip(String zip);   
    void setPhoneNumber(String phoneNumber);
    void setDeleted(boolean deleted);
    List<String> getAll();
    void create();
    void delete();    
}
