package Models;

import java.util.*;
import Repository.*;

public class PetModel implements PetModelInterface {
    private ArrayList<PetObserver> petObservers = new ArrayList<PetObserver>();
    private int petId;
    private String name;
    private String species;
    private String breed;
    private String gender;
    private Date dateOfBirth;
    private String color;
    private boolean deleted;
    private PetRepository repository;    
    
    public void initialize() {  
        repository = new PetRepository();
    }    
    
    public int getPetId() {
        return petId;
    }
   
    public void setPetId(int petId) {
        this.petId = petId;
        notifyPetObservers();
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPetObservers();
    }   
        
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
        notifyPetObservers();
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
        notifyPetObservers();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        notifyPetObservers();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        notifyPetObservers();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        notifyPetObservers();
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
        notifyPetObservers();
    }

    public List<String> getAll() {
        resetRepository();
        List<String> pets = repository.getAllPets();
        notifyPetObservers();
        return pets;
    }

    public void create() {
        repository.addPet(this);
        notifyPetObservers();
    }

    public void delete() {
        repository.deletePet(petId);
        notifyPetObservers();        
    }    
    
    public void registerObserver(PetObserver o) {
        petObservers.add(o);
    }
    
    public void notifyPetObservers() {
        for (int i = 0; i < petObservers.size(); i++) {
            PetObserver observer = (PetObserver)petObservers.get(i);
            observer.updatePet();
        }
    }
    
    public void removeObserver(PetObserver o) {
        int i = petObservers.indexOf(o);
        if (i >= 0) {
            petObservers.remove(i);
        }
    }
    
    private void resetRepository() {
        if (repository == null) {
            repository = new PetRepository();        
        }    
    }    
}
