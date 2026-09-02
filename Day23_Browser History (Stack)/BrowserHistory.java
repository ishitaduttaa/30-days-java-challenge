import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class BrowserHistory extends JFrame {
    JTextField urlField;
    JLabel pageLabel;

    Stack<String> backStack = new Stack<>();
    Stack<String> forwardStack = new Stack<>();

    String currentPage = "Home";
    JButton visitButton, backButton, forwardButton;
    BrowserHistory() {
        setTitle("Browser History");setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Top panel
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        urlField = new JTextField();
        visitButton = new JButton("Visit");
        topPanel.add(urlField, BorderLayout.CENTER);
        topPanel.add(visitButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // Center
        pageLabel = new JLabel("Current Page: Home", SwingConstants.CENTER);
        pageLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(pageLabel, BorderLayout.CENTER);

        // Bottom buttons
        JPanel bottomPanel = new JPanel();
        backButton = new JButton("← Back");
        forwardButton = new JButton("Forward →");
        bottomPanel.add(backButton);
        bottomPanel.add(forwardButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Visit button
        visitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newPage = urlField.getText();
                if (!newPage.isEmpty()) {
                    backStack.push(currentPage);currentPage = newPage;
                    forwardStack.clear();updatePage();
                    urlField.setText("");
                }}});

        // Back button
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!backStack.isEmpty()) {
                    forwardStack.push(currentPage);
                    currentPage = backStack.pop();
                    updatePage();
                } else {
                    JOptionPane.showMessageDialog(BrowserHistory.this, "No previous page!");
                }}});

        // Forward button
        forwardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!forwardStack.isEmpty()) {
                    backStack.push(currentPage);
                    currentPage = forwardStack.pop();
                    updatePage();
                } else {
                    JOptionPane.showMessageDialog(BrowserHistory.this, "No forward page!");
                }}});
        setLocationRelativeTo(null);
        setVisible(true);
    }
    void updatePage() {
        pageLabel.setText("Current Page: " + currentPage);
    }
    public static void main(String[] args) {
        new BrowserHistory();
    }
}