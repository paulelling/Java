package Repository;

import java.util.*;
import Models.*;
import Utility.*;

public class ClientRepository {    
    private String filePath;
    
    public ClientRepository() {
        String filePath = FileManager.getLine(Constants.FilePathFile);
        filePath += "\\clients.txt";        
        this.filePath = filePath;
    }
    
    public void addClient(ClientModel model) {        
        int clientId = getNextClientId();  
        String name = model.getName();
        int deleted = BooleanData.convertBooleanToInt(model.getDeleted());        
        String clientText = clientId + "; " + name + "; " + deleted;
        FileManager.appendToFile(filePath, clientText);
    }
    
    public void deleteClient(int clientId) {        
        FileManager.updateLine(filePath, clientId, "1");
    }
    
    public int getNextClientId() {
        int clientId = 0;
        String client = getLastClient();
        
        if (client.isEmpty()) {            
            clientId = 1;
        }
        else {
            String clientIdString = client.substring(0, client.indexOf(";")).trim(); 
            
            if (!clientIdString.isEmpty()) {
                clientId = Integer.parseInt(clientIdString);
                clientId++;
            }
        }   
        
        return clientId;
    }
    
    public String getLastClient() {
        String client = "";        
        List<String> clients = getAllClients();
        int clientCount = getNumberOfClients(clients);
        
        if (clientCount > 0) {
            client = clients.get(clientCount);
        }
        
        return client;
    }
    
    public int getNumberOfClients(List<String> lines) {
        return FileManager.getLineCount(lines) - 1;
    }
    
    public List<String> getAllClients() {
        return FileManager.getAllLines(filePath);
    }
}
