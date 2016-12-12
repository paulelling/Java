package Models;

import java.util.*;

public interface SuggestionModelInterface {
    void initialize();
    
    int getSuggestionId();
   
    void setSuggestionId(int suggestionId);
   
    String getTitle();
   
    void setTitle(String title);
    
    String getDescription();
    
    void setDescription(String description);
   
    boolean getDeleted();
   
    void setDeleted(boolean deleted);
    
    List<String> getAll();
    
    void create();
    
    void delete();
    
    void registerObserver(SuggestionObserver o);
    
    void removeObserver(SuggestionObserver o);    
    
}
