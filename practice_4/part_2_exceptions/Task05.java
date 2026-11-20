package ru.mirea.oop.p4.exceptions;

/** Задание 5: самостоятельное создание исключения оператором throw. */
public class Task05 {
    static class ThrowsDemo {
        void getDetails(String key) {
            if (key == null) {
                throw new NullPointerException("null key in getDetails");
            }
            System.out.println("data for " + key);
        }
    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        try {
            demo.getDetails(null);
        } catch (NullPointerException e) {
            System.out.println("Caller handled: " + e.getMessage());
        }
        demo.getDetails("valid");
    }
}
