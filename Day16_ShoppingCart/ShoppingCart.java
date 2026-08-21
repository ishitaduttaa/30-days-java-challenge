import javax.swing.*;
import java.awt.*;

public class ShoppingCart extends JFrame {
    JComboBox<String> productBox;
    JTextField quantityField;
    JTextArea cartArea;
    JLabel totalLabel;
    double total = 0;
    String[] products = {"Laptop", "Stationary", "Dress", "Beauty Cream", "Phone"};
    double[] prices = {50000, 2000, 1500, 800, 12000};

    public ShoppingCart() {
        setTitle("Shopping Cart");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        // Title
        JLabel title = new JLabel("SHOPPING CART", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title, BorderLayout.NORTH);
        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.add(new JLabel("Product:"));
        productBox = new JComboBox<>(products);
        inputPanel.add(productBox);
        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField("1");
        inputPanel.add(quantityField);
        // Center panel
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(inputPanel, BorderLayout.NORTH);
        JButton addButton = new JButton("Add to Cart");
        addButton.setPreferredSize(new Dimension(120, 30));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        cartArea = new JTextArea();
        cartArea.setEditable(false);
        cartArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(cartArea);
        centerPanel.add(scrollPane, BorderLayout.SOUTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        // Bottom panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        totalLabel = new JLabel("Total: ₹0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JButton clearButton = new JButton("Clear Cart");
        bottomPanel.add(totalLabel, BorderLayout.WEST);
        bottomPanel.add(clearButton, BorderLayout.EAST);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        // Add to cart
        addButton.addActionListener(e -> {
            int quantity = Integer.parseInt(quantityField.getText());
            int index = productBox.getSelectedIndex();
            String product = products[index];
            double price = prices[index];
            double itemTotal = price * quantity;
            total += itemTotal;
            cartArea.append(product + " x " + quantity + " = ₹" + String.format("%.2f", itemTotal) + "\n");
            totalLabel.setText("Total: ₹" + String.format("%.2f", total));
            quantityField.setText("1");
        });
        clearButton.addActionListener(e -> {
            cartArea.setText("");
            total = 0;
            totalLabel.setText("Total: ₹0.00");
        });
        add(panel);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShoppingCart::new);
    }
}