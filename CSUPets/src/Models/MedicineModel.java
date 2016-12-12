package Models;

import java.util.*;
import Repository.*;

public class MedicineModel implements MedicineModelInterface {
    private ArrayList<MedicineObserver> medicineObservers = new ArrayList<MedicineObserver>();
    private int medicineId;
    private String name;
    private boolean deleted;
    private MedicineRepository repository;
    
    public void initialize() {
        repository = new MedicineRepository();
    }
    
    public int getMedicineId() {
        return medicineId;
    }
    
    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
        notifyMedicineObservers();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
        notifyMedicineObservers();
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
        notifyMedicineObservers();
    }
    
    public List<String> getAll() {
        resetRepository();
        List<String> medicines = repository.getAllMedicines();
        notifyMedicineObservers();
        return medicines;
    }
    
    public void create() {
        repository.addMedicine(this);
        notifyMedicineObservers();
    }
    
    public void delete() {
        repository.deleteMedicine(medicineId);
        notifyMedicineObservers();
    }
    
    public void registerObserver(MedicineObserver o) {
        medicineObservers.add(o);
    }
    
    public void notifyMedicineObservers() {
        for (int i = 0; i < medicineObservers.size(); i++) {
            MedicineObserver observer = (MedicineObserver)medicineObservers.get(i);
            observer.updateMedicine();
        }
    } 
    
    public void removeObserver(MedicineObserver o) {
        int i = medicineObservers.indexOf(o);
        if (i >= 0) {
            medicineObservers.remove(i);
        }        
    }
    
    private void resetRepository() {
        if (repository == null) {
            repository = new MedicineRepository();        
        }    
    }   
    
}
