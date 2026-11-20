package ru.mirea.oop.p4.recursion;

import java.io.IOException;
import java.io.UncheckedIOException;

/** Чтение целого числа без глобального состояния и буферизации ввода. */
final class NumberReader {
    private NumberReader() { }

    static int nextInt() {
        try {
            int ch;
            do {
                ch = System.in.read();
                if (ch == -1) throw new IllegalStateException("Неожиданный конец ввода");
            } while (Character.isWhitespace((char) ch));
            int sign = 1;
            if (ch == '-') {
                sign = -1;
                ch = System.in.read();
            }
            int value = 0;
            while (ch >= '0' && ch <= '9') {
                value = value * 10 + (ch - '0');
                ch = System.in.read();
            }
            return sign * value;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
