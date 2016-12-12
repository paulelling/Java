package Models;

import java.util.*;

public interface FoodModelInterface {
    void initialize();
    
    int getFoodId();
   
    void setFoodId(int foodId);
   
    String getName();
   
    void setName(String name);
   
    boolean getDeleted();
   
    void setDeleted(boolean deleted);
    
    List<String> getAll();
    
    void create();
    
    void delete();
    
    void registerObserver(FoodObserver o);
    
    void removeObserver(FoodObserver o);    
}
