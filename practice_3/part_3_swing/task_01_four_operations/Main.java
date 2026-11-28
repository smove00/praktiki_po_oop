package ru.mirea.oop.p3.part3.calculator;

import java.awt.*;
import java.util.Locale;
import javax.swing.*;

public class Main {
    static double calculate(double a, double b, char operation) {
        switch (operation) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Деление на ноль");
                return a / b;
            default: throw new IllegalArgumentException("Неизвестная операция");
        }
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout(8, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        JPanel fields = new JPanel(new GridLayout(2, 2, 8, 8));
        JTextField first = new JTextField();
        JTextField second = new JTextField();
        fields.add(new JLabel("Первое число:")); fields.add(first);
        fields.add(new JLabel("Второе число:")); fields.add(second);
        JPanel buttons = new JPanel(new GridLayout(1, 4, 8, 8));
        JLabel result = new JLabel("Результат: —", SwingConstants.CENTER);
        result.setFont(result.getFont().deriveFont(Font.BOLD, 16f));
        for (char op : new char[] {'+', '-', '*', '/'}) {
            JButton button = new JButton(String.valueOf(op));
            button.addActionListener(event -> {
                try {
                    double a = Double.parseDouble(first.getText().trim().replace(',', '.'));
                    double b = Double.parseDouble(second.getText().trim().replace(',', '.'));
                    if (!Double.isFinite(a) || !Double.isFinite(b)) {
                        throw new NumberFormatException("Только конечные числа");
                    }
                    double answer = calculate(a, b, op);
                    result.setText("Результат: " + String.format(Locale.US, "%.8g", answer));
                } catch (NumberFormatException exception) {
                    result.setText("Ошибка: введите два числа");
                } catch (ArithmeticException exception) {
                    result.setText("Ошибка: деление на ноль");
                }
            });
            buttons.add(button);
        }
        panel.add(fields, BorderLayout.NORTH);
        panel.add(buttons, BorderLayout.CENTER);
        panel.add(result, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setSize(470, 240);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        if (args.length > 0 && "--self-test".equals(args[0])) {
            if (calculate(7, 3, '+') != 10 || calculate(7, 3, '-') != 4 ||
                calculate(7, 3, '*') != 21 || calculate(7, 2, '/') != 3.5) throw new AssertionError();
            boolean threw = false;
            try { calculate(10, 0, '/'); } catch (ArithmeticException ex) { threw = true; }
            if (!threw) throw new AssertionError("Division by zero");
            System.out.println("Вычисления работают");
            return;
        }
        SwingUtilities.invokeLater(Main::createWindow);
    }
}
