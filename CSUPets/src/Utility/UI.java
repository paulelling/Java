package Utility;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UI {
    
    public UI() {
    }
    
    public JPanel createPanel(JPanel panel) {
        panel = new JPanel();
        panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));        
        return panel;
    }
    
    public JFrame createFrame(JFrame frame, String title, int width, int height, boolean exitOnClose) {
        frame = new JFrame();
        frame.setTitle(title);
        if (exitOnClose) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else {
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        frame.setSize(width, height);    
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);          
        return frame;
    }
    
    public JMenuBar createMenuBar(JMenuBar menuBar) {
        menuBar = new JMenuBar();
        return menuBar;
    }
    
    public JMenu createMenu(JMenu menu, String name) {
        menu = new JMenu(name);
        return menu;
    }
    
    public JMenuItem createMenuItem(JMenuItem menuItem, String name) {
        menuItem = new JMenuItem(name);
        return menuItem;
    }
    
    public void addMenuItemToMenu(JMenu menu, JMenuItem menuItem) {
        menu.add(menuItem);
    }
    
    public JMenuItem addMenuItemToMenu(JMenu menu, JMenuItem menuItem, String menuItemName) {
        menuItem = createMenuItem(menuItem, menuItemName);
        addMenuItemToMenu(menu, menuItem);
        return menuItem;
    }    
    
    public JMenuItem addMenuItemToMenu(JMenu menu, JMenuItem menuItem, String menuItemName, ActionListener actionListener) {
        menuItem = createMenuItem(menuItem, menuItemName);
        addMenuItemToMenu(menu, menuItem);
        menuItem.addActionListener(actionListener);
        return menuItem;
    }
    
    public void initializeStatus(JPanel panel, JLabel label, String status) {
        label = new JLabel(status);
        panel.add(label);    
    }
    
    public void assembleFrame(JFrame frame, JPanel panel) {
        frame.getContentPane().add(panel, BorderLayout.NORTH);    
    }
    
    public void assembleFrame(JFrame frame, JPanel panel, JMenuBar menuBar) {
        frame.setJMenuBar(menuBar);        
        frame.getContentPane().add(panel, BorderLayout.NORTH);    
    }
    
    public JLabel addLabelToPanel(JPanel panel, JLabel label, String labelName) {
        label = new JLabel(labelName);
        panel.add(label);
        return label;
    }
    
    public JTextField addTextFieldToPanel(JPanel panel, JTextField textField) {
        textField = new JTextField();
        panel.add(textField);
        return textField;
    }
    
}
