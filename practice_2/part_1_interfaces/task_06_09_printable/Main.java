package ru.mirea.oop.p2.part1.printable;

public class Main {
    interface Printable { void print(); }

    static class Book implements Printable {
        private final String title, author;
        Book(String title, String author) { this.title = title; this.author = author; }
        @Override public void print() {
            System.out.println("Книга: «" + title + "», автор: " + author);
        }
    }

    static class Shop implements Printable {
        private final String name;
        Shop(String name) { this.name = name; }
        @Override public void print() {
            System.out.println("Магазин: " + name);
        }
    }

    static class Journal implements Printable {
        private final String title;
        Journal(String title) { this.title = title; }
        @Override public void print() {
            System.out.println("Журнал: «" + title + "»");
        }
    }

    public static void main(String[] args) {
        // Задания 6–8: интерфейс Printable и его реализации Book, Shop.
        new Shop("Книжный мир").print();

        // Задание 9: массив интерфейсного типа содержит книги и журналы.
        Printable[] publications = {
            new Book("Война и мир", "Л. Н. Толстой"),
            new Journal("Наука и жизнь"),
            new Book("Отцы и дети", "И. С. Тургенев")
        };
        for (Printable publication : publications) publication.print();
    }
}
