package Models;

import java.util.*;

public interface PetModelInterface {
    void initialize();
    
    int getPetId();
   
    void setPetId(int petId);
   
    String getName();
   
    void setName(String name);
   
    String getSpecies();
   
    void setSpecies(String species);
   
    String getBreed();
   
    void setBreed(String breed);
   
    String getGender();
   
    void setGender(String gender);
   
    Date getDateOfBirth();
   
    void setDateOfBirth(Date dateOfBirth);
   
    String getColor();
   
    void setColor(String color);
   
    boolean getDeleted();
   
    void setDeleted(boolean deleted);
    
    List<String> getAll();
    
    void create();
    
    void delete();
    
    void registerObserver(PetObserver o);
    
    void removeObserver(PetObserver o);    
}
