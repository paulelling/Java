package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Models.*;
import Controllers.*;

public class MedicineView implements ActionListener, MedicineObserver {
    MedicineModelInterface model;
    MedicineControllerInterface controller;
    
    public MedicineView(MedicineControllerInterface controller, MedicineModelInterface model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver((MedicineObserver)this);
    }
    
    public void createView() {
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void updateMedicine() {
    }
    
}
