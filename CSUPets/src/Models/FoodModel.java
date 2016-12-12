package Models;

import java.util.*;
import Repository.*;

public class FoodModel implements FoodModelInterface {
    private ArrayList<FoodObserver> foodObservers = new ArrayList<FoodObserver>();
    private int foodId;
    private String name;
    private boolean deleted;
    private FoodRepository repository;    
    
    public void initialize() {
        repository = new FoodRepository();
    }
    
    public int getFoodId() {
        return foodId;
    }
    
    public void setFoodId(int foodId) {
        this.foodId = foodId;
        notifyFoodObservers();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
        notifyFoodObservers();
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
        notifyFoodObservers();
    }
    
    public List<String> getAll() {
        resetRepository();
        List<String> foods = repository.getAllFoods();
        notifyFoodObservers();
        return foods;        
    }
    
    public void create() {
        repository.addFood(this);
        notifyFoodObservers();
    }
    
    public void delete() {
        repository.deleteFood(foodId);
        notifyFoodObservers();
    }
    
    public void registerObserver(FoodObserver o) {
        foodObservers.add(o);
    }
    
    public void notifyFoodObservers() {
        for (int i = 0; i < foodObservers.size(); i++) {
            FoodObserver observer = (FoodObserver)foodObservers.get(i);
            observer.updateFood();
        }
    } 
    
    public void removeObserver(FoodObserver o) {
        int i = foodObservers.indexOf(o);
        if (i >= 0) {
            foodObservers.remove(i);
        }        
    }
    
    private void resetRepository() {
        if (repository == null) {
            repository = new FoodRepository();        
        }    
    }     
}
