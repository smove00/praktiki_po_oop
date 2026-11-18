package ru.mirea.oop.p3.part1.image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) { System.err.println("Использование: java ...Main <путь к изображению>"); return; }
        try {
            BufferedImage image = ImageIO.read(new File(args[0]));
            if (image == null) throw new IOException("Формат изображения не поддерживается");
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame(args[0]); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(new JLabel(new ImageIcon(image))));
                frame.setSize(Math.min(image.getWidth() + 30, 1000), Math.min(image.getHeight() + 50, 800));
                frame.setLocationRelativeTo(null); frame.setVisible(true);
            });
        } catch (IOException e) { System.err.println("Не удалось открыть изображение: " + e.getMessage()); }
    }
}
