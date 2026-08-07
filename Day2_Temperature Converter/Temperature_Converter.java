import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Temperature_Converter extends JFrame implements ActionListener {
    JTextField text;
    JLabel result;
    JButton ctof, ftoc;
    public Temperature_Converter() {
        setTitle("Temperature Converter");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(new JLabel("Enter Temperature:"));
        text = new JTextField(10);
        add(text);
        ctof = new JButton("C to F");
        ftoc = new JButton("F to C");
        ctof.addActionListener(this);
        ftoc.addActionListener(this);
        add(ctof);
        add(ftoc);
        result = new JLabel("Result: ");
        add(result);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double temp = Double.parseDouble(text.getText());
        double ans;
        if (e.getSource() == ctof) {
            ans = (temp * 9 / 5) + 32;
            result.setText("Result: " + ans + " F");
        }
        else {
            ans = (temp - 32) * 5 / 9;
            result.setText("Result: " + ans + " C");
        }}

    public static void main(String[] args) {
        new Temperature_Converter();
    }
}