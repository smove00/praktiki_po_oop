package ru.mirea.oop.p2.part1.undo;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    // Поведенческий шаблон «Команда»: каждая операция умеет исполняться и отменяться.
    interface Command {
        void execute();
        void undo();
    }

    static class UndoableStringBuilder {
        private final StringBuilder delegate = new StringBuilder();
        private final Deque<Command> history = new ArrayDeque<Command>();

        private UndoableStringBuilder execute(final Runnable operation) {
            final String before = delegate.toString();
            Command command = new Command() {
                @Override public void execute() { operation.run(); }
                @Override public void undo() {
                    delegate.setLength(0);
                    delegate.append(before);
                }
            };
            command.execute();
            history.push(command);
            return this;
        }

        UndoableStringBuilder append(final Object value) {
            return execute(new Runnable() {
                @Override public void run() { delegate.append(value); }
            });
        }
        UndoableStringBuilder insert(final int offset, final String value) {
            return execute(new Runnable() {
                @Override public void run() { delegate.insert(offset, value); }
            });
        }
        UndoableStringBuilder delete(final int start, final int end) {
            return execute(new Runnable() {
                @Override public void run() { delegate.delete(start, end); }
            });
        }
        UndoableStringBuilder replace(final int start, final int end, final String value) {
            return execute(new Runnable() {
                @Override public void run() { delegate.replace(start, end, value); }
            });
        }
        UndoableStringBuilder reverse() {
            return execute(new Runnable() {
                @Override public void run() { delegate.reverse(); }
            });
        }
        UndoableStringBuilder setCharAt(final int index, final char ch) {
            return execute(new Runnable() {
                @Override public void run() { delegate.setCharAt(index, ch); }
            });
        }
        UndoableStringBuilder setLength(final int length) {
            return execute(new Runnable() {
                @Override public void run() { delegate.setLength(length); }
            });
        }

        boolean undo() {
            if (history.isEmpty()) return false;
            history.pop().undo();
            return true;
        }

        int length() { return delegate.length(); }
        int capacity() { return delegate.capacity(); }
        char charAt(int index) { return delegate.charAt(index); }
        String substring(int start, int end) { return delegate.substring(start, end); }
        int indexOf(String value) { return delegate.indexOf(value); }
        @Override public String toString() { return delegate.toString(); }
    }

    public static void main(String[] args) {
        UndoableStringBuilder text = new UndoableStringBuilder();
        text.append("Java").append(" OOP").insert(4, " и");
        System.out.println("Сейчас: " + text);
        text.undo();
        System.out.println("После undo: " + text);
        text.undo();
        System.out.println("После второго undo: " + text);
        text.reverse();
        System.out.println("Наоборот: " + text);
        text.undo();
        System.out.println("После отмены reverse: " + text);
    }
}
