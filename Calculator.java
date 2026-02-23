package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField display;
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";
    private boolean isOperatorPressed = false;

    public Calculator() {
        setTitle("Taschenrechner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(240, 240, 240));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setText("0");
        mainPanel.add(display, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(5, 4, 5, 5));
        buttonsPanel.setBackground(new Color(240, 240, 240));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "CE", "←", "√"
        };

        for (String buttonText : buttons) {
            JButton button = createButton(buttonText);
            buttonsPanel.add(button);
        }

        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Farbgebung
        if (text.matches("[0-9.]")) {
            button.setBackground(new Color(255, 255, 255));
            button.setForeground(Color.BLACK);
        } else if (text.equals("=")) {
            button.setBackground(new Color(76, 175, 80));
            button.setForeground(Color.WHITE);
        } else if (text.equals("C") || text.equals("CE") || text.equals("←")) {
            button.setBackground(new Color(244, 67, 54));
            button.setForeground(Color.WHITE);
        } else {
            button.setBackground(new Color(255, 152, 0));
            button.setForeground(Color.WHITE);
        }

        button.setOpaque(true);
        button.setBorderPainted(false);

        button.addActionListener(e -> handleButtonClick(text));
        return button;
    }

    private void handleButtonClick(String text) {
        String currentDisplay = display.getText();

        if (text.matches("[0-9]")) {
            if (isOperatorPressed) {
                display.setText(text);
                isOperatorPressed = false;
            } else {
                if (currentDisplay.equals("0")) {
                    display.setText(text);
                } else {
                    display.setText(currentDisplay + text);
                }
            }
        } else if (text.equals(".")) {
            if (!currentDisplay.contains(".")) {
                display.setText(currentDisplay + text);
            }
        } else if (text.matches("[+\-*/]")) {
            firstNumber = Double.parseDouble(currentDisplay);
            operator = text;
            isOperatorPressed = true;
        } else if (text.equals("=")) {
            secondNumber = Double.parseDouble(currentDisplay);
            double result = calculate(firstNumber, secondNumber, operator);
            display.setText(String.valueOf(result));
            isOperatorPressed = true;
        } else if (text.equals("C")) {
            display.setText("0");
            firstNumber = 0;
            secondNumber = 0;
            operator = "";
            isOperatorPressed = false;
        } else if (text.equals("CE")) {
            display.setText("0");
            isOperatorPressed = false;
        } else if (text.equals("←")) {
            if (currentDisplay.length() > 1) {
                display.setText(currentDisplay.substring(0, currentDisplay.length() - 1));
            } else {
                display.setText("0");
            }
        } else if (text.equals("√")) {
            double number = Double.parseDouble(currentDisplay);
            if (number >= 0) {
                display.setText(String.valueOf(Math.sqrt(number)));
            } else {
                display.setText("Fehler");
            }
            isOperatorPressed = true;
        }
    }

    private double calculate(double num1, double num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    display.setText("Fehler");
                    return 0;
                }
                return num1 / num2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator());
    }
}