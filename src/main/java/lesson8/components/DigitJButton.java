package lesson8.components;

import javax.swing.*;
import java.awt.*;

public class DigitJButton  extends JButton {
    public DigitJButton(String text) {
        super(text);
        setFont(new Font("TimesRoman", Font.PLAIN, 25));
        setBackground(new Color(225, 197, 206));
    }
}
