package Repository;

import java.util.*;
import Models.*;
import Utility.*;

public class SuggestionRepository {
    private String filePath;
    
    public SuggestionRepository() {
    }
    
    public void addSuggestion(SuggestionModel model) {
    
    }
    
    public void deleteSuggestion(int suggestionId) {
    
    }
    
    public List<String> getAllSuggestions() {
        return FileManager.getAllLines(filePath);
    }      
}
