import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ContactBook extends JFrame {
    JTextField nameField, phoneField, emailField, searchField;
    JTable table;
    DefaultTableModel model;

    ContactBook() {
        setTitle("Contact Book");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        JPanel topPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        topPanel.add(nameField);
        topPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        topPanel.add(phoneField);
        topPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        topPanel.add(emailField);
        add(topPanel, BorderLayout.NORTH);

        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Phone");
        model.addColumn("Email");
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new FlowLayout());

        JButton addButton = new JButton("Add Contact");
        JButton deleteButton = new JButton("Delete");
        JButton clearButton = new JButton("Clear");
        searchField = new JTextField(15);
        JButton searchButton = new JButton("Search");
        bottomPanel.add(addButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(clearButton);
        bottomPanel.add(new JLabel("Search:"));
        bottomPanel.add(searchField);
        bottomPanel.add(searchButton);
        add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields!");
            } else {
                model.addRow(new Object[]{name, phone, email});
                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
            }
        });
        deleteButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a contact!");
            } else {
                model.removeRow(row);
            }
        });
        clearButton.addActionListener(e -> {
            nameField.setText("");
            phoneField.setText("");
            emailField.setText("");
        });
        searchButton.addActionListener(e -> {
            String search = searchField.getText().toLowerCase();
            for (int i = 0; i < table.getRowCount(); i++) {
                String name = table.getValueAt(i, 0).toString().toLowerCase();
                if (name.contains(search)) {
                    table.setRowSelectionInterval(i, i);
                    return;
                }
            }JOptionPane.showMessageDialog(this, "Contact not found!");
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ContactBook();
    }
}