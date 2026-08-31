import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RestaurantOrderingSystem extends JFrame implements ActionListener {
    JComboBox<String> foodBox;
    JTextField quantityField;
    JTextArea orderArea;
    JLabel priceLabel;
    JLabel totalLabel;
    JButton addButton, clearButton, billButton;
    double total = 0;
    String[] foods = {"Pizza", "Burger", "Pasta", "Sandwich", "Fries", "Cold Drink"};
    double[] prices = {250, 150, 200, 120, 100, 80};

    RestaurantOrderingSystem() {
        setTitle("Restaurant Ordering System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel heading = new JLabel("Restaurant Ordering System");
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setHorizontalAlignment(JLabel.CENTER);
        foodBox = new JComboBox<>(foods);
        priceLabel = new JLabel("Price: ₹250");
        quantityField = new JTextField();
        addButton = new JButton("Add to Order");
        clearButton = new JButton("Clear");
        billButton = new JButton("Generate Bill");
        orderArea = new JTextArea();
        orderArea.setEditable(false);
        orderArea.setText("Food\tQuantity\tPrice\n");
        orderArea.append("--------------------------------\n");
        totalLabel = new JLabel("Total: ₹0");

        // Update price when food is selected
        foodBox.addActionListener(e -> {
            int index = foodBox.getSelectedIndex();
            priceLabel.setText("Price: ₹" + prices[index]);
        });

        // Add item
        addButton.addActionListener(this);
        clearButton.addActionListener(this);
        billButton.addActionListener(this);
        JPanel topPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        topPanel.add(new JLabel("Food:"));
        topPanel.add(foodBox);
        topPanel.add(new JLabel("Price:"));
        topPanel.add(priceLabel);
        topPanel.add(new JLabel("Quantity:"));
        topPanel.add(quantityField);
        topPanel.add(addButton);
        topPanel.add(clearButton);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(totalLabel);
        bottomPanel.add(billButton);
        setLayout(new BorderLayout(10, 10));
        add(heading, BorderLayout.NORTH);
        add(topPanel, BorderLayout.CENTER);
        add(new JScrollPane(orderArea), BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.EAST);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Add food to order
        if (e.getSource() == addButton) {
            try {
                int quantity = Integer.parseInt(quantityField.getText());
                if (quantity <= 0) {JOptionPane.showMessageDialog(this, "Enter a valid quantity!");
                    return;}
                int index = foodBox.getSelectedIndex();
                String food = foods[index];
                double price = prices[index];
                double itemTotal = price * quantity;
                total += itemTotal;
                orderArea.append(food + "\t" + quantity + "\t₹" + itemTotal + "\n");
                totalLabel.setText("Total: ₹" + total);
                quantityField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid quantity!");}}

        // Clear order
        if (e.getSource() == clearButton) {
            total = 0;
            orderArea.setText("Food\tQuantity\tPrice\n");
            orderArea.append("--------------------------------\n");
            totalLabel.setText("Total: ₹0");
        }

        // Generate bill
        if (e.getSource() == billButton) {
            if (total == 0) {
                JOptionPane.showMessageDialog(this, "Please add some food first!");
            } else {
                double tax = total * 0.05;
                double finalAmount = total + tax;
                JOptionPane.showMessageDialog(
                        this, "Subtotal: ₹" + total + "\nTax (5%): ₹" + tax + "\n------------------" + "\nFinal Amount: ₹" + finalAmount + "\n\nThank you for ordering!"
                );}}}

    public static void main(String[] args) {
        new RestaurantOrderingSystem();
    }
}