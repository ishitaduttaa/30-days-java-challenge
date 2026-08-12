import javax.swing.*;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random r = new Random();
        int number = r.nextInt(10) + 1;
        JFrame frame = new JFrame("Guessing Game");
        JLabel label = new JLabel("Guess a number from 1 to 10:");
        JTextField input = new JTextField();
        JButton button = new JButton("Guess");
        JLabel result = new JLabel("");
        frame.setLayout(null);
        label.setBounds(80, 30, 250, 30);
        input.setBounds(120, 70, 150, 30);
        button.setBounds(140, 110, 100, 30);
        result.setBounds(100, 160, 220, 30);
        frame.add(label);
        frame.add(input);
        frame.add(button);
        frame.add(result);

        button.addActionListener(e -> {
            int guess = Integer.parseInt(input.getText());
            if (guess == number) {
                result.setText("Correct!");
            }
            else if (guess < number) {
                result.setText("Too Low!");
            }
            else {
                result.setText("Too High!");
            }
        });
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}