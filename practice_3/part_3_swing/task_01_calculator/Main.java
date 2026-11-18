package ru.mirea.oop.p3.part3.calculator;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static void calculate(JTextField a, JTextField b, String operation) {
        try {
            double x = Double.parseDouble(a.getText().trim().replace(',', '.'));
            double y = Double.parseDouble(b.getText().trim().replace(',', '.'));
            if (!Double.isFinite(x) || !Double.isFinite(y)) throw new NumberFormatException();
            double result;
            switch (operation) {
                case "+": result = x + y; break;
                case "−": result = x - y; break;
                case "×": result = x * y; break;
                default: if (y == 0) throw new ArithmeticException("Деление на ноль"); result = x / y;
            }
            JOptionPane.showMessageDialog(a, "Результат: " + result);
        } catch (NumberFormatException ex) { JOptionPane.showMessageDialog(a, "Введите два корректных числа", "Ошибка", JOptionPane.ERROR_MESSAGE); }
        catch (ArithmeticException ex) { JOptionPane.showMessageDialog(a, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE); }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Калькулятор двух чисел"); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTextField a = new JTextField(12), b = new JTextField(12);
            JPanel inputs = new JPanel(new GridLayout(2, 2, 5, 5));
            inputs.add(new JLabel("Первое число:")); inputs.add(a); inputs.add(new JLabel("Второе число:")); inputs.add(b);
            JPanel buttons = new JPanel();
            for (String op : new String[]{"+", "−", "×", "÷"}) { JButton button = new JButton(op); button.addActionListener(e -> calculate(a, b, op)); buttons.add(button); }
            frame.add(inputs, BorderLayout.CENTER); frame.add(buttons, BorderLayout.SOUTH);
            frame.pack(); frame.setLocationRelativeTo(null); frame.setVisible(true);
        });
    }
}
