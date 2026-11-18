package ru.mirea.oop.p3.part3.keypad;

import javax.swing.*;
import java.awt.*;

public class Main {
    private final JTextField display = new JTextField("0");
    private double left;
    private String operation;
    private boolean newNumber = true;

    private void press(String key) {
        try {
            if (key.equals("C")) { display.setText("0"); operation = null; newNumber = true; return; }
            if (key.matches("[0-9]") || key.equals(".")) {
                String current = newNumber ? "0" : display.getText();
                if (key.equals(".") && current.contains(".")) return;
                display.setText(key.equals(".") ? current + "." : current.equals("0") ? key : current + key);
                newNumber = false; return;
            }
            double current = Double.parseDouble(display.getText());
            if (operation != null && !newNumber) {
                switch (operation) {
                    case "+": left += current; break;
                    case "-": left -= current; break;
                    case "*": left *= current; break;
                    case "/": if (current == 0) throw new ArithmeticException("Деление на ноль"); left /= current; break;
                }
                if (!Double.isFinite(left)) throw new ArithmeticException("Результат слишком велик");
                display.setText(Double.toString(left));
            } else if (operation == null) left = current;
            operation = key.equals("=") ? null : key;
            newNumber = true;
        } catch (ArithmeticException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(display, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
            display.setText("0"); operation = null; newNumber = true;
        }
    }
    private void show() {
        JFrame frame = new JFrame("Simple Calculator"); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setEditable(false); display.setHorizontalAlignment(JTextField.RIGHT); frame.add(display, BorderLayout.NORTH);
        JPanel keys = new JPanel(new GridLayout(4, 4, 5, 5));
        for (String key : new String[]{"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"}) {
            JButton button = new JButton(key); button.addActionListener(e -> press(key)); keys.add(button);
        }
        frame.add(keys, BorderLayout.CENTER); JButton clear = new JButton("C"); clear.addActionListener(e -> press("C")); frame.add(clear, BorderLayout.SOUTH);
        frame.setSize(340, 300); frame.setLocationRelativeTo(null); frame.setVisible(true);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new Main().show()); }
}
