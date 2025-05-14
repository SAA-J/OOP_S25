package TempConverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterFrame {
    private JPanel mainPanel;
    private JTextField inputField;
    private JTextField outputField;
    private JButton convertButton;
    private JLabel inputLabel;
    private JLabel outputLabel;
    private boolean isCelsiusToFahrenheit;

    public ConverterFrame(boolean isCelsiusToFahrenheit) {
        this.isCelsiusToFahrenheit = isCelsiusToFahrenheit;
        inputLabel.setText(isCelsiusToFahrenheit ? "Celsius:" : "Fahrenheit:");
        outputLabel.setText(isCelsiusToFahrenheit ? "Fahrenheit:" : "Celsius:");

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double input = Double.parseDouble(inputField.getText());
                    double output;
                    if (isCelsiusToFahrenheit) {
                        output = (input * 9 / 5) + 32;
                    } else {
                        output = (input - 32) * 5 / 9;
                    }
                    outputField.setText(String.format("%.2f", output));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Please enter a valid number.");
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}