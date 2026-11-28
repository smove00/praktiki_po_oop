package ru.mirea.oop.p3.part1.scoreboard;

// Задание 1. Табло футбольного матча.

import java.awt.*;
import javax.swing.*;

public class Main {
    public static final class Score {
        private int milan;
        private int madrid;
        private String lastScorer = "Нет";
        public void goalMilan() { milan++; lastScorer = "Милан"; }
        public void goalMadrid() { madrid++; lastScorer = "Реал Мадрид"; }
        public String result() { return "Счёт: " + milan + " X " + madrid; }
        public String last() { return "Последний гол: " + lastScorer; }
        public String winner() {
            return "Победитель: " + (milan > madrid ? "Милан" : madrid > milan ? "Реал Мадрид" : "Ничья");
        }
    }

    private static void createWindow() {
        Score model = new Score();
        JFrame frame = new JFrame("Счёт матча");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(5, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(18, 24, 18, 24));
        JLabel result = new JLabel(model.result(), SwingConstants.CENTER);
        JLabel last = new JLabel(model.last(), SwingConstants.CENTER);
        JLabel winner = new JLabel(model.winner(), SwingConstants.CENTER);
        result.setFont(result.getFont().deriveFont(Font.BOLD, 22f));
        JButton milan = new JButton("Милан");
        JButton madrid = new JButton("Реал Мадрид");
        milan.addActionListener(event -> {
            model.goalMilan();
            refresh(model, result, last, winner);
        });
        madrid.addActionListener(event -> {
            model.goalMadrid();
            refresh(model, result, last, winner);
        });
        panel.add(milan);
        panel.add(madrid);
        panel.add(result);
        panel.add(last);
        panel.add(winner);
        frame.setContentPane(panel);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void refresh(Score model, JLabel result, JLabel last, JLabel winner) {
        result.setText(model.result());
        last.setText(model.last());
        winner.setText(model.winner());
    }

    public static void main(String[] args) {
        if (args.length > 0 && "--self-test".equals(args[0])) {
            Score score = new Score();
            if (!score.winner().endsWith("Ничья")) throw new AssertionError();
            score.goalMilan(); score.goalMilan(); score.goalMadrid();
            if (!"Счёт: 2 X 1".equals(score.result()) ||
                !"Последний гол: Реал Мадрид".equals(score.last()) ||
                !"Победитель: Милан".equals(score.winner())) throw new AssertionError();
            System.out.println("Счёт работает");
            return;
        }
        SwingUtilities.invokeLater(Main::createWindow);
    }
}
