package Repository;

import java.util.*;
import Models.*;
import Utility.*;

public class PetRepository {
    private String filePath;
    
    public PetRepository() {
        String filePath = FileManager.getLine(Constants.FilePathFile);
        filePath += "\\pets.txt";        
        this.filePath = filePath;        
    }
    
    public void addPet(PetModel model) {
    
    }
    
    public void deletePet(int petId) {
    
    }
    
    public List<String> getAllPets() {
        return FileManager.getAllLines(filePath);
    }    
}
