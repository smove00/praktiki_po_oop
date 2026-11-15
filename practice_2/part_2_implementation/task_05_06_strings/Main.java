package ru.mirea.oop.p2.part2.strings;

public class Main {
    interface StringProcessor {
        int countCharacters(String source);
        String oddPositions(String source);
        String reverse(String source);
    }

    static class ProcessStrings implements StringProcessor {
        @Override public int countCharacters(String source) {
            return source.codePointCount(0, source.length());
        }
        @Override public String oddPositions(String source) {
            int[] points = source.codePoints().toArray();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < points.length; i += 2) {
                result.appendCodePoint(points[i]);
            }
            return result.toString();
        }
        @Override public String reverse(String source) {
            int[] points = source.codePoints().toArray();
            StringBuilder result = new StringBuilder();
            for (int i = points.length - 1; i >= 0; i--) result.appendCodePoint(points[i]);
            return result.toString();
        }
    }

    public static void main(String[] args) {
        String text = "Программирование";
        StringProcessor processor = new ProcessStrings();
        System.out.println("Строка: " + text);
        System.out.println("Символов: " + processor.countCharacters(text));
        System.out.println("Символы на позициях 1, 3, 5...: " + processor.oddPositions(text));
        System.out.println("Инвертированная строка: " + processor.reverse(text));
    }
}
