import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PhoneDirectory {
    static HashMap<String, String> contacts = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Phone Directory");
        frame.setSize(450, 400);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField(20);
        JButton addButton = new JButton("Add Contact");
        JButton searchButton = new JButton("Search");
        JButton deleteButton = new JButton("Delete");
        JTextArea output = new JTextArea(12, 35);
        output.setEditable(false);
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            if (name.isEmpty() || phone.isEmpty()) {
                output.setText("Please enter name and phone number.");
            } else {
                contacts.put(name, phone);
                output.setText("Contact Added!\nName: " + name + "\nPhone: " + phone);
                nameField.setText("");
                phoneField.setText("");
            }});

        searchButton.addActionListener(e -> {
            String name = nameField.getText();
            if (contacts.containsKey(name)) {
                String phone = contacts.get(name);
                output.setText("Contact Found!\nName: " + name + "\nPhone: " + phone);
            } else {
                output.setText("Contact not found.");
            }
        });

        deleteButton.addActionListener(e -> {
            String name = nameField.getText();
            if (contacts.containsKey(name)) {
                contacts.remove(name);
                output.setText("Contact deleted.");
            } else {
                output.setText("Contact not found.");
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(phoneLabel);
        frame.add(phoneField);
        frame.add(addButton);
        frame.add(searchButton);
        frame.add(deleteButton);
        frame.add(new JScrollPane(output));
        frame.setVisible(true);
    }
}