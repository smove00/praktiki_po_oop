package ru.mirea.oop.p3.part1.scoreboard;

import java.awt.*;
import javax.swing.*;

public class Main {
    public static final class Score {
        private int milan;
        private int madrid;
        private String lastScorer = "N/A";
        public void goalMilan() { milan++; lastScorer = "AC Milan"; }
        public void goalMadrid() { madrid++; lastScorer = "Real Madrid"; }
        public String result() { return "Result: " + milan + " X " + madrid; }
        public String last() { return "Last Scorer: " + lastScorer; }
        public String winner() {
            return "Winner: " + (milan > madrid ? "AC Milan" : madrid > milan ? "Real Madrid" : "DRAW");
        }
    }

    private static void createWindow() {
        Score model = new Score();
        JFrame frame = new JFrame("AC Milan — Real Madrid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(5, 1, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(18, 24, 18, 24));
        JLabel result = new JLabel(model.result(), SwingConstants.CENTER);
        JLabel last = new JLabel(model.last(), SwingConstants.CENTER);
        JLabel winner = new JLabel(model.winner(), SwingConstants.CENTER);
        result.setFont(result.getFont().deriveFont(Font.BOLD, 22f));
        JButton milan = new JButton("AC Milan");
        JButton madrid = new JButton("Real Madrid");
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
            if (!score.winner().endsWith("DRAW")) throw new AssertionError();
            score.goalMilan(); score.goalMilan(); score.goalMadrid();
            if (!"Result: 2 X 1".equals(score.result()) ||
                !"Last Scorer: Real Madrid".equals(score.last()) ||
                !"Winner: AC Milan".equals(score.winner())) throw new AssertionError();
            System.out.println("Scoreboard model OK");
            return;
        }
        SwingUtilities.invokeLater(Main::createWindow);
    }
}
