import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WordCounter extends JFrame implements ActionListener {
    JTextArea textArea;
    JButton countButton;
    JLabel result;
    WordCounter() {
        setTitle("Word Counter");
        setSize(500, 400);
        setLayout(new FlowLayout());
        textArea = new JTextArea(12, 40);
        countButton = new JButton("Count Words");
        result = new JLabel("Words: 0");
        add(new JScrollPane(textArea));
        add(countButton);
        add(result);
        countButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String text = textArea.getText().trim();
        if (text.isEmpty()) {
            result.setText("Words: 0");
        } else {
            String[] words = text.split("\\s+");
            result.setText("Words: " + words.length);
        }
    }
    public static void main(String[] args) {
        new WordCounter();
    }
}