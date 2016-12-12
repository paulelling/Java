package Models;

import java.util.*;
import Repository.*;

public class ClientModel implements ClientModelInterface {
    private ArrayList<ClientObserver> clientObservers = new ArrayList<ClientObserver>();
    private int clientId;
    private String name;
    private boolean deleted;
    private ClientRepository repository;
    
    public void initialize() {  
        repository = new ClientRepository();
    }
   
    public int getClientId() {
        return clientId;
    }
   
    public void setClientId(int clientId) {
        this.clientId = clientId;
        notifyClientObservers();
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyClientObservers();
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
        notifyClientObservers();
    }
    
    public List<String> getAll() {
        resetRepository();
        List<String> clients = repository.getAllClients();
        notifyClientObservers();
        return clients;
    }
    
    public void create() {        
        repository.addClient(this);
        notifyClientObservers();
    }
    
    public void delete() {
        repository.deleteClient(clientId);
        notifyClientObservers();
    }
   
    public void registerObserver(ClientObserver o) {
        clientObservers.add(o);
    }
    
    public void notifyClientObservers() {
        for (int i = 0; i < clientObservers.size(); i++) {
            ClientObserver observer = (ClientObserver)clientObservers.get(i);
            observer.updateClient();
        }
    }
    
    public void removeObserver(ClientObserver o) {
        int i = clientObservers.indexOf(o);
        if (i >= 0) {
            clientObservers.remove(i);
        }
    }
    
    private void resetRepository() {
        if (repository == null) {
            repository = new ClientRepository();        
        }    
    }
}

