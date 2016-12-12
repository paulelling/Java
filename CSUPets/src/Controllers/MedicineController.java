package Controllers;

import Models.*;
import Views.*;
import java.util.*;

public class MedicineController implements MedicineControllerInterface {
    MedicineModelInterface model;
    MedicineView view;
    
    public MedicineController(MedicineModelInterface model) {
        this.model = model;
        view = new MedicineView(this, model);
        view.createView();
        model.initialize();
    }
    
    public void setMedicineId(int medicineId) {
        model.setMedicineId(medicineId);
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
