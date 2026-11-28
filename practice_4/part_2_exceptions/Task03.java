package ru.mirea.oop.p4.exceptions;

import java.util.Scanner;

/**
 * Задание 3. Порядок catch и наследование исключений.
 * Если поставить catch (Exception ex) первым, то следующие catch
 * (NumberFormatException ex) и catch (ArithmeticException ex) станут
 * недостижимыми. Компилятор выдаст: exception ... has already been caught.
 * Ниже корректный порядок: сначала конкретные, затем общий Exception.
 */
public class Task03 {
    public String exceptionDemo(String input) {
        try {
            int number = Integer.parseInt(input);
            return "2 / " + number + " = " + (2 / number);
        } catch (NumberFormatException ex) {
            return "Invalid integer: " + input;
        } catch (ArithmeticException ex) {
            return "Attempted division by zero";
        } catch (Exception ex) {
            return "Unexpected exception: " + ex.getClass().getSimpleName();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        if (!scanner.hasNextLine()) {
            System.out.println("Invalid integer: no input");
            return;
        }
        System.out.println(new Task03().exceptionDemo(scanner.nextLine().trim()));
    }
}
