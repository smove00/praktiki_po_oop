package ru.mirea.oop.p2.part2.rectangle;

public class Main {
    interface Movable {
        void moveUp();
        void moveDown();
        void moveLeft();
        void moveRight();
    }

    static class MovablePoint implements Movable {
        private int x, y;
        private final int xSpeed, ySpeed;
        MovablePoint(int x, int y, int xSpeed, int ySpeed) {
            this.x = x; this.y = y; this.xSpeed = xSpeed; this.ySpeed = ySpeed;
        }
        int getXSpeed() { return xSpeed; }
        int getYSpeed() { return ySpeed; }
        @Override public void moveUp() { y -= ySpeed; }
        @Override public void moveDown() { y += ySpeed; }
        @Override public void moveLeft() { x -= xSpeed; }
        @Override public void moveRight() { x += xSpeed; }
        @Override public String toString() { return "(" + x + ", " + y + ")"; }
    }

    static class MovableRectangle implements Movable {
        private final MovablePoint topLeft, bottomRight;

        MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
            if (x1 >= x2 || y1 >= y2) throw new IllegalArgumentException("Неверные координаты");
            topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
            bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
        }

        boolean SpeedTest() {
            return topLeft.getXSpeed() == bottomRight.getXSpeed()
                && topLeft.getYSpeed() == bottomRight.getYSpeed();
        }

        private void checkSpeed() {
            if (!SpeedTest()) throw new IllegalStateException("Скорости точек должны совпадать");
        }

        @Override public void moveUp() { checkSpeed(); topLeft.moveUp(); bottomRight.moveUp(); }
        @Override public void moveDown() { checkSpeed(); topLeft.moveDown(); bottomRight.moveDown(); }
        @Override public void moveLeft() { checkSpeed(); topLeft.moveLeft(); bottomRight.moveLeft(); }
        @Override public void moveRight() { checkSpeed(); topLeft.moveRight(); bottomRight.moveRight(); }

        @Override public String toString() {
            return "Прямоугольник: topLeft=" + topLeft + ", bottomRight=" + bottomRight;
        }
    }

    public static void main(String[] args) {
        MovableRectangle rectangle = new MovableRectangle(1, 1, 8, 5, 2, 3);
        System.out.println(rectangle);
        System.out.println("SpeedTest(): " + rectangle.SpeedTest());
        rectangle.moveRight();
        rectangle.moveDown();
        System.out.println("После движения вправо и вниз: " + rectangle);
    }
}
