package Controllers;

import Models.*;
import Views.*;
import java.util.*;

public class FoodController implements FoodControllerInterface {
    FoodModelInterface model;
    FoodView view;
    
    public FoodController(FoodModelInterface model) {
        this.model = model;
        view = new FoodView(this, model);
        view.createView();
        model.initialize();
    }
    
    public void setFoodId(int foodId) {
        model.setFoodId(foodId);
    }
    
    public void setName(String name) {
        model.setName(name);
    }
    
    public void setDeleted(boolean deleted) {
        model.setDeleted(deleted);
    }
    
    public List<String> getAll() {
        return model.getAll();
    }
    
    public void create() {
        model.create();
    }
    
    public void delete() {
        model.delete();
    }
    
}
