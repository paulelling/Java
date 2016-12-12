package Repository;

import java.util.*;
import Models.*;
import Utility.*;

public class VetRepository {
    private String filePath;
    
    public VetRepository() {
    }
    
    public void addVet(VetModel model) {
    
    }
    
    public void deleteVet(int vetId) {
    
    }
    
    public List<String> getAllVets() {
        return FileManager.getAllLines(filePath);
    }     
}
