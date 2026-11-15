package ru.mirea.oop.p2.part2.publications;

public class Main {
    interface Printable { void print(); }

    static class Book implements Printable {
        private final String name;
        Book(String name) { this.name = name; }
        @Override public void print() { System.out.println("Книга: " + name); }

        static void printBooks(Printable[] printable) {
            System.out.println("Только книги:");
            for (Printable item : printable) {
                if (item instanceof Book) System.out.println(((Book) item).name);
            }
        }
    }

    static class Magazine implements Printable {
        private final String name;
        Magazine(String name) { this.name = name; }
        @Override public void print() { System.out.println("Журнал: " + name); }

        static void printMagazines(Printable[] printable) {
            System.out.println("Только журналы:");
            for (Printable item : printable) {
                if (item instanceof Magazine) System.out.println(((Magazine) item).name);
            }
        }
    }

    public static void main(String[] args) {
        Printable[] publications = {
            new Book("Война и мир"), new Magazine("Наука и жизнь"),
            new Book("Мастер и Маргарита"), new Magazine("Популярная механика")
        };
        Book.printBooks(publications);
        Magazine.printMagazines(publications);
    }
}
