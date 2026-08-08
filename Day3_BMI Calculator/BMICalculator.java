import javax.swing.*;
import java.awt.event.*;

public class BMICalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator");
        JLabel weightLabel = new JLabel("Weight (kg):");
        weightLabel.setBounds(30, 30, 100, 30);
        JTextField weightField = new JTextField();
        weightField.setBounds(130, 30, 150, 30);
        JLabel heightLabel = new JLabel("Height (cm):");
        heightLabel.setBounds(30, 80, 100, 30);
        JTextField heightField = new JTextField();
        heightField.setBounds(130, 80, 150, 30);
        JButton button = new JButton("Calculate BMI");
        button.setBounds(80, 130, 160, 40);
        JLabel resultLabel = new JLabel("BMI: ");
        resultLabel.setBounds(30, 190, 250, 30);
        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setBounds(30, 230, 250, 30);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double weight = Double.parseDouble(weightField.getText());
                double height = Double.parseDouble(heightField.getText());
                // Convert cm to meters
                height = height / 100;
                double bmi = weight / (height * height);
                resultLabel.setText("BMI: " + String.format("%.2f", bmi));
                if (bmi < 18.5) {
                    categoryLabel.setText("Category: Underweight");
                }
                else if (bmi < 25) {
                    categoryLabel.setText("Category: Normal");
                }
                else if (bmi < 30) {
                    categoryLabel.setText("Category: Overweight");
                }
                else {
                    categoryLabel.setText("Category: Obese");
                }
            }
        });
        frame.add(weightLabel);
        frame.add(weightField);
        frame.add(heightLabel);
        frame.add(heightField);
        frame.add(button);
        frame.add(resultLabel);
        frame.add(categoryLabel);
        frame.setSize(330, 320);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}