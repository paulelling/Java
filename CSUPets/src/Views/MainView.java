package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Models.*;
import Controllers.*;
import Utility.*;

public class MainView implements ActionListener {
    UI ui;
    JFrame viewFrame;
    JPanel viewPanel;
    JLabel statusLabel;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem locationMenuItem;
    JMenu dataMenu;
    JMenuItem petMenuItem;
    JMenuItem vetMenuItem;
    JMenuItem foodMenuItem;
    JMenuItem medicineMenuItem;
    JMenuItem suggestionMenuItem;
    JMenu scheduleMenu;
    
    public MainView() {
        ui = new UI();
    }
    
    public void createView() {
        viewPanel = ui.createPanel(viewPanel);        
        viewFrame = ui.createFrame(viewFrame, "Pet Management Application", 400, 350, true);
        createMenu();
        ui.initializeStatus(viewPanel, statusLabel, "Set file location first");
        ui.assembleFrame(viewFrame, viewPanel, menuBar);     
    }
    
    private void createMenu() {
        menuBar = ui.createMenuBar(menuBar);
        addFileMenu();
        addDataMenu();
        addScheduleMenu();
    }
    
    private void addFileMenu() {
        fileMenu = ui.createMenu(fileMenu, "File");
        locationMenuItem = ui.addMenuItemToMenu(fileMenu, locationMenuItem, "Location", this);
        menuBar.add(fileMenu);
    }
    
    private void addDataMenu() {
        dataMenu = ui.createMenu(dataMenu, "Data");
        petMenuItem = ui.addMenuItemToMenu(dataMenu, petMenuItem, "Pets", this);
        vetMenuItem = ui.addMenuItemToMenu(dataMenu, vetMenuItem, "Vet", this);
        foodMenuItem = ui.addMenuItemToMenu(dataMenu, foodMenuItem, "Food", this);
        medicineMenuItem = ui.addMenuItemToMenu(dataMenu, medicineMenuItem, "Medicine", this);
        suggestionMenuItem = ui.addMenuItemToMenu(dataMenu, suggestionMenuItem, "Suggestions", this);
        menuBar.add(dataMenu);
    }
    
    private void addScheduleMenu() {
        scheduleMenu = ui.createMenu(scheduleMenu, "Schedule");
        menuBar.add(scheduleMenu);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == locationMenuItem) {
            FileLocationView view = new FileLocationView();
            view.run(new FileLocationView(), 250, 110);
        }
        else if (event.getSource() == petMenuItem) {
            PetModelInterface model = new PetModel();
            PetControllerInterface controller = new PetController(model);
        }
        else if (event.getSource() == vetMenuItem) {
            VetModelInterface model = new VetModel();
            VetControllerInterface controller = new VetController(model);
        }
        else if (event.getSource() == foodMenuItem) {
            FoodModelInterface model = new FoodModel();
            FoodControllerInterface controller = new FoodController(model);
        }
        else if (event.getSource() == medicineMenuItem) {
            MedicineModelInterface model = new MedicineModel();
            MedicineControllerInterface controller = new MedicineController(model);
        }
        else if (event.getSource() == suggestionMenuItem) {
            SuggestionModelInterface model = new SuggestionModel();
            SuggestionControllerInterface controller = new SuggestionController(model);
        }
    }
}
