package ru.mirea.oop.p2.part1.temperature;

import java.util.Scanner;

public class Main {
    interface Convertable { double convert(double celsius); }

    static class KelvinConverter implements Convertable {
        @Override public double convert(double celsius) { return celsius + 273.15; }
    }

    static class FahrenheitConverter implements Convertable {
        @Override public double convert(double celsius) { return celsius * 9.0 / 5.0 + 32.0; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Температура по Цельсию: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Некорректное число");
            return;
        }
        double celsius = scanner.nextDouble();
        if (celsius < -273.15) {
            System.out.println("Температура ниже абсолютного нуля невозможна");
            return;
        }
        Convertable kelvin = new KelvinConverter();
        Convertable fahrenheit = new FahrenheitConverter();
        System.out.printf(java.util.Locale.US, "%.2f °C = %.2f K = %.2f °F%n",
                celsius, kelvin.convert(celsius), fahrenheit.convert(celsius));
    }
}
