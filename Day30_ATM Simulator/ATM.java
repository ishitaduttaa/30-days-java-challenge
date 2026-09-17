import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATM extends JFrame implements ActionListener {
    double balance = 10000;
    JButton check, deposit, withdraw, exit;
    JTextField amount;

    ATM() {
        setTitle("ATM Simulator");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel title = new JLabel("ATM SIMULATOR", SwingConstants.CENTER);

        amount = new JTextField();
        amount.setBorder(BorderFactory.createTitledBorder("Enter Amount"));

        check = new JButton("Check Balance");
        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        exit = new JButton("Exit");

        check.addActionListener(this);
        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        exit.addActionListener(this);

        add(title);
        add(amount);
        add(check);
        add(deposit);
        add(withdraw);
        add(exit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            JOptionPane.showMessageDialog(this, "Balance = ₹" + balance);
        }
        else if (e.getSource() == deposit) {
            double money = Double.parseDouble(amount.getText());
            balance = balance + money;
            JOptionPane.showMessageDialog(this, "Deposited ₹" + money + "\nBalance = ₹" + balance);
            amount.setText("");
        }
        else if (e.getSource() == withdraw) {
            double money = Double.parseDouble(amount.getText());
            if (money <= balance) {
                balance = balance - money;
                JOptionPane.showMessageDialog(this, "Withdrawn ₹" + money + "\nBalance = ₹" + balance);
            } else {
                JOptionPane.showMessageDialog(this, "Insufficient Balance!");
            }
            amount.setText("");
        }
        else if (e.getSource() == exit) {
            JOptionPane.showMessageDialog(this, "Thank you!");
            System.exit(0);
        }}

    public static void main(String[] args) {
        new ATM();
    }
}