package travelinformation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] buttons;
    private String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
    };

    private double num1 = 0;
    private String operator = "";
    private boolean startNewInput = true;

    public Calculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        textField = new JTextField();
        textField.setEditable(false);

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        add(textField, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = ((JButton) e.getSource()).getText();

        if (buttonText.matches("[0-9\\.]")) {
            if (startNewInput) {
                textField.setText("");
                startNewInput = false;
            }
            textField.setText(textField.getText() + buttonText);
        } else if (buttonText.matches("[\\+\\-\\*/=]")) {
            if (!operator.isEmpty() && !startNewInput) {
                double num2 = Double.parseDouble(textField.getText());
                double result = performOperation(num1, num2, operator);
                textField.setText(String.valueOf(result));
                num1 = result;
            } else {
                num1 = Double.parseDouble(textField.getText());
            }
            operator = buttonText;
            startNewInput = true;
        }
    }

    private double performOperation(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0)
                    return num1 / num2;
                else {
                    JOptionPane.showMessageDialog(this, "Error: Division by zero");
                    return Double.NaN;
                }
            default:
                return Double.NaN;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
