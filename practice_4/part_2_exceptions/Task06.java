package ru.mirea.oop.p4.exceptions;

/** Задание 6: исключение распространяется из getDetails в printMessage. */
public class Task06 {
    static class ThrowsDemo {
        String getDetails(String key) {
            if (key == null) throw new NullPointerException("null key in getDetails");
            return "data for " + key;
        }

        void printMessage(String key) {
            String message = getDetails(key);
            System.out.println(message);
        }
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        demo.printMessage("valid");
        try {
            demo.printMessage(null);
        } catch (NullPointerException e) {
            System.out.println("Exception propagated to caller: " + e.getMessage());
        }
        System.out.println("Program continues");
    }
}
