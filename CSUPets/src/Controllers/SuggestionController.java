package Controllers;

import Models.*;
import Views.*;
import java.util.*;

public class SuggestionController implements SuggestionControllerInterface {
    SuggestionModelInterface model;
    SuggestionView view;
    
    public SuggestionController(SuggestionModelInterface model) {
        this.model = model;
        view = new SuggestionView(this, model);
        view.createView();
        model.initialize();
    }
    
    public void setSuggestionId(int suggestionId) {
        model.setSuggestionId(suggestionId);
    }
    
    public void setTitle(String title) {
        model.setTitle(title);
    }
    
    public void setDescription(String description) {
        model.setDescription(description);
    }
    
    public void setDeleted(boolean deleted) {
        model.setDeleted(deleted);
    }
    
    public List<String> getAll() {
        return model.getAll();
    }
    
    public void create() {
        model.create();
    }
    
    public void delete() {
        model.delete();
    }
    
}
