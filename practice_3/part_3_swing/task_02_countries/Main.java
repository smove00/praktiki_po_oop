package ru.mirea.oop.p3.part3.countries;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.*;

public class Main {
    private static final Map<String, String> INFO = new LinkedHashMap<>();
    static {
        INFO.put("Австралия", "Австралия — государство в Южном полушарии. Столица: Канберра.");
        INFO.put("Китай", "Китай — государство в Восточной Азии. Столица: Пекин.");
        INFO.put("Англия", "Англия — часть Соединённого Королевства. Административный центр: Лондон.");
        INFO.put("Россия", "Россия — государство в Европе и Азии. Столица: Москва.");
    }
    private static void createWindow() {
        JFrame frame = new JFrame("Страны");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout(12, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JComboBox<String> country = new JComboBox<>(INFO.keySet().toArray(new String[0]));
        JTextArea description = new JTextArea(5, 28);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setEditable(false);
        description.setBackground(panel.getBackground());
        country.addActionListener(e -> description.setText(INFO.get(country.getSelectedItem())));
        description.setText(INFO.get(country.getSelectedItem()));
        panel.add(new JLabel("Выберите страну:"), BorderLayout.NORTH);
        panel.add(country, BorderLayout.CENTER);
        panel.add(new JScrollPane(description), BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        if (args.length > 0 && "--self-test".equals(args[0])) {
            if (INFO.size() != 4 || !INFO.get("Китай").contains("Пекин")) throw new AssertionError();
            System.out.println("Список стран работает");
            return;
        }
        SwingUtilities.invokeLater(Main::createWindow);
    }
}
