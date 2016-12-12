package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Models.*;
import Controllers.*;
import Utility.*;

public class MainView implements ActionListener {
    JFrame viewFrame;
    JPanel viewPanel;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem locationMenuItem;
    JMenu clientMenu;
    JMenuItem getAllClientsMenuItem;
    JMenuItem createClientMenuItem;
    JMenu movieMenu;
    JMenuItem getAllMoviesMenuItem;
    JMenuItem createMovieMenuItem;
    JLabel statusLabel;
    
    public MainView() {
    }
    
    public void createView() {
        viewPanel = new JPanel();
        setViewPanel();
        
        viewFrame = new JFrame();
        setViewFrame();
        
        menuBar = new JMenuBar();        
        addFileMenu();
        addClientMenu();
        addMovieMenu();
        
        statusLabel = new JLabel("Set file location first");
        viewPanel.add(statusLabel);

        viewFrame.setJMenuBar(menuBar);        
        viewFrame.getContentPane().add(viewPanel, BorderLayout.NORTH);
    }
    
    private void setViewPanel() {
        viewPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.Y_AXIS));    
    }
    
    private void setViewFrame() {
        viewFrame.setTitle("Rental Management System");
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        viewFrame.setSize(400, 350);    
        viewFrame.setVisible(true);
        viewFrame.setLocationRelativeTo(null);      
    }
    
    private void addFileMenu() {
        fileMenu = new JMenu("File");
        addFileLocationMenuItem();
        menuBar.add(fileMenu);
    }
    
    private void addFileLocationMenuItem() {
        locationMenuItem = new JMenuItem("Location");
        fileMenu.add(locationMenuItem);        
        locationMenuItem.addActionListener(this);    
    }
    
    private void addClientMenu() {
        clientMenu = new JMenu("Client");
        addGetAllClientsMenuItem();
        addCreateClientMenuItem();
        menuBar.add(clientMenu);
    }
    
    private void addGetAllClientsMenuItem() {
        getAllClientsMenuItem = new JMenuItem("Get All");
        clientMenu.add(getAllClientsMenuItem);
        getAllClientsMenuItem.addActionListener(this);
    }
    
    private void addCreateClientMenuItem() {
        createClientMenuItem = new JMenuItem("Create");
        clientMenu.add(createClientMenuItem);
        createClientMenuItem.addActionListener(this);
    }
    
    private void addMovieMenu() {
        movieMenu = new JMenu("Movie");
        addGetAllMoviesMenuItem();
        addCreateMovieMenuItem();
        menuBar.add(movieMenu);
    }
    
    private void addGetAllMoviesMenuItem() {
        getAllMoviesMenuItem = new JMenuItem("Get All");
        movieMenu.add(getAllMoviesMenuItem);
        getAllMoviesMenuItem.addActionListener(this);
    }
    
    private void addCreateMovieMenuItem() {
        createMovieMenuItem = new JMenuItem("Create");
        movieMenu.add(createMovieMenuItem);
        createMovieMenuItem.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == locationMenuItem) {
            FileLocationView view = new FileLocationView();
            view.run(new FileLocationView(), 250, 110);
        }
        else if (event.getSource() == getAllClientsMenuItem) {
            ClientModelInterface model = new ClientModel();
            ClientControllerInterface controller = new ClientController(model);   
        }
        else if (event.getSource() == createClientMenuItem) {
            ClientModelInterface model = new ClientModel();
            ClientControllerInterface controller = new ClientController(model);            
        }
        else if (event.getSource() == getAllMoviesMenuItem) {
            MovieModelInterface model = new MovieModel();
            MovieControllerInterface controller = new MovieController(model);
        }
        else if (event.getSource() == createMovieMenuItem) {
            MovieModelInterface model = new MovieModel();
            MovieControllerInterface controller = new MovieController(model);
        }
    }    
}
