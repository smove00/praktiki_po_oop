package ru.mirea.oop.p2.part3.calendarcreation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    private static int readInt(Scanner scanner, String label) {
        System.out.print(label + ": ");
        if (!scanner.hasNextInt()) throw new IllegalArgumentException("Введите целое число");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int year = readInt(scanner, "Год");
            int month = readInt(scanner, "Месяц (1–12)");
            int day = readInt(scanner, "Число");
            int hour = readInt(scanner, "Часы (0–23)");
            int minute = readInt(scanner, "Минуты (0–59)");

            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setLenient(false);
            calendar.clear();
            calendar.set(year, month - 1, day, hour, minute);
            Date date = calendar.getTime(); // строгая проверка даты при вычислении
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            System.out.println("Объект Calendar: " + format.format(calendar.getTime()));
            System.out.println("Объект Date: " + format.format(date));
            System.out.println("Миллисекунды от эпохи: " + date.getTime());
        } catch (IllegalArgumentException exception) {
            System.out.println("Ошибка: " + exception.getMessage());
        }
    }
}
