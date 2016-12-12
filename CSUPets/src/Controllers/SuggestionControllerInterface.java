package Controllers;

import java.util.*;

public interface SuggestionControllerInterface {
    void setSuggestionId(int suggestionId);   
    void setTitle(String title);    
    void setDescription(String description);
    void setDeleted(boolean deleted);    
    List<String> getAll();    
    void create();    
    void delete();      
}
