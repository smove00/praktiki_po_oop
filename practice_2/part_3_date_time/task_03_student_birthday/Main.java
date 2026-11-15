package ru.mirea.oop.p2.part3.studentbirthday;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {
    enum DateFormat { SHORT, MEDIUM, FULL }

    static class Student {
        private final String name;
        private final LocalDate birthDate;

        Student(String name, LocalDate birthDate) {
            this.name = name;
            this.birthDate = birthDate;
        }

        String formatBirthDate(DateFormat format) {
            FormatStyle style;
            switch (format) {
                case SHORT: style = FormatStyle.SHORT; break;
                case MEDIUM: style = FormatStyle.MEDIUM; break;
                case FULL: style = FormatStyle.FULL; break;
                default: throw new IllegalArgumentException("Неизвестный формат");
            }
            return birthDate.format(DateTimeFormatter.ofLocalizedDate(style).withLocale(new Locale("ru", "RU")));
        }

        @Override public String toString() {
            return "Студент: " + name + ", дата рождения: " + formatBirthDate(DateFormat.MEDIUM);
        }
    }

    public static void main(String[] args) {
        Student student = new Student("Иван Иванов", LocalDate.of(2005, 4, 12));
        System.out.println(student);
        for (DateFormat format : DateFormat.values()) {
            System.out.println(format + ": " + student.formatBirthDate(format));
        }
    }
}
