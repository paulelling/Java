package Models;

import java.util.*;

public interface MedicineModelInterface {
    void initialize();
    
    int getMedicineId();
   
    void setMedicineId(int medicineId);
   
    String getName();
   
    void setName(String name);
   
    boolean getDeleted();
   
    void setDeleted(boolean deleted);
    
    List<String> getAll();
    
    void create();
    
    void delete();
    
    void registerObserver(MedicineObserver o);
    
    void removeObserver(MedicineObserver o);        
}
