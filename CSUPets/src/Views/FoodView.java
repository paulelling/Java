package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Models.*;
import Controllers.*;

public class FoodView implements ActionListener, FoodObserver {
    FoodModelInterface model;
    FoodControllerInterface controller;
    
    public FoodView(FoodControllerInterface controller, FoodModelInterface model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver((FoodObserver)this);
    }
    
    public void createView() {
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void updateFood() {
    }
    
}
