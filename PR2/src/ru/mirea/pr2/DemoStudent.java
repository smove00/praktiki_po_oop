package ru.mirea.pr2;

public class DemoStudent {
    public static void main(String[] args) {
        Student firstStudent = new Student("Paul Lee", 3.5);
        Student secondStudent = new Student("Peter Tan", 3.9);

        printStudent(firstStudent);
        printStudent(secondStudent);
    }

    private static void printStudent(Student student) {
        System.out.println(student.getName());
        student.printGrade();
    }
}
