package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Utility.*;

public class FileLocationView extends JFrame {
    private JTextField filepath = new JTextField();
    private JButton open = new JButton("Select File Location");    
    
    public FileLocationView() {        
      JPanel p = new JPanel();
      open.addActionListener(new OpenL());
      p.add(open);
      Container cp = getContentPane();
      cp.add(p, BorderLayout.SOUTH);
      filepath.setEditable(false);
      p = new JPanel();
      p.setLayout(new GridLayout(2, 1));
      p.add(filepath);
      cp.add(p, BorderLayout.NORTH);
    }  
    
    class OpenL implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        JFileChooser c = new JFileChooser();
        int rVal = c.showOpenDialog(FileLocationView.this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
          filepath.setText(c.getCurrentDirectory().toString());
          FileManager.overwriteFile(Constants.FilePathFile, c.getCurrentDirectory().toString());          
        }
      }
    }

    public static void run(JFrame frame, int width, int height) {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
