package Repository;

import java.util.*;
import Models.*;
import Utility.*;

public class FoodRepository {
    private String filePath;
    
    public FoodRepository() {
    }
    
    public void addFood(FoodModel model) {
    
    }
    
    public void deleteFood(int foodId) {
    
    }
    
    public List<String> getAllFoods() {
        return FileManager.getAllLines(filePath);
    }      
}
