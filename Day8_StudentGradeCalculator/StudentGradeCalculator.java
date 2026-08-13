import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Grade Calculator");
        JLabel nameLabel = new JLabel("Student Name:");
        JTextField nameField = new JTextField();
        JLabel mark1Label = new JLabel("Subject 1:");
        JTextField mark1Field = new JTextField();
        JLabel mark2Label = new JLabel("Subject 2:");
        JTextField mark2Field = new JTextField();
        JLabel mark3Label = new JLabel("Subject 3:");
        JTextField mark3Field = new JTextField();
        JButton calculateButton = new JButton("Calculate");
        JLabel resultLabel = new JLabel("Result:");
        frame.setLayout(new GridLayout(6, 2, 10, 10));
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(mark1Label);
        frame.add(mark1Field);
        frame.add(mark2Label);
        frame.add(mark2Field);
        frame.add(mark3Label);
        frame.add(mark3Field);
        frame.add(calculateButton);
        frame.add(resultLabel);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int mark1 = Integer.parseInt(mark1Field.getText());
                int mark2 = Integer.parseInt(mark2Field.getText());
                int mark3 = Integer.parseInt(mark3Field.getText());
                double average = (mark1 + mark2 + mark3) / 3.0;
                String grade;
                if (average >= 90)
                    grade = "A";
                else if (average >= 80)
                    grade = "B";
                else if (average >= 70)
                    grade = "C";
                else if (average >= 60)
                    grade = "D";
                else
                    grade = "F";
                resultLabel.setText(
                        name + " - Average: " + average + " Grade: " + grade
                );
            }
        });
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}