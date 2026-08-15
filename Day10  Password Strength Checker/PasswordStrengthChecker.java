import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordStrengthChecker extends JFrame {
    JTextField passwordField;
    JLabel result;
    PasswordStrengthChecker() {
        setTitle("Password Strength Checker");
        setSize(400, 250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel title = new JLabel("Password Strength Checker");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel passwordLabel = new JLabel("Enter Password:");
        passwordField = new JTextField(20);
        JButton checkButton = new JButton("Check Strength");
        result = new JLabel(" ");
        result.setFont(new Font("Arial", Font.BOLD, 18));
        add(title);
        add(passwordLabel);
        add(passwordField);
        add(checkButton);
        add(result);

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = passwordField.getText();
                int score = 0;
                if (password.length() >= 8) score++;
                if (password.matches(".*[A-Z].*")) score++;
                if (password.matches(".*[a-z].*")) score++;
                if (password.matches(".*[0-9].*")) score++;
                if (password.matches(".*[@#$%!].*")) score++;
                if (score <= 2) result.setText("Weak Password");
                else if (score == 3 || score == 4) result.setText("Medium Password");
                else
                    result.setText("Strong Password");
            }});
        setVisible(true);
    }
    public static void main(String[] args) {
        new PasswordStrengthChecker();
    }
}