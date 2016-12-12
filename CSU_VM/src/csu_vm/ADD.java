package csu_vm;

import javax.swing.JLabel;

public class ADD implements RegisterOperation {
    public void manageRegister(JLabel registerLabel1, JLabel registerLabel2) {
        String registerLabel1Text = registerLabel1.getText();
        String registerLabel2Text = registerLabel2.getText();
        int register1Value = Integer.parseInt(registerLabel1Text);
        int register2Value = Integer.parseInt(registerLabel2Text);
        int result = register1Value + register2Value;
        registerLabel1.setText(String.valueOf(result));
    }
}
