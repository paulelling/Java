package Repository;

import java.util.*;
import Models.*;
import Utility.*;

public class MedicineRepository {
    private String filePath;
    
    public MedicineRepository() {
    }
    
    public void addMedicine(MedicineModel model) {
    
    }
    
    public void deleteMedicine(int medicineId) {
    
    }
    
    public List<String> getAllMedicines() {
        return FileManager.getAllLines(filePath);
    }          
}
