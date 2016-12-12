package Controllers;

import java.util.*;

public interface MedicineControllerInterface {
    void setMedicineId(int medicineId);     
    void setName(String name);
    void setDeleted(boolean deleted);  
    List<String> getAll();   
    void create();    
    void delete();    
}
