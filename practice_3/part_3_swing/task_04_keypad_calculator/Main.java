package ru.mirea.oop.p3.part3.keypad;

import java.awt.*;
import java.math.BigDecimal;
import java.math.MathContext;
import javax.swing.*;

public class Main {
    public static final class Calculator {
        private String display = "0";
        private BigDecimal saved;
        private String pending;
        private boolean replaceOnDigit;

        public String getDisplay() { return display; }

        public void press(String key) {
            if ("0123456789".contains(key) && key.length() == 1) {
                if (replaceOnDigit || "0".equals(display) || "Ошибка".equals(display)) {
                    display = key;
                    replaceOnDigit = false;
                } else {
                    display += key;
                }
            } else if (".".equals(key)) {
                if (replaceOnDigit || "Ошибка".equals(display)) {
                    display = "0";
                    replaceOnDigit = false;
                }
                if (!display.contains(".")) display += ".";
            } else if ("+-*/".contains(key) && key.length() == 1) {
                try {
                    if (pending != null && !replaceOnDigit) apply();
                    saved = new BigDecimal(display);
                    pending = key;
                    replaceOnDigit = true;
                } catch (ArithmeticException | NumberFormatException ex) {
                    error();
                }
            } else if ("=".equals(key)) {
                if (pending != null && !replaceOnDigit) {
                    try {
                        apply();
                        pending = null;
                        saved = null;
                        replaceOnDigit = true;
                    } catch (ArithmeticException | NumberFormatException ex) {
                        error();
                    }
                }
            }
        }
        private void error() {
            display = "Ошибка";
            pending = null;
            saved = null;
            replaceOnDigit = true;
        }
        private void apply() {
            BigDecimal rhs = new BigDecimal(display);
            BigDecimal value;
            switch (pending) {
                case "+": value = saved.add(rhs); break;
                case "-": value = saved.subtract(rhs); break;
                case "*": value = saved.multiply(rhs); break;
                case "/":
                    if (rhs.signum() == 0) throw new ArithmeticException("Деление на ноль");
                    value = saved.divide(rhs, MathContext.DECIMAL64); break;
                default: throw new IllegalStateException("Неизвестная операция");
            }
            display = value.stripTrailingZeros().toPlainString();
        }
    }
    private static void createWindow() {
        Calculator model = new Calculator();
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel content = new JPanel(new BorderLayout(12, 12));
        content.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        JTextField display = new JTextField(model.getDisplay());
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(display.getFont().deriveFont(Font.BOLD, 28f));
        content.add(display, BorderLayout.NORTH);
        JPanel keys = new JPanel(new GridLayout(4, 4, 9, 9));
        String[] labels = {"7", "8", "9", "/", "4", "5", "6", "*",
                           "1", "2", "3", "-", "0", ".", "=", "+"};
        for (String label : labels) {
            JButton button = new JButton(label);
            button.setFont(button.getFont().deriveFont(Font.BOLD, 18f));
            button.addActionListener(event -> {
                model.press(label);
                display.setText(model.getDisplay());
            });
            keys.add(button);
        }
        content.add(keys, BorderLayout.CENTER);
        frame.setContentPane(content);
        frame.setSize(370, 430);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        if (args.length > 0 && "--self-test".equals(args[0])) {
            Calculator calc = new Calculator();
            calc.press("7"); calc.press("+"); calc.press("3"); calc.press("=");
            if (!"10".equals(calc.getDisplay())) throw new AssertionError("Сложение");
            calc.press("/"); calc.press("4"); calc.press("=");
            if (!"2.5".equals(calc.getDisplay())) throw new AssertionError("Деление");
            calc.press("/"); calc.press("0"); calc.press("=");
            if (!"Ошибка".equals(calc.getDisplay())) throw new AssertionError("Деление на ноль");
            System.out.println("Калькулятор работает");
            return;
        }
        SwingUtilities.invokeLater(Main::createWindow);
    }
}
