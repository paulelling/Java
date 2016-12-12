package Controllers;

import Models.*;
import Views.*;
import java.util.*;

public class PetController implements PetControllerInterface {
    PetModelInterface model;
    PetView view;
    
    public PetController(PetModelInterface model) {
        this.model = model;
        view = new PetView(this, model);
        view.createView();
        model.initialize();
    }
    
    public void setPetId(int petId) {
        model.setPetId(petId);
    }
    
    public void setName(String name) {
        model.setName(name);
    }
    
    public void setSpecies(String species) {
        model.setSpecies(species);
    }
    
    public void setBreed(String breed) {
        model.setBreed(breed);
    }
    
    public void setGender(String gender) {
        model.setGender(gender);
    }
    
    public void setDateOfBirth(Date dateOfBirth) {
        model.setDateOfBirth(dateOfBirth);
    }
    
    public void setColor(String color) {
        model.setColor(color);
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
