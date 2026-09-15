import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuizApplication extends JFrame implements ActionListener {
    String[] questions = {
            "Which language is used for Android development?",
            "Which keyword is used to inherit a class in Java?",
            "Which collection does NOT allow duplicate elements?",
            "What is the size of an int in Java?",
            "Which method is the entry point of a Java program?"
    };

    String[][] options = {
            {"Java", "Python", "HTML", "SQL"},
            {"this", "super", "extends", "implements"},
            {"List", "Set", "Map", "ArrayList"},
            {"8 bits", "16 bits", "32 bits", "64 bits"},
            {"start()", "run()", "main()", "execute()"}
    };

    int[] answers = {0, 2, 1, 2, 2};
    int currentQuestion = 0;
    int score = 0;
    JLabel questionLabel;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup group;
    JButton nextButton;

    QuizApplication() {
        setTitle("Java Quiz Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Question
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(questionLabel, BorderLayout.NORTH);

        // Options
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        option1 = new JRadioButton();
        option2 = new JRadioButton();
        option3 = new JRadioButton();
        option4 = new JRadioButton();

        group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        group.add(option4);

        optionsPanel.add(option1);
        optionsPanel.add(option2);
        optionsPanel.add(option3);
        optionsPanel.add(option4);
        panel.add(optionsPanel, BorderLayout.CENTER);

        // Next button
        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        panel.add(nextButton, BorderLayout.SOUTH);
        add(panel);
        loadQuestion();
        setVisible(true);
    }

    void loadQuestion() {
        questionLabel.setText("Q" + (currentQuestion + 1) + ". " + questions[currentQuestion]);

        option1.setText(options[currentQuestion][0]);
        option2.setText(options[currentQuestion][1]);
        option3.setText(options[currentQuestion][2]);
        option4.setText(options[currentQuestion][3]);
        group.clearSelection();

        if (currentQuestion == questions.length - 1) {
            nextButton.setText("Submit");
        }}

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedAnswer = -1;
        if (option1.isSelected()) {
            selectedAnswer = 0;
        } else if (option2.isSelected()) {
            selectedAnswer = 1;
        } else if (option3.isSelected()) {
            selectedAnswer = 2;
        } else if (option4.isSelected()) {
            selectedAnswer = 3;
        }

        // No option selected
        if (selectedAnswer == -1) {
            JOptionPane.showMessageDialog(this, "Please select an answer!");
            return;
        }

        // Check answer
        if (selectedAnswer == answers[currentQuestion]) {
            score++;
        }
        currentQuestion++;
        // Quiz finished
        if (currentQuestion == questions.length) {
            JOptionPane.showMessageDialog(this, "Quiz Completed!\n\n" + "Your Score: " + score + " / " + questions.length);
            nextButton.setEnabled(false);

        } else {
            loadQuestion();
        }}

    public static void main(String[] args) {
        new QuizApplication();
    }
}