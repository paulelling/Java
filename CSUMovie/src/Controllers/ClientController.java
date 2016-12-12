package Controllers;

import Models.*;
import Views.*;
import Repository.*;
import java.util.*;

public class ClientController implements ClientControllerInterface {
    ClientModelInterface model;
    ClientView view;
    
    public ClientController(ClientModelInterface model) {
        this.model = model;
        view = new ClientView(this, model);
        view.createView();
        model.initialize();
    }
    
    public void setClientId(int clientId) {
        model.setClientId(clientId);
    }
    
    public void setName(String name) {
        model.setName(name);
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
