package ru.mirea.oop.p2.part1.observer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    interface ChangeListener {
        void onChanged(String before, String after);
    }

    static class ObservableStringBuilder {
        private final StringBuilder delegate = new StringBuilder();
        private final List<ChangeListener> listeners = new ArrayList<ChangeListener>();

        void addListener(ChangeListener listener) {
            if (listener == null) throw new IllegalArgumentException("Обработчик не может быть null");
            listeners.add(listener);
        }
        void removeListener(ChangeListener listener) { listeners.remove(listener); }

        private ObservableStringBuilder change(Runnable operation) {
            String before = delegate.toString();
            operation.run();
            String after = delegate.toString();
            if (!before.equals(after)) {
                for (ChangeListener listener : new ArrayList<ChangeListener>(listeners)) {
                    listener.onChanged(before, after);
                }
            }
            return this;
        }

        ObservableStringBuilder append(final Object value) {
            return change(new Runnable() {
                @Override public void run() { delegate.append(value); }
            });
        }
        ObservableStringBuilder insert(final int index, final String value) {
            return change(new Runnable() {
                @Override public void run() { delegate.insert(index, value); }
            });
        }
        ObservableStringBuilder delete(final int start, final int end) {
            return change(new Runnable() {
                @Override public void run() { delegate.delete(start, end); }
            });
        }
        ObservableStringBuilder replace(final int start, final int end, final String value) {
            return change(new Runnable() {
                @Override public void run() { delegate.replace(start, end, value); }
            });
        }
        ObservableStringBuilder reverse() {
            return change(new Runnable() {
                @Override public void run() { delegate.reverse(); }
            });
        }
        ObservableStringBuilder setCharAt(final int index, final char value) {
            return change(new Runnable() {
                @Override public void run() { delegate.setCharAt(index, value); }
            });
        }
        ObservableStringBuilder setLength(final int length) {
            return change(new Runnable() {
                @Override public void run() { delegate.setLength(length); }
            });
        }

        int length() { return delegate.length(); }
        char charAt(int index) { return delegate.charAt(index); }
        String substring(int start, int end) { return delegate.substring(start, end); }
        @Override public String toString() { return delegate.toString(); }
    }

    public static void main(String[] args) {
        ObservableStringBuilder text = new ObservableStringBuilder();
        ChangeListener console = new ChangeListener() {
            @Override public void onChanged(String before, String after) {
                System.out.println("Изменение: «" + before + "» -> «" + after + "»");
            }
        };
        text.addListener(console);
        text.append("Java").append(" interfaces").replace(5, 15, "OOP");
        text.reverse();
        text.removeListener(console);
        text.append("!");
        System.out.println("Итог: " + text);
    }
}
