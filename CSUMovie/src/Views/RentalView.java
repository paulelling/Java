package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Models.*;
import Controllers.*;

public class RentalView { // implements ActionListener, RentalObserver {
    RentalModelInterface model;
    RentalControllerInterface controller;
    JFrame viewFrame;
    JPanel viewPanel;
    JLabel statusLabel;
    String status;
    JLabel breakLabel;
    JList movieList;
    JScrollPane movieListScroller;
    JButton rentButton;
    JButton returnButton;
    
}
