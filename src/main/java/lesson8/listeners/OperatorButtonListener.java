package lesson8.listeners;


import lesson8.Storage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButtonListener implements ActionListener {

    private final JTextField inputField;

    public OperatorButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        var buttons = btn.getParent().getComponents();

        for (Component button : buttons) {
            button.setEnabled(false);
            button.setBackground(new Color(248, 243, 243));
        }

        Storage.Operator = btn.getText();
        Storage.PressOperator = true;
        Storage.Left = Double.parseDouble(inputField.getText());

        btn.setBackground(new Color(56, 54, 54, 255));
    }
}
