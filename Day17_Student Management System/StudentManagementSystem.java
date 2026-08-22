import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
public class StudentManagementSystem extends JFrame {
    JTextField idField, nameField, ageField, courseField;
    JTable table;
    DefaultTableModel model;
    StudentManagementSystem() {
        setTitle("Student Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        // Title
        JLabel title = new JLabel("Student Management System", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);
        // Form
        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.add(new JLabel("Student ID:"));
        idField = new JTextField();
        form.add(idField);
        form.add(new JLabel("Name:"));
        nameField = new JTextField();
        form.add(nameField);
        form.add(new JLabel("Age:"));
        ageField = new JTextField();
        form.add(ageField);
        form.add(new JLabel("Course:"));
        courseField = new JTextField();
        form.add(courseField);
        // Buttons
        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");
        JButton clearBtn = new JButton("Clear");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(clearBtn);
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(form, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.CENTER);
        // Table
        model = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Course"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.SOUTH);
        // Add
        addBtn.addActionListener(e -> {
            if (idField.getText().isEmpty() || nameField.getText().isEmpty() || ageField.getText().isEmpty() || courseField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields");
                return;
            }
            model.addRow(new Object[]{idField.getText(), nameField.getText(), ageField.getText(), courseField.getText()});
            clearFields();
        });
        // Update
        updateBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a student first");
                return;
            }
            model.setValueAt(idField.getText(), row, 0);
            model.setValueAt(nameField.getText(), row, 1);
            model.setValueAt(ageField.getText(), row, 2);
            model.setValueAt(courseField.getText(), row, 3);
            clearFields();
        });
        // Delete
        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a student first");
                return;}
            model.removeRow(row);
            clearFields();
        });
        clearBtn.addActionListener(e -> clearFields());
        // Select table row
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                idField.setText(model.getValueAt(row, 0).toString());
                nameField.setText(model.getValueAt(row, 1).toString());
                ageField.setText(model.getValueAt(row, 2).toString());
                courseField.setText(model.getValueAt(row, 3).toString());
            }});
        setVisible(true);
    }
    void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        courseField.setText("");
        table.clearSelection();}
    public static void main(String[] args) {
        new StudentManagementSystem();
    }
}