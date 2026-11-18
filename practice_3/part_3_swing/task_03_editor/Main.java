package ru.mirea.oop.p3.part3.editor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Текстовый редактор"); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTextArea text = new JTextArea(10, 40);
            JMenuBar bar = new JMenuBar(); JMenu file = new JMenu("Файл"), edit = new JMenu("Правка"), help = new JMenu("Справка");
            JMenuItem save = new JMenuItem("Сохранить"), exit = new JMenuItem("Выйти");
            save.addActionListener(e -> {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    try { Files.write(chooser.getSelectedFile().toPath(), text.getText().getBytes(StandardCharsets.UTF_8)); }
                    catch (IOException ex) { JOptionPane.showMessageDialog(frame, ex.getMessage(), "Ошибка сохранения", JOptionPane.ERROR_MESSAGE); }
                }
            });
            exit.addActionListener(e -> frame.dispose()); file.add(save); file.add(exit);
            JMenuItem copy = new JMenuItem("Копировать"), cut = new JMenuItem("Вырезать"), paste = new JMenuItem("Вставить");
            copy.addActionListener(e -> text.copy()); cut.addActionListener(e -> text.cut()); paste.addActionListener(e -> text.paste());
            edit.add(copy); edit.add(cut); edit.add(paste);
            JMenuItem about = new JMenuItem("О программе"); about.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Простой текстовый редактор")); help.add(about);
            bar.add(file); bar.add(edit); bar.add(help); frame.setJMenuBar(bar);
            JPanel buttons = new JPanel(new GridLayout(1, 2, 8, 0)); JButton button1 = new JButton("Копировать"), button2 = new JButton("Вставить");
            button1.addActionListener(e -> text.copy()); button2.addActionListener(e -> text.paste()); buttons.add(button1); buttons.add(button2);
            frame.add(buttons, BorderLayout.NORTH); frame.add(new JScrollPane(text), BorderLayout.CENTER);
            frame.pack(); frame.setLocationRelativeTo(null); frame.setVisible(true);
        });
    }
}
