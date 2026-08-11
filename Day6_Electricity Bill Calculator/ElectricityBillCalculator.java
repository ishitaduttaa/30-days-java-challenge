import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ElectricityBillCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Electricity Bill Calculator");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2, 10, 10));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel unitsLabel = new JLabel("Enter Units:");
        JTextField unitsField = new JTextField();
        JLabel billLabel = new JLabel("Electricity Bill:");
        JTextField billField = new JTextField();
        billField.setEditable(false);
        JButton calculateButton = new JButton("Calculate");
        JButton clearButton = new JButton("Clear");
        frame.add(unitsLabel);
        frame.add(unitsField);
        frame.add(billLabel);
        frame.add(billField);
        frame.add(calculateButton);
        frame.add(clearButton);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int units = Integer.parseInt(unitsField.getText());
                double bill;
                if (units <= 100) {
                    bill = units * 5;
                }
                else if (units <= 200) {
                    bill = 100 * 5 + (units - 100) * 7;
                }
                else {
                    bill = 100 * 5 + 100 * 7 + (units - 200) * 10;
                }
                billField.setText("₹ " + bill);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                unitsField.setText("");
                billField.setText("");
            }
        });
        frame.setVisible(true);
    }
}