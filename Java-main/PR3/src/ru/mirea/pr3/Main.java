package ru.mirea.pr3;

public class Main {
    public static void main(String[] args) {
        demonstrateAbstractClass();
        demonstrateShapes();
        demonstrateMovement();
    }

    private static void demonstrateAbstractClass() {
        Swimmer swimmer = new Swimmer();
        swimmer.run();
        swimmer.neigh();
    }

    private static void demonstrateShapes() {
        Shape circleView = new Circle(5.5, "RED", false);
        System.out.println(circleView);
        System.out.println("Площадь: " + circleView.getArea());
        System.out.println("Периметр: " + circleView.getPerimeter());
        System.out.println("Цвет: " + circleView.getColor());
        System.out.println("Залита: " + circleView.isFilled());

        // У ссылки Shape нет метода getRadius(): к конкретному типу нужно привести объект.
        // Восходящее преобразование Circle -> Shape выполняется автоматически.
        Circle circle = (Circle) circleView;
        System.out.println("Радиус: " + circle.getRadius());
        System.out.println(circle);

        // Shape является абстрактным классом, поэтому такое создание объекта запрещено:
        // Shape impossible = new Shape();

        Shape rectangleView = new Rectangle(1.0, 2.0, "RED", false);
        System.out.println(rectangleView);
        System.out.println("Площадь: " + rectangleView.getArea());
        System.out.println("Периметр: " + rectangleView.getPerimeter());
        System.out.println("Цвет: " + rectangleView.getColor());

        Rectangle rectangle = (Rectangle) rectangleView;
        System.out.println("Длина: " + rectangle.getLength());

        Shape squareView = new Square(6.6);
        System.out.println(squareView);
        System.out.println("Площадь: " + squareView.getArea());
        System.out.println("Цвет: " + squareView.getColor());
        // Метод getSide() не виден через тип Shape, поэтому сначала выполняем downcast.
        Square square = (Square) squareView;
        System.out.println("Сторона: " + square.getSide());

        // Square является подклассом Rectangle, поэтому такое приведение тоже допустимо.
        Rectangle rectangleViewOfSquare = (Rectangle) squareView;
        System.out.println(rectangleViewOfSquare);
        System.out.println("Площадь: " + rectangleViewOfSquare.getArea());
        System.out.println("Длина: " + rectangleViewOfSquare.getLength());

        Square squareAgain = (Square) rectangleViewOfSquare;
        System.out.println(squareAgain);
        System.out.println("Сторона: " + squareAgain.getSide());
    }

    private static void demonstrateMovement() {
        MovablePoint point = new MovablePoint(5, 10, 2, 3);
        System.out.println(point);
        point.moveUp();
        System.out.println(point);

        MovableCircle circle = new MovableCircle(5, 5, 2, 2, 10);
        circle.moveRight();
        System.out.println(circle);

        MovableRectangle rectangle = new MovableRectangle(0, 0, 10, 5, 2, 2);
        System.out.println("Скорости точек совпадают: " + rectangle.hasSameSpeed());
        rectangle.moveDown();
        System.out.println(rectangle);
    }
}
