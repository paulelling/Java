package Controllers;

import java.util.*;

public interface PetControllerInterface {
    void setPetId(int petId);
    void setName(String name);
    void setSpecies(String species);
    void setBreed(String breed);
    void setGender(String gender);
    void setDateOfBirth(Date dateOfBirth);
    void setColor(String color);
    void setDeleted(boolean deleted); 
    List<String> getAll();
    void create();
    void delete();
}
