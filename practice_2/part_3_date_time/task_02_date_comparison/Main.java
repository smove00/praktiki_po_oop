package ru.mirea.oop.p2.part3.datecomparison;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату (дд.ММ.гггг): ");
        String text = scanner.nextLine().trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu")
                .withResolverStyle(java.time.format.ResolverStyle.STRICT);
        try {
            LocalDate entered = LocalDate.parse(text, formatter);
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime userDate = entered.atTime(LocalTime.MIDNIGHT);
            System.out.println("Сейчас: " + now);
            System.out.println("Введённая дата (00:00): " + userDate);
            int comparison = userDate.compareTo(now);
            if (comparison < 0) System.out.println("Введённая дата раньше текущего времени.");
            else if (comparison > 0) System.out.println("Введённая дата позже текущего времени.");
            else System.out.println("Даты и время совпадают.");
        } catch (DateTimeParseException exception) {
            System.out.println("Неверная дата. Используйте формат дд.ММ.гггг.");
        }
    }
}
