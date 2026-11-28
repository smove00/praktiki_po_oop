package ru.mirea.oop.p3.part1.shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class Main {
    private static final int WIDTH = 780, HEIGHT = 460;
    public static abstract class Shape {
        protected final Color color;
        protected final int x, y, width, height;

        protected Shape(Color color, int x, int y, int width, int height) {
            this.color = color;
            this.x = x; this.y = y; this.width = width; this.height = height;
        }
        public abstract void draw(Graphics2D g);
    }
    static class RectangleShape extends Shape {
        RectangleShape(Color c, int x, int y, int w, int h) { super(c, x, y, w, h); }
        @Override public void draw(Graphics2D g) {
            g.setColor(color); g.fillRect(x, y, width, height);
        }
    }
    static class EllipseShape extends Shape {
        EllipseShape(Color c, int x, int y, int w, int h) { super(c, x, y, w, h); }
        @Override public void draw(Graphics2D g) {
            g.setColor(color); g.fillOval(x, y, width, height);
        }
    }
    static class RoundRectangleShape extends Shape {
        RoundRectangleShape(Color c, int x, int y, int w, int h) { super(c, x, y, w, h); }
        @Override public void draw(Graphics2D g) {
            g.setColor(color); g.fillRoundRect(x, y, width, height, 24, 24);
        }
    }
    // Создаем 20 фигур со случайными размерами, цветами и координатами.
    static List<Shape> createShapes(long seed) {
        Random random = new Random(seed);
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int w = 35 + random.nextInt(115);
            int h = 30 + random.nextInt(100);
            int x = random.nextInt(WIDTH - w);
            int y = random.nextInt(HEIGHT - h);
            Color c = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            switch (random.nextInt(3)) {
                case 0: shapes.add(new RectangleShape(c, x, y, w, h)); break;
                case 1: shapes.add(new EllipseShape(c, x, y, w, h)); break;
                default: shapes.add(new RoundRectangleShape(c, x, y, w, h));
            }
        }
        return shapes;
    }
    static class ShapesPanel extends JPanel {
        private final List<Shape> shapes = createShapes(System.nanoTime());
        ShapesPanel() { setPreferredSize(new Dimension(WIDTH, HEIGHT)); setBackground(Color.WHITE); }
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            for (Shape shape : shapes) shape.draw(g2);
            g2.dispose();
        }
    }
    public static void main(String[] args) {
        if (args.length > 0 && "--self-test".equals(args[0])) {
            List<Shape> shapes = createShapes(123);
            if (shapes.size() != 20) throw new AssertionError("Должно быть 20 фигур");
            for (Shape s : shapes) if (s.x < 0 || s.y < 0 ||
                s.x + s.width > WIDTH || s.y + s.height > HEIGHT) throw new AssertionError();
            System.out.println("Фигуры созданы");
            return;
        }
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("20 случайных фигур");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ShapesPanel());
            frame.pack();
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
