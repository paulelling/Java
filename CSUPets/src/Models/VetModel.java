package Models;

import java.util.*;
import Repository.*;

public class VetModel implements VetModelInterface {
    private ArrayList<VetObserver> vetObservers = new ArrayList<VetObserver>();
    private int vetId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private boolean deleted;
    private VetRepository repository;
    
    public void initialize() {
        repository = new VetRepository();
    }
    
    public int getVetId() {
        return vetId;
    }
    
    public void setVetId(int vetId) {
        this.vetId = vetId;
        notifyVetObservers();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
        notifyVetObservers();
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
        notifyVetObservers();
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
        notifyVetObservers();        
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
        notifyVetObservers();
    }
    
    public String getZip() {
        return zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
        notifyVetObservers();
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyVetObservers();
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
        notifyVetObservers();
    }
    
    public List<String> getAll() {
        resetRepository();
        List<String> vets = repository.getAllVets();
        notifyVetObservers();
        return vets;
    }
    
    public void create() {
        repository.addVet(this);
        notifyVetObservers();
    }
    
    public void delete() {
        repository.deleteVet(vetId);
        notifyVetObservers();
    }
    
    public void registerObserver(VetObserver o) {
        vetObservers.add(o);
    }
    
    public void notifyVetObservers() {
        for (int i = 0; i < vetObservers.size(); i++) {
            VetObserver observer = (VetObserver)vetObservers.get(i);
            observer.updateVet();
        }
    }
    
    public void removeObserver(VetObserver o) {
        int i = vetObservers.indexOf(o);
        if (i >= 0) {
            vetObservers.remove(i);
        }
    }
    
    private void resetRepository() {
        if (repository == null) {
            repository = new VetRepository();        
        }    
    }     
    
}
