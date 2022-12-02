package lesson8.listeners;

import lesson8.Storage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearFieldButtonListener implements ActionListener {

    private final JTextField inputField;
    private final JPanel operatorsPanel;

    public ClearFieldButtonListener(JTextField inputField, JPanel operatorsPanel) {
        this.inputField = inputField;
        this.operatorsPanel = operatorsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        var buttons = operatorsPanel.getComponents();

        for (Component component : buttons) {
            component.setEnabled(true);
            component.setBackground(new Color(248, 243, 243));
        }

        Storage.Operator = null;
        Storage.PressOperator = false;
        Storage.WasEqual = false;
        inputField.setText("");
    }
}
