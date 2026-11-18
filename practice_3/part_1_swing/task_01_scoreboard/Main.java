package ru.mirea.oop.p3.part1.scoreboard;

import javax.swing.*;
import java.awt.*;

public class Main {
    private int milan, madrid;
    private final JLabel result = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
    private final JLabel scorer = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
    private final JLabel winner = new JLabel("Winner: DRAW", SwingConstants.CENTER);

    private void goal(boolean isMilan) {
        if (isMilan) milan++; else madrid++;
        result.setText("Result: " + milan + " X " + madrid);
        scorer.setText("Last Scorer: " + (isMilan ? "AC Milan" : "Real Madrid"));
        winner.setText("Winner: " + (milan == madrid ? "DRAW" : milan > madrid ? "AC Milan" : "Real Madrid"));
    }

    private void show() {
        JFrame frame = new JFrame("AC Milan — Real Madrid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttons = new JPanel();
        JButton ac = new JButton("AC Milan"), real = new JButton("Real Madrid");
        ac.addActionListener(e -> goal(true));
        real.addActionListener(e -> goal(false));
        buttons.add(ac); buttons.add(real);
        JPanel labels = new JPanel(new GridLayout(3, 1, 5, 5));
        labels.add(result); labels.add(scorer); labels.add(winner);
        frame.add(buttons, BorderLayout.NORTH); frame.add(labels, BorderLayout.CENTER);
        frame.setSize(380, 200); frame.setLocationRelativeTo(null); frame.setVisible(true);
    }
    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new Main().show()); }
}
