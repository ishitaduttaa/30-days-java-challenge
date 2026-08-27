import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class InventoryManagementSystem extends JFrame {
    JTextField idField, nameField, priceField, quantityField;
    JTable table;
    DefaultTableModel model;

    InventoryManagementSystem() {
        setTitle("Inventory Management System");
        setSize(700, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.add(new JLabel("Product ID:"));
        idField = new JTextField();
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Product Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);
        JButton addButton = new JButton("Add Product");
        JButton clearButton = new JButton("Clear");
        inputPanel.add(addButton);
        inputPanel.add(clearButton);
        add(inputPanel, BorderLayout.NORTH);

        // Table
        String[] columns = {"ID", "Name", "Price", "Quantity"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton updateButton = new JButton("Update Quantity");
        JButton deleteButton = new JButton("Delete Product");
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);
        // Add Product
        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String price = priceField.getText();
            String quantity = quantityField.getText();
            if (id.isEmpty() || name.isEmpty() || price.isEmpty() || quantity.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter all details");
                return;}
            model.addRow(new Object[]{id, name, price, quantity});
            clearFields();
        });
        // Clear
        clearButton.addActionListener(e -> clearFields());
        // Update Quantity
        updateButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a product first");
                return;
            }
            String newQuantity = JOptionPane.showInputDialog(
                    this, "Enter new quantity:");
            if (newQuantity != null && !newQuantity.isEmpty()) {
                model.setValueAt(newQuantity, row, 3);
            }});
        // Delete
        deleteButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a product first");
                return;
            }
            model.removeRow(row);});
        setVisible(true);
    }

    void clearFields() {
        idField.setText("");nameField.setText("");priceField.setText("");quantityField.setText("");
    }
    public static void main(String[] args) {
        new InventoryManagementSystem();
    }
}