import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovieTicketBooking extends JFrame implements ActionListener {

    JLabel nameLabel, movieLabel, timeLabel, ticketLabel, totalLabel;
    JTextField nameField;

    JComboBox<String> movieBox;
    JComboBox<String> timeBox;

    JSpinner ticketSpinner;
    JButton bookButton, clearButton;

    MovieTicketBooking() {
        setTitle("Movie Ticket Booking System");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // customer name
        nameLabel = new JLabel("Customer Name:");
        nameField = new JTextField();

        // movie
        movieLabel = new JLabel("Select Movie:");
        String[] movies = {"Avengers: Endgame", "Inception", "Interstellar", "The Dark Knight", "Spider-Man"};
        movieBox = new JComboBox<>(movies);

        // show time
        timeLabel = new JLabel("Show Time:");
        String[] times = {"10:00 AM", "1:00 PM", "4:00 PM", "7:00 PM", "10:00 PM"};
        timeBox = new JComboBox<>(times);

        // No. of tickets
        ticketLabel = new JLabel("Number of Tickets:");
        ticketSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));

        // total
        totalLabel = new JLabel("Ticket Price: ₹200 per ticket");

        // buttons
        bookButton = new JButton("Book Ticket");
        clearButton = new JButton("Clear");
        bookButton.addActionListener(this);
        clearButton.addActionListener(this);

        // add components
        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(movieLabel);
        panel.add(movieBox);

        panel.add(timeLabel);
        panel.add(timeBox);

        panel.add(ticketLabel);
        panel.add(ticketSpinner);
        panel.add(totalLabel);

        panel.add(new JLabel(""));
        panel.add(bookButton);
        panel.add(clearButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookButton) {
            String name = nameField.getText();
            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter customer name!");
                return;
            }
            String movie = (String) movieBox.getSelectedItem();
            String time = (String) timeBox.getSelectedItem();
            int tickets = (int) ticketSpinner.getValue();
            int pricePerTicket = 200;
            int totalPrice = tickets * pricePerTicket;
            String message = "BOOKING CONFIRMATION:\n" + "Customer: " + name + "\n" + "Movie: " + movie + "\n" + "Show Time: " + time + "\n" + "Tickets: " + tickets + "\n"
                            + "Price per Ticket: ₹" + pricePerTicket + "\n" + "Total Amount: ₹" + totalPrice + "\n\nThank you for booking!";
            JOptionPane.showMessageDialog(this, message, "Booking Successful",JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == clearButton) {
            nameField.setText("");
            movieBox.setSelectedIndex(0);
            timeBox.setSelectedIndex(0);
            ticketSpinner.setValue(1);
        }}

    public static void main(String[] args) {
        new MovieTicketBooking();
    }}