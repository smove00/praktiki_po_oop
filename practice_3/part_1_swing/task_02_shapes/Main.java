package ru.mirea.oop.p3.part1.shapes;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

abstract class Shape {
    protected final Color color;
    protected final int x, y;
    Shape(Color color, int x, int y) { this.color = color; this.x = x; this.y = y; }
    abstract void draw(Graphics2D g);
}
class Circle extends Shape {
    private final int diameter;
    Circle(Color color, int x, int y, int diameter) { super(color, x, y); this.diameter = diameter; }
    void draw(Graphics2D g) { g.setColor(color); g.fillOval(x, y, diameter, diameter); }
}
class Rectangle extends Shape {
    private final int width, height;
    Rectangle(Color color, int x, int y, int width, int height) { super(color, x, y); this.width = width; this.height = height; }
    void draw(Graphics2D g) { g.setColor(color); g.fillRect(x, y, width, height); }
}
class Triangle extends Shape {
    private final int size;
    Triangle(Color color, int x, int y, int size) { super(color, x, y); this.size = size; }
    void draw(Graphics2D g) { g.setColor(color); g.fillPolygon(new int[]{x, x + size / 2, x + size}, new int[]{y + size, y, y + size}, 3); }
}
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Random random = new Random();
            Shape[] shapes = new Shape[20];
            for (int i = 0; i < shapes.length; i++) {
                Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                int x = random.nextInt(600), y = random.nextInt(400), size = 30 + random.nextInt(70);
                switch (random.nextInt(3)) {
                    case 0: shapes[i] = new Circle(color, x, y, size); break;
                    case 1: shapes[i] = new Rectangle(color, x, y, size, 30 + random.nextInt(70)); break;
                    default: shapes[i] = new Triangle(color, x, y, size);
                }
            }
            JPanel canvas = new JPanel() {
                protected void paintComponent(Graphics g) { super.paintComponent(g); for (Shape shape : shapes) shape.draw((Graphics2D) g); }
            };
            canvas.setPreferredSize(new Dimension(700, 500)); canvas.setBackground(Color.WHITE);
            JFrame frame = new JFrame("20 случайных фигур"); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(canvas); frame.pack(); frame.setLocationRelativeTo(null); frame.setVisible(true);
        });
    }
}
