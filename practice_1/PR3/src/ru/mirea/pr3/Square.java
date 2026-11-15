package ru.mirea.pr3;

public class Square extends Rectangle {
    public Square() {
        this(1.0);
    }

    public Square(double side) {
        this(side, "blue", false);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        width = side;
        length = side;
    }

    @Override
    public void setWidth(double side) {
        setSide(side);
    }

    @Override
    public void setLength(double side) {
        setSide(side);
    }

    @Override
    public String toString() {
        return "Square{side=" + width + ", color='" + color + "', filled=" + filled + "}";
    }
}
