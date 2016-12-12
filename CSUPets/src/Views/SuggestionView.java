package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Models.*;
import Controllers.*;

public class SuggestionView implements ActionListener, SuggestionObserver {
    SuggestionModelInterface model;
    SuggestionControllerInterface controller;
    
    public SuggestionView(SuggestionControllerInterface controller, SuggestionModelInterface model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver((SuggestionObserver)this);
    }
    
    public void createView() {
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void updateSuggestion() {
    }
    
}
