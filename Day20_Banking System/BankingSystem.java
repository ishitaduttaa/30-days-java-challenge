import javax.swing.*;
import java.awt.*;

public class BankingSystem extends JFrame {
    JTextField nameField, accountField, amountField;
    JTextArea display;
    double balance = 0;
    BankingSystem() {
        setTitle("Banking System");  setSize(500, 500); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:"); nameField = new JTextField(20);
        JLabel accountLabel = new JLabel("Account No:"); accountField = new JTextField(20);
        JLabel amountLabel = new JLabel("Amount:"); amountField = new JTextField(20);
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton balanceButton = new JButton("Check Balance");
        display = new JTextArea(15, 40);
        display.setEditable(false);

        add(nameLabel);
        add(nameField);
        add(accountLabel);
        add(accountField);
        add(amountLabel);
        add(amountField);
        add(depositButton);
        add(withdrawButton);
        add(balanceButton);
        add(new JScrollPane(display));

        depositButton.addActionListener(e -> deposit());
        withdrawButton.addActionListener(e -> withdraw());
        balanceButton.addActionListener(e -> checkBalance());
        setVisible(true);
    }
    void deposit() {
        double amount = Double.parseDouble(amountField.getText());
        if (amount <= 0) {
            JOptionPane.showMessageDialog(this, "Enter a valid amount");
            return;
        }
        balance += amount;
        display.append("Deposited: ₹" + amount + "\n");
        display.append("Balance: ₹" + balance + "\n\n");
        amountField.setText("");
    }

    void withdraw() {
        double amount = Double.parseDouble(amountField.getText());
        if (amount <= 0) {
            JOptionPane.showMessageDialog(this, "Enter a valid amount");
            return;
        }
        if (amount > balance) {
            JOptionPane.showMessageDialog(this, "Insufficient balance");
            return;
        }
        balance -= amount;
        display.append("Withdrawn: ₹" + amount + "\n");
        display.append("Balance: ₹" + balance + "\n\n");
        amountField.setText("");
    }

    void checkBalance() {
        display.append("Account Holder: " + nameField.getText() + "\n");
        display.append("Account No: " + accountField.getText() + "\n");
        display.append("Current Balance: ₹" + balance + "\n\n");
    }
    public static void main(String[] args) {
        new BankingSystem();
    }
}