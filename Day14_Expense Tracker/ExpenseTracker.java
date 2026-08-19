import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExpenseTracker extends JFrame implements ActionListener {
    JTextField nameField, amountField;
    JButton addButton;
    JLabel totalLabel;
    JTextArea expenseArea;
    double total = 0;
    ExpenseTracker() {
        setTitle("Expense Tracker");
        setSize(400, 400);
        setLayout(new FlowLayout());
        JLabel nameLabel = new JLabel("Expense Name:");
        nameField = new JTextField(15);
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);
        addButton = new JButton("Add Expense");
        expenseArea = new JTextArea(12, 30);
        expenseArea.setEditable(false);
        totalLabel = new JLabel("Total: ₹0");
        add(nameLabel);
        add(nameField);
        add(amountLabel);
        add(amountField);
        add(addButton);
        add(new JScrollPane(expenseArea));
        add(totalLabel);
        addButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        double amount = Double.parseDouble(amountField.getText());
        total = total + amount;
        expenseArea.append(name + " - ₹" + amount + "\n");
        totalLabel.setText("Total: ₹" + total);
        nameField.setText("");
        amountField.setText("");
    }
    public static void main(String[] args) {
        new ExpenseTracker();
    }
}