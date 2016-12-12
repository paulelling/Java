package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Models.*;
import Controllers.*;

public class VetView implements ActionListener, VetObserver {
    VetModelInterface model;
    VetControllerInterface controller;
    
    public VetView(VetControllerInterface controller, VetModelInterface model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver((VetObserver)this);
    }
    
    public void createView() {
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void updateVet() {
    }
    
}
