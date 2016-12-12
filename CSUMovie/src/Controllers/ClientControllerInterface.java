package Controllers;

import java.util.*;

public interface ClientControllerInterface {
    void setClientId(int clientId);
    void setName(String name);
    void setDeleted(boolean deleted);
    List<String> getAll();
    void create();
    void delete();
}
