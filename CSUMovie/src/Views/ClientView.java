package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Models.*;
import Controllers.*;

public class ClientView implements ActionListener, ClientObserver {
    ClientModelInterface model;
    ClientControllerInterface controller;
    JFrame viewFrame;
    JPanel viewPanel;
    JLabel nameLabel;
    JTextField nameTextField;
    JButton createButton;
    JLabel statusLabel;
    String status;
    JLabel breakLabel;
    JList clientList;
    JScrollPane clientListScroller;
    JLabel deleteBreakLabel;
    JButton deleteButton;
    
    public ClientView(ClientControllerInterface controller, ClientModelInterface model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver((ClientObserver)this);
    }
    
    public void createView() {
        viewPanel = new JPanel();
        viewPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.Y_AXIS));
        
        nameLabel = new JLabel("Enter Name:");
        nameTextField = new JTextField();       
        createButton = new JButton("Create");
        createButton.addActionListener(this);
        statusLabel = new JLabel("");
        breakLabel = new JLabel(" ");
        
        deleteBreakLabel = new JLabel(" ");
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        
        viewPanel.add(nameLabel);
        viewPanel.add(nameTextField);
        viewPanel.add(createButton);
        viewPanel.add(statusLabel);
        viewPanel.add(breakLabel);
        addClientsToPanel();
        addDeleteButtonToPanel();
        
        viewFrame = new JFrame();
        viewFrame.setTitle("Clients");
        viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        viewFrame.setSize(400, 400);    
        viewFrame.setVisible(true);
        viewFrame.setLocationRelativeTo(null); 
        
        viewFrame.getContentPane().add(viewPanel, BorderLayout.NORTH);
    }
    
    private void addClientsToPanel() {
        clientList = new JList(getClientList());
        clientListScroller = new JScrollPane(clientList);
        viewPanel.add(clientListScroller);
    }
    
    private void removeClientsFromPanel() {
        viewPanel.remove(clientListScroller);
    }
    
    private void addDeleteButtonToPanel() {
        viewPanel.add(deleteBreakLabel);
        viewPanel.add(deleteButton);    
    }
    
    private void removeDeleteButtonFromPanel() {
        viewPanel.remove(deleteBreakLabel);
        viewPanel.remove(deleteButton);
    }
    
    private void clearTextField(JTextField textField) {
        textField.setText("");
    }
    
    private Object[] getClientList() {
        java.util.List<String> clients = controller.getAll();        
        return clients.toArray();
    }
    
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == createButton) {
            String name = nameTextField.getText();
            
            if (name.isEmpty()) {
                status = "Name is required";
                updateClient();
            }
            else {
                controller.setName(name);
                controller.setDeleted(false);
                controller.create();
                clearTextField(nameTextField);
                status = "Created client";
                updateClient();
                removeClientsFromPanel();
                addClientsToPanel();
                removeDeleteButtonFromPanel();
                addDeleteButtonToPanel();
            }
        }
        else if (event.getSource() == deleteButton) {  
            int selectedClientIndex = clientList.getSelectedIndex();
            
            if (selectedClientIndex == -1) {
                status = "No client was selected";
                updateClient();
            }
            else {
                controller.setClientId(selectedClientIndex);
                controller.setDeleted(true);
                controller.delete();
                clientList.setSelectedIndex(-1);
                status = "Deleted client";
                updateClient();
                removeClientsFromPanel();
                addClientsToPanel();
                removeDeleteButtonFromPanel();
                addDeleteButtonToPanel();                
            }
        }
    }
    
    public void updateClient() {
        statusLabel.setText(this.status);
    }
}
