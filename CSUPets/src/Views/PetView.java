package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import Models.*;
import Controllers.*;
import Utility.*;

public class PetView implements ActionListener, PetObserver {
    PetModelInterface model;
    PetControllerInterface controller;
    UI ui;
    JFrame viewFrame;
    JPanel viewPanel;
    JLabel statusLabel;
    String status;
    JLabel nameLabel;
    JTextField nameTextField;
    JLabel speciesLabel;
    JTextField speciesTextField;
    JLabel breedLabel;
    JTextField breedTextField;
    JLabel genderLabel;
    JTextField genderTextField;
    JLabel dateOfBirthLabel;
    JTextField dateOfBirthTextField;
    JLabel colorLabel;
    JTextField colorTextField;
    JList petList;
    JScrollPane petListScroller;
    JButton createButton;
    JLabel breakLabel;
    JLabel deleteBreakLabel;
    JButton deleteButton;
    
    public PetView(PetControllerInterface controller, PetModelInterface model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver((PetObserver)this);
        ui = new UI();
    }
    
    public void createView() {
        viewPanel = ui.createPanel(viewPanel);        
        viewFrame = ui.createFrame(viewFrame, "Pets", 400, 400, false);
        statusLabel = new JLabel("");
        addCreateForm();
        addDataList();
        viewPanel.add(statusLabel);
        addDeleteButton();
        ui.assembleFrame(viewFrame, viewPanel);
    }
    
    private void addCreateForm() {
        ui.addLabelToPanel(viewPanel, nameLabel, "Enter Name:");
        ui.addTextFieldToPanel(viewPanel, nameTextField);
        ui.addLabelToPanel(viewPanel, speciesLabel, "Enter Species:");
        ui.addTextFieldToPanel(viewPanel, speciesTextField);
        ui.addLabelToPanel(viewPanel, breedLabel, "Enter Breed:");
        ui.addTextFieldToPanel(viewPanel, breedTextField);
        ui.addLabelToPanel(viewPanel, genderLabel, "Enter Gender:");
        ui.addTextFieldToPanel(viewPanel, genderTextField);
        ui.addLabelToPanel(viewPanel, dateOfBirthLabel, "Enter Date of Birth:");
        ui.addTextFieldToPanel(viewPanel, dateOfBirthTextField);
        ui.addLabelToPanel(viewPanel, colorLabel, "Enter Color:");
        ui.addTextFieldToPanel(viewPanel, colorTextField);       
        createButton = new JButton("Create");
        createButton.addActionListener(this);
        viewPanel.add(createButton);
        breakLabel = new JLabel(" ");
        viewPanel.add(breakLabel);
    }
    
    private void addDataList() {
        petList = new JList(getDataList());
        petListScroller = new JScrollPane(petList);
        viewPanel.add(petListScroller);    
    }
    
    private void removeDataList() {
        viewPanel.remove(petListScroller);
    }
    
    private void addDeleteButton() {
        viewPanel.add(deleteBreakLabel);
        viewPanel.add(deleteButton);    
    }
    
    private void removeDeleteButton() {
        viewPanel.remove(deleteBreakLabel);
        viewPanel.remove(deleteButton);
    }
    
    private void clearTextField(JTextField textField) {
        textField.setText("");
    }
    
    private Object[] getDataList() {
        java.util.List<String> pets = controller.getAll();        
        return pets.toArray();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            String name = nameTextField.getText();
            String species = speciesTextField.getText();
            String breed = breedTextField.getText();
            String gender = genderTextField.getText();
            String dateOfBirthString = dateOfBirthTextField.getText();
            String color = colorTextField.getText();
            
            int emptyFieldCount = 0;                                    
            emptyFieldCount = countEmptyField(name, emptyFieldCount);
            emptyFieldCount = countEmptyField(species, emptyFieldCount);
            emptyFieldCount = countEmptyField(breed, emptyFieldCount);
            emptyFieldCount = countEmptyField(gender, emptyFieldCount);
            emptyFieldCount = countEmptyField(dateOfBirthString, emptyFieldCount);
            emptyFieldCount = countEmptyField(color, emptyFieldCount);
            
            if (emptyFieldCount > 0) {
                status = "All fields are required";
                updatePet();
            }
            else {
                Date dateOfBirth = DateData.convertStringToDate(dateOfBirthString);                
                controller.setName(name);
                controller.setSpecies(species);
                controller.setBreed(breed);
                controller.setGender(gender);
                controller.setDateOfBirth(dateOfBirth);
                controller.setColor(color);
                controller.setDeleted(false);
                controller.create();
                clearTextField(nameTextField);
                clearTextField(speciesTextField);
                clearTextField(breedTextField);
                clearTextField(genderTextField);
                clearTextField(dateOfBirthTextField);
                clearTextField(colorTextField);
                status = "Created pet";
                updatePet();
                removeDataList();
                addDataList();
                removeDeleteButton();
                addDeleteButton();
            }
        }
        else if (e.getSource() == deleteButton) {  
            int selectedPetIndex = petList.getSelectedIndex();
            
            if (selectedPetIndex == -1) {
                status = "No pet was selected";
                updatePet();
            }
            else {
                controller.setPetId(selectedPetIndex);
                controller.setDeleted(true);
                controller.delete();
                petList.setSelectedIndex(-1);
                status = "Deleted pet";
                updatePet();
                removeDataList();
                addDataList();
                removeDeleteButton();
                addDeleteButton();
            }
        }        
    }
    
    private int countEmptyField(String field, int counter) {
        if (field.isEmpty()) {
            counter++;
        }
        return counter;
    }

    public void updatePet() {
        statusLabel.setText(this.status);
    }
    
}
