package csu_vm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class CSU_VM extends JFrame {

    private JLabel register0ValueLabel = new JLabel();
    private JLabel register1ValueLabel = new JLabel();
    private JLabel register2ValueLabel = new JLabel();
    private JLabel register3ValueLabel = new JLabel();
    private JTextArea originalProgramTextArea = new JTextArea(10, 20);
    private JTextArea consoleTextArea = new JTextArea(10, 20);
    private JTextArea programTextArea = new JTextArea(10, 20);        
    private JButton startButton = new JButton("Start");
    
    public CSU_VM() {
        JPanel panel = new JPanel();
        panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel memoryLabel = new JLabel("Memory");
        panel.add(memoryLabel);        
        JPanel memoryPanelRow1 = new JPanel();
        addMemoryPanelToMainPanel(panel, memoryPanelRow1, 0, 16);        
        JPanel memoryPanelRow2 = new JPanel();
        addMemoryPanelToMainPanel(panel, memoryPanelRow2, 16, 32);
        JPanel memoryPanelRow3 = new JPanel();
        addMemoryPanelToMainPanel(panel, memoryPanelRow3, 32, 48);
        JPanel memoryPanelRow4 = new JPanel();
        addMemoryPanelToMainPanel(panel, memoryPanelRow4, 48, 64);

        JLabel registersLabel = new JLabel("Registers");
        panel.add(registersLabel);        
        JPanel registersPanel = new JPanel();        
        JLabel register0Label = new JLabel("Reg: 0");
        registersPanel.add(register0Label);
        register0ValueLabel = initRegisterLabel("Register 0");
        registersPanel.add(register0ValueLabel);        
        JLabel register1Label = new JLabel("Reg: 1");
        registersPanel.add(register1Label);
        register1ValueLabel = initRegisterLabel("Register 1");
        registersPanel.add(register1ValueLabel);        
        JLabel register2Label = new JLabel("Reg: 2");
        registersPanel.add(register2Label);
        register2ValueLabel = initRegisterLabel("Register 2");
        registersPanel.add(register2ValueLabel);
        JLabel register3Label = new JLabel("Reg: 3");
        registersPanel.add(register3Label);
        register3ValueLabel = initRegisterLabel("Register 3");
        registersPanel.add(register3ValueLabel);
        panel.add(registersPanel);
        
        JLabel originalProgramLabel = new JLabel("Original Program");
        panel.add(originalProgramLabel);
        panel.add(originalProgramTextArea);
        JPanel originalProgramPanel = new JPanel();
        originalProgramPanel.setSize(15, 20);
        originalProgramPanel.add(originalProgramTextArea);
        panel.add(originalProgramPanel);
        
        JLabel consoleLabel = new JLabel("Console");
        panel.add(consoleLabel);
        panel.add(consoleTextArea);
        JPanel consolePanel = new JPanel();
        consolePanel.setSize(15, 20);
        consolePanel.add(consoleTextArea);
        panel.add(consolePanel);
        
        JLabel programLabel = new JLabel("Program");
        panel.add(programLabel);
        panel.add(programTextArea);
        JPanel programPanel = new JPanel();
        programPanel.setSize(15, 20);
        programPanel.add(programTextArea);
        panel.add(programPanel);        
        
        startButton.addActionListener(new OpenFile());
        panel.add(startButton);

        Container container = getContentPane();
        container.add(panel, BorderLayout.NORTH);
    }
    
    private void addMemoryPanelToMainPanel(JPanel mainPanel, JPanel memoryPanel, int startingMemoryAddress, int endingMemoryAddress) {
        memoryPanel = addMemoryLabelsToPanel(memoryPanel, startingMemoryAddress, endingMemoryAddress);
        mainPanel.add(memoryPanel);
    }
    
    private JPanel addMemoryLabelsToPanel(JPanel panel, int startingMemoryAddress, int endingMemoryAddress) {
        for (int i = startingMemoryAddress; i < endingMemoryAddress; i++) {
            JLabel label = initMemoryLabel(String.valueOf(i));
            panel.add(label);
        }
        return panel;
    }    
    
    private JLabel initMemoryLabel(String memoryAddress) {
        return initLabel("Memory Address " + memoryAddress);
    }
    
    private JLabel initRegisterLabel(String toolTipText) {
        JLabel label = new JLabel("0");
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setToolTipText(toolTipText);
        return label;    
    }
    
    private JLabel initLabel(String toolTipText) {
        JLabel label = new JLabel("      ");
        label.setBorder(BorderFactory.createLineBorder(Color.black));
        label.setToolTipText(toolTipText);
        return label;
    }    
    
    public static void main(String[] args) {
        run(new CSU_VM());
    }
    
    private static void run(JFrame frame) {
        frame.setTitle("CSU_VM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setSize(700, 850);    
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    private class OpenFile implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();        
        int fileChooserSelection = fileChooser.showOpenDialog(CSU_VM.this);        
        
        if (fileChooserSelection == JFileChooser.CANCEL_OPTION) {
          consoleTextArea.setText("Cancelled file load");            
        }
        
        if (fileChooserSelection == JFileChooser.APPROVE_OPTION) {          
          BufferedReader br = null;

          try {
              br = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));            
              //fileContent.read(br, null);
              
              //# sets the memory address 0 to store the value 10, and the memory address 1 to store the value 11. M stands for memory.
              //M:0=10, 1=11

              //# All programs start with an initial setup of values in memory such as the example shown above
              //0 LOAD 1,4
              
              //M:0=10, 1=11
              //0 LOAD 1,4
              //1 LOAD 0,3
              //2 ADD 1,3
              //3 ADD 0,2
              //4 LSS 1,3,3
              //5 STOR 50,2
              //6 STOP
              //loads value in memory address 1 into register 4
              
              //M:2=10, 1=11
              //0 LOAD 2,3
              
              String line;
              String[] memoryAddresses = null;
              String commandName = "";
              int location1 = 0;
              int locationValue1 = 0;
              int location2 = 0;
              
              while ((line = br.readLine()) != null) {
                  if (!line.contains("#")) {
                  
                    if (line.contains("M:")) {
                        if (line.contains(",")) {
                            int colonIndex = line.indexOf(":");
                            String memoryAddressString = line.substring(colonIndex + 1);
                            memoryAddresses = memoryAddressString.split(",");
                        }
                    }
                    else {
                        if (line.contains(",")) {
                            String command = line.substring(line.indexOf(" ") + 1);
                            String memoryAddressString = command.substring(command.indexOf(" ") + 1, command.indexOf(","));
                            String registerString = command.substring(command.indexOf(",") + 1);
                            
                            for (int i = 0; i < memoryAddresses.length; i++) {
                                String memoryAddressAndValue = memoryAddresses[i];
                                String address = memoryAddressAndValue.substring(0, memoryAddressAndValue.indexOf("=")).replace(" ", "");
                                String valueString = memoryAddressAndValue.substring(memoryAddressAndValue.indexOf("=") + 1);
                                
                                if (memoryAddressString.equals(address)) {
                                    location1 = Integer.parseInt(memoryAddressString);
                                    locationValue1 = Integer.parseInt(valueString);
                                }
                            }  
                            
                            location2 = Integer.parseInt(registerString);
                            commandName = command.substring(0, command.indexOf(memoryAddressString) - 1);
                        }
                        
                        //consoleTextArea.setText("**" + commandName + "**, **" + location1 + "**, **" + locationValue1 + "**, **" + location2 + "**");
                        
                        JLabel registerFromLabel = new JLabel();
                        switch (location1) {
                            case 1:
                                registerFromLabel = register0ValueLabel;
                                break;
                            case 2:
                                registerFromLabel = register1ValueLabel;
                                break;
                            case 3:
                                registerFromLabel = register2ValueLabel;
                                break;
                            case 4:
                                registerFromLabel = register3ValueLabel;
                                break;
                        }
                        
                        JLabel registerLabel = new JLabel();                        
                        switch (location2) {
                            case 1:
                                registerLabel = register0ValueLabel;
                                break;
                            case 2:
                                registerLabel = register1ValueLabel;
                                break;
                            case 3:
                                registerLabel = register2ValueLabel;
                                break;
                            case 4:
                                registerLabel = register3ValueLabel;
                                break;                                
                        }
                        
                        switch (commandName) {
                            case "LOAD":
                                LOAD load = new LOAD();
                                load.manageMemory(new JLabel(), location1, locationValue1, registerLabel, location2);
                                break;
                            case "STOR":
                                STOR stor = new STOR();
                                stor.manageMemory(new JLabel(), location1, locationValue1, new JLabel(), location2);
                            case "ADD":
                                ADD add = new ADD();
                                add.manageRegister(registerFromLabel, registerLabel);
                            case "SUB":
                                SUB sub = new SUB();
                                sub.manageRegister(registerFromLabel, registerLabel);
                            case "MUL":
                                MUL mul = new MUL();
                                mul.manageRegister(registerFromLabel, registerLabel);
                            case "DIV":
                                DIV div = new DIV();
                                div.manageRegister(registerFromLabel, registerLabel);
                            default:
                                break;
                        }                      
                    }
                  } //!#
              } //file chosen
              
              //int memoryAddress = 5;
              //int register = 0;
              
              //LOAD load = new LOAD();
              //load.manageMemory(memoryAddress, register);
              
              //fileContent.read(register, null);
              
          }
          catch (FileNotFoundException ex) {
              consoleTextArea.setText(ex.getMessage());
          }
          catch (IOException ex) {
              consoleTextArea.setText(ex.getMessage());
          }
          finally {
              if (br != null) {
                  try {
                      br.close();
                  }
                  catch (IOException ex) {
                  }
              }
          }
          
          //String outputDirectory = fileChooser.getCurrentDirectory().toString();
          //String outputFileName = "Output.txt";
          //String outputFilePath = outputDirectory + "\\" + outputFileName;

          //File outputFile = new File(outputFilePath);
          //BufferedWriter outFile = null;

          //try {
              //outFile = new BufferedWriter(new FileWriter(outputFile));
              //consoleTextArea.write(outFile);
              //consoleTextArea.setText("File output successfully");
          //}
          //catch (IOException ex) {
              //consoleTextArea.setText(ex.getMessage());
          //}
          //finally {
              //if (outFile != null) {
                  //try {
                      //outFile.close();
                  //}
                  //catch (IOException ex) {
                      //consoleTextArea.setText(ex.getMessage());
                  //}
              //}
          //}
          
        }
      }
    }

    
}
