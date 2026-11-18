package ru.mirea.oop.p3.part3.countries;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] countries = {"Australia", "China", "England", "Russia"};
            String[] facts = {"Австралия — столица Канберра.", "Китай — столица Пекин.", "Англия — часть Великобритании; столица Лондон.", "Россия — столица Москва."};
            JComboBox<String> choices = new JComboBox<>(countries);
            JLabel info = new JLabel(facts[0]);
            choices.addActionListener(e -> info.setText(facts[choices.getSelectedIndex()]));
            JFrame frame = new JFrame("Выбор страны"); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout()); frame.add(choices); frame.add(info);
            frame.setSize(440, 130); frame.setLocationRelativeTo(null); frame.setVisible(true);
        });
    }
}
