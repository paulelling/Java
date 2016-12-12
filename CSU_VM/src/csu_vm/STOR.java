package csu_vm;

import javax.swing.JLabel;

public class STOR implements MemoryOperation {
    public void manageMemory(JLabel memoryLabel, int memoryAddress, int value, JLabel registerLabel, int register) {
        memoryAddress = value;
    }
}
