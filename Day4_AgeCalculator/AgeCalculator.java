import javax.swing.*;
import java.awt.*;
public class AgeCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Age Calculator");
        JLabel title = new JLabel("Age Calculator");
        JTextField birthYear = new JTextField();
        JButton button = new JButton("Calculate Age");
        JLabel result = new JLabel();
        birthYear.setBorder(
                BorderFactory.createTitledBorder("Enter Birth Year")
        );

        button.addActionListener(e -> {
            int year = Integer.parseInt(birthYear.getText());
            int currentYear = 2026;
            int age = currentYear - year;
            result.setText("Your age is: " + age);
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.add(title);
        panel.add(birthYear);
        panel.add(button);
        panel.add(result);
        frame.add(panel);
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}