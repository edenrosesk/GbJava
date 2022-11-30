package lesson8.listeners;

import lesson8.Storage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EqualButtonListener implements ActionListener {

    private final JTextField inputField;
    private final JPanel operatorsPanel;

    public EqualButtonListener(JTextField inputField, JPanel operatorsPanel) {
        this.inputField = inputField;
        this.operatorsPanel = operatorsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Storage.Right = Double.parseDouble(inputField.getText());
        double result = 0;

        if (Storage.Operator == "+") result = Storage.Left + Storage.Right;
        if (Storage.Operator == "-") result = Storage.Left - Storage.Right;
        if (Storage.Operator == "*") result = Storage.Left * Storage.Right;
        if (Storage.Operator == "/") result = Storage.Left / Storage.Right;

        Storage.Left = result;
        if (result % 1 == 0) {
            inputField.setText(String.valueOf((int)result));
        }
        else {
            inputField.setText(String.valueOf(result));
        }

        Storage.WasEqual = true;

        var buttons = operatorsPanel.getComponents();

        for (Component component : buttons) {
            component.setEnabled(true);
            component.setBackground(new Color(248, 243, 243));
        }

    }
}

