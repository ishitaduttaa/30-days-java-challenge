import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LibraryManagementSystem extends JFrame {
    JTextField bookField, authorField;
    JTable table;
    DefaultTableModel model;

    public LibraryManagementSystem() {
        setTitle("Library Management System");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.add(new JLabel("Book Name:"));
        bookField = new JTextField();
        inputPanel.add(bookField);
        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);
        add(inputPanel, BorderLayout.NORTH);
        // Table
        model = new DefaultTableModel(new String[]{"Book Name", "Author", "Status"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Book");
        JButton issueButton = new JButton("Issue");
        JButton returnButton = new JButton("Return");
        buttonPanel.add(addButton);
        buttonPanel.add(issueButton);
        buttonPanel.add(returnButton);
        add(buttonPanel, BorderLayout.SOUTH);
        // Add Book
        addButton.addActionListener(e -> {
            String book = bookField.getText().trim();
            String author = authorField.getText().trim();
            if (book.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter book and author");
                return;
            }
            model.addRow(new Object[]{book, author, "Available"});
            bookField.setText("");
            authorField.setText("");
        });
        // Issue Book
        issueButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a book");
            } else {
                model.setValueAt("Issued", row, 2);
            }});
        // Return Book
        returnButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Select a book");
            } else {
                model.setValueAt("Available", row, 2);
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new LibraryManagementSystem();
    }
}