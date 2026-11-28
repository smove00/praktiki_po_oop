package ru.mirea.oop.p3.part1.animation;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Main {
    private static final int FRAME_COUNT = 24;
    private static final int WIDTH = 640, HEIGHT = 260;
    static BufferedImage[] createFrames() {
        BufferedImage[] frames = new BufferedImage[FRAME_COUNT];
        for (int i = 0; i < FRAME_COUNT; i++) {
            BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = img.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(new Color(246, 248, 252)); g.fillRect(0, 0, WIDTH, HEIGHT);
            g.setColor(new Color(180, 193, 214));
            g.fillRoundRect(25, HEIGHT - 50, WIDTH - 50, 7, 7, 7);
            double angle = 2 * Math.PI * i / FRAME_COUNT;
            int x = 35 + (int)(i * (WIDTH - 110.0) / FRAME_COUNT);
            int y = 110 - (int)(70 * Math.abs(Math.sin(angle)));
            g.setColor(new Color(30, 104, 186)); g.fillOval(x, y, 65, 65);
            g.setColor(Color.WHITE); g.drawOval(x + 10, y + 10, 45, 45);
            g.dispose();
            frames[i] = img;
        }
        return frames;
    }
    private static void openWindow() {
        BufferedImage[] frames = createFrames();
        JFrame frame = new JFrame("Анимация");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel view = new JLabel(new ImageIcon(frames[0]));
        frame.add(view);
        // Меняем картинки по таймеру.
        final int[] index = {0};
        Timer timer = new Timer(70, event -> {
            index[0] = (index[0] + 1) % FRAME_COUNT;
            view.setIcon(new ImageIcon(frames[index[0]]));
        });
        timer.start();
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        if (args.length > 0 && "--self-test".equals(args[0])) {
            BufferedImage[] frames = createFrames();
            if (frames.length != FRAME_COUNT || frames[0] == frames[1]) throw new AssertionError();
            System.out.println("Кадры созданы");
            return;
        }
        SwingUtilities.invokeLater(Main::openWindow);
    }
}
