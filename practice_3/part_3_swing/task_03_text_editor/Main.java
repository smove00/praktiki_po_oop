package ru.mirea.oop.p3.part3.editor;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import javax.swing.*;

public class Main {
    private static JMenuItem item(JMenu menu, String title, Runnable action) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.addActionListener(e -> action.run());
        menu.add(menuItem);
        return menuItem;
    }
    private static void createWindow() {
        JFrame frame = new JFrame("Текстовый редактор — Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea text = new JTextArea(12, 45);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setText("Здесь можно писать текст.");
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("Файл");
        JMenu edit = new JMenu("Правка");
        JMenu help = new JMenu("Справка");

        item(file, "Сохранить", () -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(frame) != JFileChooser.APPROVE_OPTION) return;
            File target = chooser.getSelectedFile();
            if (target.exists()) {
                int confirm = JOptionPane.showConfirmDialog(frame,
                    "Перезаписать существующий файл?", "Сохранение", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) return;
            }
            try {
                Files.write(target.toPath(), text.getText().getBytes(StandardCharsets.UTF_8));
                JOptionPane.showMessageDialog(frame, "Сохранено: " + target.getAbsolutePath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Ошибка сохранения: " + ex.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
        item(file, "Выйти", frame::dispose);
        item(edit, "Копировать", text::copy);
        item(edit, "Вырезать", text::cut);
        item(edit, "Вставить", text::paste);
        item(help, "О программе", () -> JOptionPane.showMessageDialog(frame,
            "Практика 3. JTextArea, JMenuBar, JMenuItem и обработка событий Swing.",
            "Справка", JOptionPane.INFORMATION_MESSAGE));
        bar.add(file); bar.add(edit); bar.add(help);
        frame.setJMenuBar(bar);

        JPanel buttons = new JPanel(new GridLayout(1, 2, 15, 0));
        JButton first = new JButton("Кнопка 1 — очистить");
        JButton second = new JButton("Кнопка 2 — вставить пример");
        first.addActionListener(e -> text.setText(""));
        second.addActionListener(e -> text.insert("Пример текста. ", text.getCaretPosition()));
        buttons.add(first); buttons.add(second);
        JPanel content = new JPanel(new BorderLayout(8, 8));
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        content.add(buttons, BorderLayout.NORTH);
        content.add(new JScrollPane(text), BorderLayout.CENTER);
        frame.setContentPane(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        if (args.length > 0 && "--self-test".equals(args[0])) {
            if (!StandardCharsets.UTF_8.name().equals("UTF-8")) throw new AssertionError();
            System.out.println("Editor UTF-8 setup OK");
            return;
        }
        SwingUtilities.invokeLater(Main::createWindow);
    }
}
