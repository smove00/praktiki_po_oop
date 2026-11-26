package ru.mirea.oop.p3.part1.image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {
    private static void display(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            if (image == null) throw new IOException("Неподдерживаемый формат изображения");
            JFrame frame = new JFrame("Просмотр изображения: " + new File(path).getName());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            frame.add(new JScrollPane(imageLabel));
            frame.setSize(Math.min(image.getWidth() + 40, 1000),
                Math.min(image.getHeight() + 60, 780));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null,
                "Не удалось открыть изображение: " + exception.getMessage(),
                "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        if (args.length == 1 && "--self-test".equals(args[0])) {
            BufferedImage image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
            if (image.getWidth() != 10) throw new AssertionError();
            System.out.println("Image viewer preparation OK");
            return;
        }
        if (args.length == 0) {
            System.err.println("Укажите путь: java ...Main /путь/к/фото.png");
            return;
        }
        SwingUtilities.invokeLater(() -> display(args[0]));
    }
}
