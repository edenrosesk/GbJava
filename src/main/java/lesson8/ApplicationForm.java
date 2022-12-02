package lesson8;

import lesson8.components.DigitJButton;
import lesson8.components.OperatorJButton;
import lesson8.listeners.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {

    private JTextField inputField;

    public ApplicationForm(String title) {
        super(title);
        setBounds(1200, 840, 250, 370); //Поменять!
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);

        setJMenuBar(createMenu());

        add(createCenterPanel(), BorderLayout.CENTER);

        setVisible(true);
    }



    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        var help = new JMenuItem("Help");
        help.addActionListener(new HelpButtonListener());
        menuBar.add(help);


        var about = new JMenuItem("About");
        about.addActionListener(new AboutButtonListener());
        menuBar.add(about);


        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        menuBar.add(exit);

        return menuBar;
    }

    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);

        inputField.setFont(new Font("Arial", Font.PLAIN, 25));
        inputField.setMargin(new Insets(8,0,8,0));
        inputField.setBackground(new Color(225, 217, 217, 255));

        return top;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        var operatorsPanel = createOperatorsPanel();

        centerPanel.add(createDigitsPanel(operatorsPanel),BorderLayout.CENTER);
        centerPanel.add(operatorsPanel,BorderLayout.WEST);
        
        return centerPanel;
    }

    private JPanel createDigitsPanel(JPanel operatorsPanel) {
        JPanel digitsPanel = new JPanel();
        ActionListener buttonListener = new ButtonListener(inputField);

        digitsPanel.setLayout(new GridLayout(4,3));

        for (int i = 0; i < 10; i++) {
            String buttonTitle = (i == 9) ? "0" : String.valueOf(i +1);
            JButton btn = new DigitJButton(buttonTitle);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);
        }

        JButton calc = new OperatorJButton("=");
        calc.addActionListener(new EqualButtonListener(inputField, operatorsPanel));
        digitsPanel.add(calc);

        JButton clear = new OperatorJButton("C");
        clear.addActionListener(new ClearFieldButtonListener(inputField, operatorsPanel));
        digitsPanel.add(clear);

        return digitsPanel;
    }

    private JPanel createOperatorsPanel() {
        JPanel operatorsPanel = new JPanel();
        ActionListener operatorButtonListener = new OperatorButtonListener(inputField);

        operatorsPanel.setLayout(new GridLayout(4, 1));

        JButton minus = new OperatorJButton("-");
        minus.addActionListener(operatorButtonListener);
        operatorsPanel.add(minus);

        JButton plus = new OperatorJButton("+");
        plus.addActionListener(operatorButtonListener);
        operatorsPanel.add(plus);

        JButton multiply = new OperatorJButton("x");
        multiply.addActionListener(operatorButtonListener);
        operatorsPanel.add(multiply);

        JButton divide = new OperatorJButton("/");
        divide.addActionListener(operatorButtonListener);
        operatorsPanel.add(divide);

        return operatorsPanel;
    }
}
