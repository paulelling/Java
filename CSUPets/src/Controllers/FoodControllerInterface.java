package Controllers;

import java.util.*;

public interface FoodControllerInterface {
    void setFoodId(int foodId);     
    void setName(String name);
    void setDeleted(boolean deleted); 
    List<String> getAll();   
    void create();    
    void delete();    
}
