package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Models.*;
import Controllers.*;

public class MovieView implements ActionListener, MovieObserver {
    MovieModelInterface model;
    MovieControllerInterface controller;
    JFrame viewFrame;
    JPanel viewPanel;
    JLabel movieTitleLabel;
    JTextField movieTitleTextField;
    JButton createButton;
    JLabel statusLabel;
    String status;
    JLabel breakLabel;
    JList movieList;
    JScrollPane movieListScroller;    
    JLabel deleteBreakLabel;
    JButton deleteButton;
    JButton returnButton;
    
    public MovieView(MovieControllerInterface controller, MovieModelInterface model) {
        this.controller = controller;
        this.model = model;
        model.registerObserver((MovieObserver)this);
    }    
    
    public void createView() {
        viewPanel = new JPanel();
        viewPanel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.Y_AXIS));
        
        movieTitleLabel = new JLabel("Enter Movie Title:");
        movieTitleTextField = new JTextField();       
        createButton = new JButton("Create");
        createButton.addActionListener(this);
        statusLabel = new JLabel("");
        breakLabel = new JLabel(" ");
        deleteBreakLabel = new JLabel(" ");
        deleteButton = new JButton("Rent");
        deleteButton.addActionListener(this);
        returnButton = new JButton("Return");
        returnButton.addActionListener(this);
        
        viewPanel.add(movieTitleLabel);
        viewPanel.add(movieTitleTextField);
        viewPanel.add(createButton);
        viewPanel.add(statusLabel);  
        viewPanel.add(breakLabel);        
        addMoviesToPanel();
        addDeleteButtonToPanel();
        addReturnButtonToPanel();
        
        viewFrame = new JFrame();
        viewFrame.setTitle("Movies");
        viewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
        viewFrame.setSize(400, 400);    
        viewFrame.setVisible(true);
        viewFrame.setLocationRelativeTo(null); 
        
        viewFrame.getContentPane().add(viewPanel, BorderLayout.NORTH);
    }
    
    private void addMoviesToPanel() {
        movieList = new JList(getMoviesList());
        movieListScroller = new JScrollPane(movieList);
        viewPanel.add(movieListScroller);
    }
    
    private void removeMoviesFromPanel() {
        viewPanel.remove(movieListScroller);
    }
    
    private void addDeleteButtonToPanel() {
        viewPanel.add(deleteBreakLabel);
        viewPanel.add(deleteButton);    
    }
    
    private void removeDeleteButtonFromPanel() {
        viewPanel.remove(deleteBreakLabel);
        viewPanel.remove(deleteButton);
    }
    
    private void addReturnButtonToPanel() {
        viewPanel.add(returnButton);
    }
    
    private void removeReturnButtonFromPanel() {
        viewPanel.remove(returnButton);
    }
    
    private void clearTextField(JTextField textField) {
        textField.setText("");
    }
    
    private Object[] getMoviesList() {
        java.util.List<String> movies = controller.getAll();        
        return movies.toArray();
    }
    
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == createButton) {
            String movieTitle = movieTitleTextField.getText();
            
            if (movieTitle.isEmpty()) {
                status = "Move title is required";
                updateMovie();
            }
            else {
                controller.setMovieTitle(movieTitle);
                controller.setRented(false);
                controller.create();
                clearTextField(movieTitleTextField);
                status = "Created movie";
                updateMovie();
                removeMoviesFromPanel();
                addMoviesToPanel();
                removeDeleteButtonFromPanel();
                addDeleteButtonToPanel();
            }
        }
        else if (event.getSource() == deleteButton) {  
            int selectedMovieIndex = movieList.getSelectedIndex();
            
            if (selectedMovieIndex == -1) {
                status = "No movie was selected";
                updateMovie();
            }
            else {
                controller.setMovieId(selectedMovieIndex);
                controller.setRented(true);
                controller.rent();
                movieList.setSelectedIndex(-1);
                status = "Rented movie";
                updateMovie();
                removeMoviesFromPanel();
                addMoviesToPanel();
                removeDeleteButtonFromPanel();
                addDeleteButtonToPanel();     
                removeReturnButtonFromPanel();
                addReturnButtonToPanel();           
            }
        }       
        else if (event.getSource() == returnButton) {
            int selectedMovieIndex = movieList.getSelectedIndex();
            
            if (selectedMovieIndex == -1) {
                status = "No movie was selected";
                updateMovie();
            }
            else {
                controller.setMovieId(selectedMovieIndex);
                controller.setRented(false);
                controller.returnMovie();
                movieList.setSelectedIndex(-1);
                status = "Returned movie";
                updateMovie();
                removeMoviesFromPanel();
                addMoviesToPanel();
                removeDeleteButtonFromPanel();
                addDeleteButtonToPanel();  
                removeReturnButtonFromPanel();
                addReturnButtonToPanel();
            }            
        }
    }
    
    public void updateMovie() {
        statusLabel.setText(this.status);
    }    
}
