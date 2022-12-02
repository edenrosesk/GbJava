package lesson8.listeners;

import lesson8.Storage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JTextField inputField;


    public ButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Storage.WasEqual) {
            inputField.setText("");
            Storage.WasEqual = false;
        }
        if (Storage.PressOperator) {
            inputField.setText("");
            Storage.PressOperator = false;
        }
        JButton btn = (JButton) e.getSource();
        inputField.setText(inputField.getText() + btn.getText());
    }
}
