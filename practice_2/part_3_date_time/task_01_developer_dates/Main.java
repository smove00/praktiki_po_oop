package ru.mirea.oop.p2.part3.developerdates;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm", new Locale("ru", "RU"));
        format.setLenient(false);
        System.out.print("Фамилия разработчика: ");
        String surname = scanner.nextLine().trim();
        System.out.print("Дата и время получения задания (дд.ММ.гггг чч:мм): ");
        Date received;
        try {
            received = format.parse(scanner.nextLine().trim());
        } catch (java.text.ParseException ex) {
            System.out.println("Ошибка формата даты: " + ex.getMessage());
            return;
        }
        Date submitted = new Date(); // реальное системное время выполнения
        System.out.println("Разработчик: " + surname);
        System.out.println("Получение задания: " + format.format(received));
        System.out.println("Сдача задания: " + format.format(submitted));
    }
}
