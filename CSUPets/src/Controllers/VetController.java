package Controllers;

import Models.*;
import Views.*;
import java.util.*;

public class VetController implements VetControllerInterface {
    VetModelInterface model;
    VetView view;
    
    public VetController(VetModelInterface model) {
        this.model = model;
        view = new VetView(this, model);
        view.createView();
        model.initialize();
    }
    
    public void setVetId(int vetId) {
        model.setVetId(vetId);
    }
    
    public void setName(String name) {
        model.setName(name);
    }
    
    public void setAddress(String address) {
        model.setAddress(address);
    }
    
    public void setCity(String city) {
        model.setCity(city);
    }
    
    public void setState(String state) {
        model.setState(state);
    }
    
    public void setZip(String zip) {
        model.setZip(zip);
    }
    
    public void setPhoneNumber(String phoneNumber) {
        model.setPhoneNumber(phoneNumber);
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
