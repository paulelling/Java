package csu_vm;

import javax.swing.JLabel;

public class LOAD implements MemoryOperation {
    public void manageMemory(JLabel memoryLabel, int memoryAddress, int value, JLabel registerLabel, int register) {
        registerLabel.setText(String.valueOf(value));
    }
}
