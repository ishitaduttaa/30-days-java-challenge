import javax.swing.*;
import java.awt.event.*;

public class SimpleInterest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Interest");
        JLabel pLabel = new JLabel("Principal:");
        pLabel.setBounds(30, 30, 100, 30);
        JTextField pField = new JTextField();
        pField.setBounds(130, 30, 150, 30);
        JLabel rLabel = new JLabel("Rate:");
        rLabel.setBounds(30, 80, 100, 30);
        JTextField rField = new JTextField();
        rField.setBounds(130, 80, 150, 30);
        JLabel tLabel = new JLabel("Time:");
        tLabel.setBounds(30, 130, 100, 30);
        JTextField tField = new JTextField();
        tField.setBounds(130, 130, 150, 30);
        JButton button = new JButton("Calculate");
        button.setBounds(100, 180, 120, 30);
        JLabel result = new JLabel("Result:");
        result.setBounds(100, 230, 200, 30);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                double p = Double.parseDouble(pField.getText());
                double r = Double.parseDouble(rField.getText());
                double t = Double.parseDouble(tField.getText());
                double si = (p * r * t) / 100;
                result.setText("Result: " + si);
            }
        });
        frame.add(pLabel);
        frame.add(pField);
        frame.add(rLabel);
        frame.add(rField);
        frame.add(tLabel);
        frame.add(tField);
        frame.add(button);
        frame.add(result);
        frame.setSize(350, 320);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}