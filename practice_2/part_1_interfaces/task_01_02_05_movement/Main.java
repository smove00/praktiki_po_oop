package ru.mirea.oop.p2.part1.movement;

public class Main {
    interface Movable {
        void moveUp();
        void moveDown();
        void moveLeft();
        void moveRight();
    }

    static class MovablePoint implements Movable {
        private int x, y, xSpeed, ySpeed;

        MovablePoint(int x, int y, int xSpeed, int ySpeed) {
            this.x = x;
            this.y = y;
            this.xSpeed = xSpeed;
            this.ySpeed = ySpeed;
        }

        @Override public void moveUp() { y -= ySpeed; }
        @Override public void moveDown() { y += ySpeed; }
        @Override public void moveLeft() { x -= xSpeed; }
        @Override public void moveRight() { x += xSpeed; }

        int getXSpeed() { return xSpeed; }
        int getYSpeed() { return ySpeed; }

        @Override public String toString() {
            return String.format("(%d, %d), скорость=(%d, %d)", x, y, xSpeed, ySpeed);
        }
    }

    static class MovableCircle implements Movable {
        private final int radius;
        private final MovablePoint center;

        MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
            if (radius <= 0) throw new IllegalArgumentException("Радиус должен быть положительным");
            this.radius = radius;
            center = new MovablePoint(x, y, xSpeed, ySpeed);
        }

        @Override public void moveUp() { center.moveUp(); }
        @Override public void moveDown() { center.moveDown(); }
        @Override public void moveLeft() { center.moveLeft(); }
        @Override public void moveRight() { center.moveRight(); }

        @Override public String toString() {
            return "Окружность: центр=" + center + ", радиус=" + radius;
        }
    }

    static class MovableRectangle implements Movable {
        private final MovablePoint topLeft, bottomRight;

        MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
            if (x1 >= x2 || y1 >= y2) {
                throw new IllegalArgumentException("Укажите верхнюю левую и нижнюю правую точки");
            }
            topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
            bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
        }

        boolean speedTest() {
            return topLeft.getXSpeed() == bottomRight.getXSpeed()
                    && topLeft.getYSpeed() == bottomRight.getYSpeed();
        }

        private void checkSpeed() {
            if (!speedTest()) throw new IllegalStateException("Скорости точек отличаются");
        }

        @Override public void moveUp() { checkSpeed(); topLeft.moveUp(); bottomRight.moveUp(); }
        @Override public void moveDown() { checkSpeed(); topLeft.moveDown(); bottomRight.moveDown(); }
        @Override public void moveLeft() { checkSpeed(); topLeft.moveLeft(); bottomRight.moveLeft(); }
        @Override public void moveRight() { checkSpeed(); topLeft.moveRight(); bottomRight.moveRight(); }

        @Override public String toString() {
            return "Прямоугольник: верхний левый=" + topLeft + ", нижний правый=" + bottomRight;
        }
    }

    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(10, 20, 2, 3);
        MovableCircle circle = new MovableCircle(5, 5, 1, 2, 4);
        MovableRectangle rectangle = new MovableRectangle(0, 0, 10, 5, 2, 3);

        System.out.println("До перемещения:");
        System.out.println(point);
        System.out.println(circle);
        System.out.println(rectangle);
        point.moveRight();
        circle.moveUp();
        rectangle.moveDown();
        rectangle.moveLeft();

        System.out.println("\nПосле перемещения:");
        System.out.println(point);
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println("Скорости точек прямоугольника равны: " + rectangle.speedTest());
    }
}
