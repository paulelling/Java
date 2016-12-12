package Models;

import java.util.*;
import Repository.*;

public class SuggestionModel implements SuggestionModelInterface {
    private ArrayList<SuggestionObserver> suggestionObservers = new ArrayList<SuggestionObserver>();
    private int suggestionId;
    private String title;
    private String description;
    private boolean deleted;
    private SuggestionRepository repository;
    
    public void initialize() {
        repository = new SuggestionRepository();
    }
    
    public int getSuggestionId() {
        return suggestionId;
    }
    
    public void setSuggestionId(int suggestionId) {
        this.suggestionId = suggestionId;
        notifySuggestionObservers();
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
        notifySuggestionObservers();
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
        notifySuggestionObservers();
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
        notifySuggestionObservers();
    }
    
    public List<String> getAll() {
        resetRepository();
        List<String> suggestions = repository.getAllSuggestions();
        notifySuggestionObservers();
        return suggestions;        
    }
    
    public void create() {
        repository.addSuggestion(this);
        notifySuggestionObservers();
    }
    
    public void delete() {
        repository.deleteSuggestion(suggestionId);
        notifySuggestionObservers();
    }
    
    public void registerObserver(SuggestionObserver o) {
        suggestionObservers.add(o);
    }
    
    public void notifySuggestionObservers() {
        for (int i = 0; i < suggestionObservers.size(); i++) {
            SuggestionObserver observer = (SuggestionObserver)suggestionObservers.get(i);
            observer.updateSuggestion();
        }
    } 
    
    public void removeObserver(SuggestionObserver o) {
        int i = suggestionObservers.indexOf(o);
        if (i >= 0) {
            suggestionObservers.remove(i);
        }        
    }
    
    private void resetRepository() {
        if (repository == null) {
            repository = new SuggestionRepository();        
        }    
    }     
    
}
