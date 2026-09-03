import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class HospitalQueue extends JFrame {
    Queue<String> patients = new LinkedList<>();
    JTextField patientField;
    JTextArea queueArea;
    HospitalQueue() {
        setTitle("Hospital Queue");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Heading
        JLabel title = new JLabel("🏥 Hospital Patient Queue", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(title, BorderLayout.NORTH);

        // Input section
        JPanel inputPanel = new JPanel();
        patientField = new JTextField(15);
        JButton addButton = new JButton("Add Patient");
        JButton serveButton = new JButton("Serve Patient");
        inputPanel.add(new JLabel("Patient Name:"));
        inputPanel.add(patientField);
        inputPanel.add(addButton);
        inputPanel.add(serveButton);
        panel.add(inputPanel, BorderLayout.CENTER);

        // Queue display
        queueArea = new JTextArea();
        queueArea.setFont(new Font("Arial", Font.PLAIN, 18));
        queueArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(queueArea);
        panel.add(scrollPane, BorderLayout.SOUTH);

        // Add patient
        addButton.addActionListener(e -> {
            String name = patientField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter patient name.");
                return;
            }
            patients.add(name);
            patientField.setText("");
            displayQueue();
        });

        // Serve patient
        serveButton.addActionListener(e -> {
            if (patients.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No patients in the queue.");
                return;
            }
            String patient = patients.poll();
            JOptionPane.showMessageDialog(this,"Now serving: " + patient);
            displayQueue();
        });
        add(panel);
        displayQueue();
    }

    void displayQueue() {
        queueArea.setText("Current Patient Queue:\n");
        if (patients.isEmpty()) {
            queueArea.append("No patients waiting.");
            return;
        }
        int number = 1;
        for (String patient : patients) {
            queueArea.append(number + ". " + patient + "\n");
            number++;
        }}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HospitalQueue().setVisible(true);
        });
    }}