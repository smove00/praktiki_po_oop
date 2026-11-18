package ru.mirea.oop.p3.part1.animation;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    private static BufferedImage frame(int index) {
        BufferedImage image = new BufferedImage(480, 240, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(new Color(170, 220, 255)); g.fillRect(0, 0, 480, 240);
        g.setColor(new Color(90, 180, 90)); g.fillRect(0, 190, 480, 50);
        g.setColor(Color.YELLOW); g.fillOval(380, 20, 50, 50);
        g.setColor(Color.RED); g.fillOval(20 + index * 20, 145 - (index % 4 < 2 ? 15 : 0), 45, 45);
        g.dispose(); return image;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageIcon[] frames = new ImageIcon[20];
            for (int i = 0; i < frames.length; i++) frames[i] = new ImageIcon(frame(i));
            JLabel picture = new JLabel(frames[0]);
            JFrame window = new JFrame("Анимация кадров"); window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.add(picture); window.pack(); window.setLocationRelativeTo(null); window.setVisible(true);
            picture.putClientProperty("frame", 0);
            new Timer(100, e -> { int next = (Integer) picture.getClientProperty("frame") + 1; picture.putClientProperty("frame", next % frames.length); picture.setIcon(frames[next % frames.length]); }).start();
        });
    }
}
