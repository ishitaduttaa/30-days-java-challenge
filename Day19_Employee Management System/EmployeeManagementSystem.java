import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EmployeeManagementSystem extends JFrame {
    JTextField idField, nameField, salaryField;
    JComboBox<String> departmentBox;
    JTable table;
    DefaultTableModel model;

    EmployeeManagementSystem() {
        setTitle("Employee Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Heading
        JLabel heading = new JLabel("Employee Management System");
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setHorizontalAlignment(JLabel.CENTER);
        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.add(new JLabel("Employee ID:"));
        idField = new JTextField();
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Department:"));
        String[] departments = {"IT", "HR", "Finance", "Marketing"};
        departmentBox = new JComboBox<>(departments);
        inputPanel.add(departmentBox);
        inputPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        inputPanel.add(salaryField);
        // Buttons
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        // Table
        String[] columns = {"ID", "Name", "Department", "Salary"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        // Add Employee
        addButton.addActionListener(e -> {
            if (idField.getText().isEmpty() || nameField.getText().isEmpty() || salaryField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields");
                return;
            }
            model.addRow(new Object[]{
                    idField.getText(), nameField.getText(), departmentBox.getSelectedItem(), salaryField.getText()
            });
            clearFields();
        });
        // Update Employee
        updateButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select an employee");
                return;
            }
            model.setValueAt(idField.getText(), row, 0);
            model.setValueAt(nameField.getText(), row, 1);
            model.setValueAt(departmentBox.getSelectedItem(), row, 2);
            model.setValueAt(salaryField.getText(), row, 3);
            clearFields();
        });

        // Delete Employee
        deleteButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select an employee");
                return;
            }
            model.removeRow(row);
            clearFields();
        });
        // Clear
        clearButton.addActionListener(e -> clearFields());
        // Select table row
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                idField.setText(model.getValueAt(row, 0).toString());
                nameField.setText(model.getValueAt(row, 1).toString());
                departmentBox.setSelectedItem(model.getValueAt(row, 2));
                salaryField.setText(model.getValueAt(row, 3).toString());
            }
        });
        // Main layout
        setLayout(new BorderLayout(10, 10));
        add(heading, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    void clearFields() {
        idField.setText("");
        nameField.setText("");
        salaryField.setText("");
        departmentBox.setSelectedIndex(0);
        table.clearSelection();
    }

    public static void main(String[] args) {
        new EmployeeManagementSystem();
    }
}