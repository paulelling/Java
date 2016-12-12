package Models;

import java.util.*;

public interface ClientModelInterface {
    void initialize();
    
    int getClientId();
   
    void setClientId(int clientId);
   
    String getName();
   
    void setName(String name);
   
    boolean getDeleted();
   
    void setDeleted(boolean deleted);
    
    List<String> getAll();
    
    void create();
    
    void delete();
    
    void registerObserver(ClientObserver o);
    
    void removeObserver(ClientObserver o);
}
