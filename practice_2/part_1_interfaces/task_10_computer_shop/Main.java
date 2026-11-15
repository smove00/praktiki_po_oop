package ru.mirea.oop.p2.part1.computershop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    enum Brand { ASUS, ACER, DELL, HP, LENOVO, APPLE, OTHER }

    static class Processor {
        private final String model;
        private final int cores;
        Processor(String model, int cores) {
            if (cores < 1) throw new IllegalArgumentException("Ядер должно быть не менее одного");
            this.model = model;
            this.cores = cores;
        }
        @Override public String toString() { return model + ", " + cores + " ядер"; }
    }

    static class Memory {
        private final int capacityGb;
        Memory(int capacityGb) {
            if (capacityGb <= 0) throw new IllegalArgumentException("Объём ОЗУ должен быть положительным");
            this.capacityGb = capacityGb;
        }
        @Override public String toString() { return capacityGb + " ГБ"; }
    }

    static class Monitor {
        private final double diagonalInches;
        Monitor(double diagonalInches) {
            if (diagonalInches <= 0) throw new IllegalArgumentException("Диагональ должна быть положительной");
            this.diagonalInches = diagonalInches;
        }
        @Override public String toString() { return diagonalInches + " дюймов"; }
    }

    static class Computer {
        private final int id;
        private final Brand brand;
        private final Processor processor;
        private final Memory memory;
        private final Monitor monitor;

        Computer(int id, Brand brand, Processor processor, Memory memory, Monitor monitor) {
            this.id = id;
            this.brand = brand;
            this.processor = processor;
            this.memory = memory;
            this.monitor = monitor;
        }
        int getId() { return id; }
        Brand getBrand() { return brand; }
        @Override public String toString() {
            return "#" + id + " " + brand + " | CPU: " + processor
                    + " | RAM: " + memory + " | монитор: " + monitor;
        }
    }

    interface ShopOperations {
        void add(Computer computer);
        boolean removeById(int id);
        List<Computer> findByBrand(Brand brand);
    }

    static class Shop implements ShopOperations {
        private final List<Computer> computers = new ArrayList<Computer>();

        @Override public void add(Computer computer) {
            for (Computer existing : computers) {
                if (existing.getId() == computer.getId()) {
                    throw new IllegalArgumentException("ID должен быть уникальным");
                }
            }
            computers.add(computer);
        }
        @Override public boolean removeById(int id) {
            for (int i = 0; i < computers.size(); i++) {
                if (computers.get(i).getId() == id) {
                    computers.remove(i);
                    return true;
                }
            }
            return false;
        }
        @Override public List<Computer> findByBrand(Brand brand) {
            List<Computer> found = new ArrayList<Computer>();
            for (Computer item : computers) if (item.getBrand() == brand) found.add(item);
            return found;
        }
        List<Computer> all() { return Collections.unmodifiableList(computers); }
    }

    static class ConsoleInterface {
        private final Scanner scanner = new Scanner(System.in);
        private final Shop shop = new Shop();
        private int nextId = 1;

        void run() {
            System.out.println("Интернет-магазин компьютерной техники");
            while (true) {
                System.out.println("\n1 — добавить  2 — удалить  3 — найти по марке  4 — список  0 — выход");
                int command = readInt("Команда: ", 0);
                switch (command) {
                    case 1: addComputer(); break;
                    case 2:
                        System.out.println(shop.removeById(readInt("ID: ", 1))
                                ? "Компьютер удалён" : "Компьютер не найден");
                        break;
                    case 3: printComputers(shop.findByBrand(readBrand())); break;
                    case 4: printComputers(shop.all()); break;
                    case 0: return;
                    default: System.out.println("Неизвестная команда");
                }
            }
        }

        private void addComputer() {
            Brand brand = readBrand();
            System.out.print("Модель процессора: ");
            String cpu = scanner.nextLine().trim();
            int cores = readInt("Количество ядер: ", 1);
            int memoryGb = readInt("Объём ОЗУ в ГБ: ", 1);
            double diagonal = readDouble("Диагональ монитора в дюймах: ");
            Computer computer = new Computer(nextId++, brand,
                    new Processor(cpu, cores), new Memory(memoryGb), new Monitor(diagonal));
            shop.add(computer);
            System.out.println("Добавлен: " + computer);
        }

        private Brand readBrand() {
            while (true) {
                System.out.print("Марка " + java.util.Arrays.toString(Brand.values()) + ": ");
                try {
                    return Brand.valueOf(scanner.nextLine().trim().toUpperCase(Locale.ROOT));
                } catch (IllegalArgumentException ex) {
                    System.out.println("Выберите марку из списка.");
                }
            }
        }

        private int readInt(String prompt, int min) {
            while (true) {
                System.out.print(prompt);
                try {
                    int value = Integer.parseInt(scanner.nextLine().trim());
                    if (value >= min) return value;
                } catch (NumberFormatException ignored) { }
                System.out.println("Введите целое число от " + min + ".");
            }
        }

        private double readDouble(String prompt) {
            while (true) {
                System.out.print(prompt);
                try {
                    double value = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
                    if (Double.isFinite(value) && value > 0) return value;
                } catch (NumberFormatException ignored) { }
                System.out.println("Введите положительное число.");
            }
        }

        private void printComputers(List<Computer> computers) {
            if (computers.isEmpty()) System.out.println("Подходящих компьютеров нет.");
            else for (Computer computer : computers) System.out.println(computer);
        }
    }

    public static void main(String[] args) {
        new ConsoleInterface().run();
    }
}
